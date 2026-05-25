package com.example.demo.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
    UUID resourceId,
    String name,
    String description,
    BigDecimal price
) {}
