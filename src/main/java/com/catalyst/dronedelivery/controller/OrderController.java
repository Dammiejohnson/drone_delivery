package com.catalyst.dronedelivery.controller;

import com.catalyst.dronedelivery.data.model.Order;
import com.catalyst.dronedelivery.dtos.responses.PurchaseOrderResponse;
import com.catalyst.dronedelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/droneDelivery")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/purchaseOrder/{userId}")
    public ResponseEntity<?> addPurchase(@PathVariable Long userId,
                                         @RequestParam Long cartId,
                                         @RequestBody Order order){

        PurchaseOrderResponse response = orderService.purchaseOrder(userId, cartId, order);
        return  new ResponseEntity<>(response, HttpStatus.OK);



    }
}
