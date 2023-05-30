package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Cart;
import com.catalyst.dronedelivery.data.model.CartItem;
import com.catalyst.dronedelivery.data.model.Product;

public interface CartService {

    Cart addCart();
    String addItemToCart(Cart cart, Product product, int quantity);
    CartItem findCartItemByProductName(Cart cart, String productName);

    Cart findCartByCartId(Long id);
    String removeItemFromCart(Cart cart, Product product);
    String updateCartItemQuantity(Cart cart, Product product, int quantity);
}
