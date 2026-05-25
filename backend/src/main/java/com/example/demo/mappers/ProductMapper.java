package com.example.demo.mappers;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductRequestModel;
import com.example.demo.models.ProductResponseModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        if (product == null) return null;
        return new ProductDto(
            product.getResourceId(),
            product.getName(),
            product.getDescription(),
            product.getPrice()
        );
    }

    public List<ProductDto> toProductDtoList(List<Product> products) {
        return products.stream()
            .map(this::toProductDto)
            .toList();
    }

    public ProductResponseModel toProductResponseModel(ProductDto dto) {
        if (dto == null) return null;
        return new ProductResponseModel(
            dto.resourceId(),
            dto.name(),
            dto.description(),
            dto.price()
        );
    }

    public List<ProductResponseModel> toProductResponseModelList(List<ProductDto> dtos) {
        return dtos.stream()
            .map(this::toProductResponseModel)
            .toList();
    }

    public ProductRequestDto toProductRequestDto(ProductRequestModel model) {
        if (model == null) return null;
        return new ProductRequestDto(
            model.name(),
            model.description(),
            model.price()
        );
    }

    public Product toProductEntity(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setResourceId(UUID.randomUUID());
        return product;
    }
}
