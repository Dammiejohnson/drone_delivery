package com.catalyst.dronedelivery.dtos.requests;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneDto {
    private String droneName;
    private double weightLimit;
    private double droneFee;
}
