package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Cart;
import com.catalyst.dronedelivery.data.model.CartItem;
import com.catalyst.dronedelivery.data.model.Product;
import com.catalyst.dronedelivery.data.repository.CartRepo;
import com.catalyst.dronedelivery.data.repository.ProductRepo;
import com.catalyst.dronedelivery.exception.DroneAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    @Override
    public Cart addCart() {
        Cart newCart = new Cart();
        newCart.setCartItems(new ArrayList<>());
        newCart.setTotalWeightOfProduct(0.0);
        newCart.setTotalAmountOfProduct(0.0);

        return cartRepo.save(newCart);
    }

    @Override
    public String addItemToCart(Cart cart, Product product, int quantity) {
        Cart existingCart = cartRepo.findById(cart.getId()).orElseThrow(() -> new DroneAppException("Cart not Found"));
        Product existingProduct = productRepo.findById(product.getId()).orElseThrow(() -> new DroneAppException("Cannot find Product"));
        CartItem existingItem = findCartItemByProduct(existingCart, existingProduct);
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            CartItem newItem = CartItem.builder()
                    .product(existingProduct)
                    .quantity(quantity)
                    .build();

            existingCart.getCartItems().add(newItem);
            newItem.setCart(existingCart);

        }
        calculateAndUpdateCartTotals(existingCart);
         cartRepo.save(existingCart);
        return "Added to Cart Successfully";
    }

    private void calculateAndUpdateCartTotals(Cart cart) {
        double totalWeight = cart.getCartItems().stream()
                .mapToDouble(item -> item.getProduct().getProductWeight() * item.getQuantity())
                .sum();

        double totalAmount = cart.getCartItems().stream()
                .mapToDouble(item -> item.getProduct().getProductAmount()* item.getQuantity())
                .sum();

        cart.setTotalWeightOfProduct(totalWeight);
        cart.setTotalAmountOfProduct(totalAmount);

    }

    private CartItem findCartItemByProduct(Cart cart, Product product) {
        return cart.getCartItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CartItem findCartItemByProductName(Cart cart, String productName) {
        String name = productName.toLowerCase();

        return cart.getCartItems().stream()
                .filter(item -> item.getProduct().getName().toLowerCase().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Cart findCartByCartId(Long id) {
        return cartRepo.findById(id).orElseThrow(() -> new DroneAppException("Cart not Found"));
    }

    @Override
    public String removeItemFromCart(Cart cart, Product product) {
        CartItem itemToRemove = findCartItemByProduct(cart, product);
        if (itemToRemove != null) {
            int currentQuantity = itemToRemove.getQuantity();
            if (currentQuantity > 1) {
                itemToRemove.setQuantity(currentQuantity - 1);
            } else {
                cart.getCartItems().remove(itemToRemove);
                itemToRemove.setCart(null);
            }

            calculateAndUpdateCartTotals(cart);
            cartRepo.save(cart);
            return "Item has been removed successfully";
        } else {
            return "Item is not in this Cart";
        }

    }


    @Override
    public String  updateCartItemQuantity(Cart cart, Product product, int quantity) {
        CartItem cartItem = findCartItemByProduct(cart, product);
        if (cartItem != null) {
            int currentQuantity = cartItem.getQuantity();
            if(currentQuantity >= 1){
                cartItem.setQuantity(currentQuantity + quantity);
            } else {
                cartItem.setQuantity(quantity);
            }

            calculateAndUpdateCartTotals(cart);
            cartRepo.save(cart);
        }

        return "Cart update is successfully";

    }
}
