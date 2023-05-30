package com.catalyst.dronedelivery.dtos.requests;

import lombok.*;
import org.springframework.validation.annotation.Validated;



@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private double productWeight;
    private double productAmount;
}
