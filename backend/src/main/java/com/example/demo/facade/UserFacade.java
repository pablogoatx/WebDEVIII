package com.example.demo.facade;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.mappers.UserMapper;
import com.example.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class UserFacade implements IUserFacade {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userService.getAll());
    }

    @Override
    @Transactional
    public UserDto addUser(UserRequestDto userRequestDto) {
        var entity = userService.addUser(userRequestDto);
        return userMapper.toUserDto(entity);
    }

    @Override
    public UserDto getByResourceId(UUID resourceId) {
        var entity = userService.getByResourceId(resourceId);
        return userMapper.toUserDto(entity);
    }
}
