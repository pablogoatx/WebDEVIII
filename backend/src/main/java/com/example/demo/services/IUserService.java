package com.example.demo.services;

import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<User> getAll();

    User addUser(UserRequestDto userRequestDto);

    User getByResourceId(UUID resourceId);
}
