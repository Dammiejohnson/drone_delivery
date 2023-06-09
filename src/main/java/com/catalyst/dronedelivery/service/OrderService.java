package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Order;
import com.catalyst.dronedelivery.data.model.User;
import com.catalyst.dronedelivery.dtos.responses.PurchaseOrderResponse;

public interface OrderService {
    PurchaseOrderResponse purchaseOrder(Long userId, Long cartId);
}
