package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Product;
import com.catalyst.dronedelivery.data.repository.ProductRepo;
import com.catalyst.dronedelivery.dtos.requests.ProductDto;
import com.catalyst.dronedelivery.exception.DroneAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    @Override
    public Product addProduct(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .productWeight(productDto.getProductWeight())
                .productAmount(productDto.getProductAmount())
                .build();

        return productRepo.save(product);
    }

    @Override
    public Product findProductByName(String name) {
        Product product  = productRepo.findProductByName(name).orElseThrow(() -> new DroneAppException("Product not found"));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new DroneAppException("Cannot find Product"));
    }

    @Override
    public String deleteById(Long id) {
        productRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public String updateProduct(Product product) {
        Product existingProduct = productRepo.findById(product.getId()).orElseThrow(() -> new DroneAppException("Cannot find Product"));
        existingProduct.setName(product.getName());
        existingProduct.setProductAmount(product.getProductAmount());
        existingProduct.setProductWeight(product.getProductWeight());

        productRepo.save(existingProduct);

        return "Product update is successful";
    }
}
