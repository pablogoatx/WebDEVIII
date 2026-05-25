package com.example.demo.dtos;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
}
