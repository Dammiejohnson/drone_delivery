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
@Table(name = "drones")
public class Drone {

    @Id
    @Column(name = "drone_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drone_name", nullable = false)
    private String name;

    @Column(name = "weight_limit_in_grammes", nullable = false)
    private double weightLimit;

    @Column(name = "drone_fee", nullable = false)
    private double droneFee;


    @OneToOne(mappedBy = "drone",
            orphanRemoval = false,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Order order;
}
