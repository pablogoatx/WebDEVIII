package com.example.demo.facade;

import java.util.List;
import java.util.UUID;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;

public interface IProductFacade {
    List<ProductDto> getAll();

    ProductDto addProduct(ProductRequestDto productRequestDto);

    ProductDto updateProduct(UUID resourceId, ProductRequestDto productRequestDto);

    ProductDto getByResourceId(UUID resourceId);

    void removeProduct(UUID resourceId);
}
