package com.catalyst.dronedelivery.data.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_weight", nullable = false)
    private double productWeight;

    @Column(name = "product_amount", nullable = false)
    private double productAmount;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
}
