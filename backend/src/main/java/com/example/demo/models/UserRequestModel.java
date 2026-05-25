package com.example.demo.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record UserRequestModel(

        @NotBlank(message = "El nombre no puede estar vacío") String name,

        @NotNull(message = "La fecha de nacimiento es obligatoria") @Past(message = "La fecha de nacimiento debe ser una fecha pasada") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate birthDate

) {
}
