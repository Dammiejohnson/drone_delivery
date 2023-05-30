package com.catalyst.dronedelivery.controller;

import com.catalyst.dronedelivery.data.model.Drone;
import com.catalyst.dronedelivery.data.model.Product;
import com.catalyst.dronedelivery.dtos.requests.DroneDto;
import com.catalyst.dronedelivery.dtos.requests.ProductDto;
import com.catalyst.dronedelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/droneDelivery")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        var response = productService.addProduct(productDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findProductId")
    public ResponseEntity<Product> findProduct(@RequestParam Long id) {
        var response = productService.findProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findProductByName")
    public ResponseEntity<Product> findProductByName(@RequestParam String name) {
        var response = productService.findProductByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        var response = productService.getAllProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PatchMapping("/updateProductById")
    public ResponseEntity<?> updateProduct( @RequestBody Product product) {
//        Product product = productService.findProductById(productId);
        var response = productService.updateProduct(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        var response = productService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
