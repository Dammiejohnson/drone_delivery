package com.catalyst.dronedelivery.controller;

import com.catalyst.dronedelivery.data.model.Cart;
import com.catalyst.dronedelivery.data.model.Product;
import com.catalyst.dronedelivery.service.CartService;
import com.catalyst.dronedelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/droneDelivery")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private  final ProductService productService;

    @PostMapping("/addNewCart")
    public ResponseEntity<Cart> addCart(){
        var response = cartService.addCart();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/addItem/{cartId}")
    public ResponseEntity<?> addItemToCart(@PathVariable Long cartId,
                                                @RequestParam Long productId,
                                                @RequestParam int quantity) {
        Cart cart = cartService.findCartByCartId(cartId);
        Product product = productService.findProductById(productId);
         var response = cartService.addItemToCart(cart, product, quantity);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getCart/{cartId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId) {
        var response = cartService.findCartByCartId(cartId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/removeItem/{cartId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable Long cartId,
                                                     @RequestParam Long productId) {
        Cart cart = cartService.findCartByCartId(cartId);
        Product product = productService.findProductById(productId);
        var response = cartService.removeItemFromCart(cart, product);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/updateItemQuantity/{cartId}")
    public ResponseEntity<String> updateItemQuantity(@PathVariable Long cartId,
                                                     @RequestParam Long productId,
                                                     @RequestParam int quantity) {
        Cart cart = cartService.findCartByCartId(cartId);
        Product product = productService.findProductById(productId);
         var response = cartService.updateCartItemQuantity(cart, product, quantity);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

