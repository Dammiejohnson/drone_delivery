package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Product;
import com.catalyst.dronedelivery.dtos.requests.ProductDto;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDto productDto);
    Product findProductById(Long id);
    Product findProductByName(String name);

    List<Product> getAllProducts();
    String deleteById(Long id);

    String updateProduct(Product product);
}
