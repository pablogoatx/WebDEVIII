package com.example.demo.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.services.IProductService;

@Component
public class ProductFacade implements IProductFacade {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toProductDtoList(productService.getAll());
    }

    @Override
    @Transactional
    public ProductDto addProduct(ProductRequestDto productRequestDto) {
        var entity = productService.addProduct(productRequestDto);
        return productMapper.toProductDto(entity);
    }

    @Override
    @Transactional
    public ProductDto updateProduct(UUID resourceId, ProductRequestDto productRequestDto) {
        var entity = productService.updateProduct(resourceId, productRequestDto);
        return productMapper.toProductDto(entity);
    }

    @Override
    public ProductDto getByResourceId(UUID resourceId) {
        var entity = productService.getByResourceId(resourceId);
        return productMapper.toProductDto(entity);
    }

    @Override
    public void removeProduct(UUID resourceId) {
        productService.removeProduct(resourceId);
    }
}
