package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.repositories.ProductRepository;
import com.exceptions.ProductNotFoundException;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product addProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toProductEntity(productRequestDto);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID resourceId, ProductRequestDto productDto) {
        var product = productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con resourceId: " + resourceId));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return productRepository.updateProduct(product);
    }

    @Override
    public Product getByResourceId(UUID resourceId) {
        return productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product not found with resourceId: " + resourceId));
    }

    @Override
    public void deleteByResourceId(UUID resourceId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteByResourceId'");
    }

    @Override
    public void removeProduct(UUID resourceId) {

        var product = productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product not found with resourceId: " + resourceId));

        productRepository.delete(product);
    }

}
