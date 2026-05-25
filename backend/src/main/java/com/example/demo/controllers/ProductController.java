package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDto;
import com.example.demo.facade.IProductFacade;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.ProductRequestModel;
import com.example.demo.models.ProductResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductFacade productFacade;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> getAll() {
        List<ProductDto> dtos = productFacade.getAll();
        List<ProductResponseModel> response = productMapper.toProductResponseModelList(dtos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<ProductResponseModel> findById(@PathVariable UUID resourceId) {
        ProductDto dto = productFacade.getByResourceId(resourceId);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toProductResponseModel(dto));
    }

    @PostMapping
    public ResponseEntity<ProductResponseModel> save(@Valid @RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);
        var saved = productFacade.addProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toProductResponseModel(saved));
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<ProductResponseModel> update(
            @PathVariable UUID resourceId,
            @Valid @RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);
        var updated = productFacade.updateProduct(resourceId, dto);
        return ResponseEntity.ok(productMapper.toProductResponseModel(updated));
    }

    @DeleteMapping("/{resourceId}")
    public ResponseEntity<Void> delete(@PathVariable UUID resourceId) {
        productFacade.removeProduct(resourceId);
        return ResponseEntity.noContent().build();
    }
}
