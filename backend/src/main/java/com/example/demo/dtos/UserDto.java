package com.example.demo.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record UserDto(
    Long id,
    UUID resourceId,
    String name,
    LocalDate birthDate
) {}
