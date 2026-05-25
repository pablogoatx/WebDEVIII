package com.example.demo.models;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseModel(
        UUID resourceId,
        String name,
        String description,
        BigDecimal price) {
}
