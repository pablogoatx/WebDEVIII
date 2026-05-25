package com.example.demo.models;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequestModel(
    @NotBlank(message = "El nombre no puede estar vacío")
    String name,

    String description,

    @NotNull(message = "El precio es requerido")
    @Positive(message = "El precio debe ser positivo")
    BigDecimal price
) {}
