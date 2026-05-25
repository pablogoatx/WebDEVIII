package com.example.demo.facade;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;

import java.util.List;
import java.util.UUID;

public interface IUserFacade {
    List<UserDto> getAll();

    UserDto addUser(UserRequestDto userRequestDto);

    UserDto getByResourceId(UUID resourceId);
}
