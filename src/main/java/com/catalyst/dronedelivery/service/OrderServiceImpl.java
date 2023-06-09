package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Cart;
import com.catalyst.dronedelivery.data.model.Drone;
import com.catalyst.dronedelivery.data.model.Order;
import com.catalyst.dronedelivery.data.model.User;
import com.catalyst.dronedelivery.data.repository.CartRepo;
import com.catalyst.dronedelivery.data.repository.DroneRepo;
import com.catalyst.dronedelivery.data.repository.OrderRepo;
import com.catalyst.dronedelivery.data.repository.UserRepo;
import com.catalyst.dronedelivery.dtos.requests.DroneDto;
import com.catalyst.dronedelivery.dtos.requests.UserDto;
import com.catalyst.dronedelivery.dtos.responses.PurchaseOrderResponse;
import com.catalyst.dronedelivery.exception.DroneAppException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final CartRepo cartRepo;
    private final DroneRepo droneRepo;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public PurchaseOrderResponse purchaseOrder(Long userId, Long cartId) {
        User existingUser = userRepo.findById(userId).orElseThrow(() -> new DroneAppException("User not Found"));
        Cart existingCart = cartRepo.findById(cartId).orElseThrow(() -> new DroneAppException("Cart not Found"));
            Order newOrder = Order.builder()
                    .user(existingUser)
                    .cart(existingCart)
                    .creationTime(LocalDateTime.now())
                    .build();

        Drone drone = getDrone(existingCart, newOrder);
        DroneDto droneDto = new DroneDto();
        mapper.map(drone, droneDto);

        UserDto userDTO = new UserDto();
        mapper.map(existingUser, userDTO);

        orderRepo.save(newOrder);
        PurchaseOrderResponse response = PurchaseOrderResponse.builder()
                .user(userDTO)
                .cart(existingCart)
                .order(newOrder)
                .drone(droneDto)
                .build();

        return response;
    }

    private Drone getDrone(Cart existingCart, Order newOrder) {
        if(existingCart.getTotalWeightOfProduct() <= 10000){
            newOrder.setDrone(droneRepo.findById(1L).get());}
            else if(existingCart.getTotalWeightOfProduct() <= 20000){
            newOrder.setDrone(droneRepo.findById(2L).get());}
            else if(existingCart.getTotalWeightOfProduct() <= 30000){
            newOrder.setDrone(droneRepo.findById(3L).get());}
            else if(existingCart.getTotalWeightOfProduct() <= 40000){
            newOrder.setDrone(droneRepo.findById(5L).get());}
            else if(existingCart.getTotalWeightOfProduct() <= 50000){
            newOrder.setDrone(droneRepo.findById(6L).get());}
            else {
           throw  new DroneAppException("Drone for this weight is not available!!");
        }
            return newOrder.getDrone();
    }

}
