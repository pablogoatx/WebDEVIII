package com.example.demo.dtos;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private LocalDate birthDate;
}
