package com.catalyst.dronedelivery.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<CartItem> cartItems = new ArrayList<>();

    @Column(name = "total_weight", nullable = true)
    private double totalWeightOfProduct;

    @Column(name = "total_amount", nullable = true)
    private double totalAmountOfProduct;


    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;





}
