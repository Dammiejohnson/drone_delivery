package com.catalyst.dronedelivery.dtos.responses;

import com.catalyst.dronedelivery.data.model.Cart;
import com.catalyst.dronedelivery.data.model.Drone;
import com.catalyst.dronedelivery.data.model.Order;
import com.catalyst.dronedelivery.data.model.User;
import com.catalyst.dronedelivery.dtos.requests.DroneDto;
import com.catalyst.dronedelivery.dtos.requests.UserDto;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderResponse {
    private Order order;
    private Cart cart;
    private UserDto user;
    private DroneDto drone;


}
