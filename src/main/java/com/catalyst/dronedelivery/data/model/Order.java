package com.catalyst.dronedelivery.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_weight", nullable = false)
    private double totalWeightOfProduct;

    @Column(name = "total_amount", nullable = false)
    private double totalAmountOfProduct;

//    @OneToMany(mappedBy = "order",
//            orphanRemoval = true,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @Column(name = "product", nullable = false)
//    private List<Product> orderedProducts = new ArrayList<>();


   // private long cartId; //the user will get the full; cart as a response but only the cartid will be in the database

    @Column(name = "order_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime creationTime;

    @OneToOne
    @JoinColumn(name = "drone_id")
    @JsonIgnore
    private Drone drone;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;






}
