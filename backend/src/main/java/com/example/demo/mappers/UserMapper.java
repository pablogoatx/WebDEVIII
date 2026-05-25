package com.example.demo.mappers;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        if (user == null)
            return null;
        return new UserDto(
                user.getId(),
                user.getResourceId(),
                user.getName(),
                user.getBirthDate());
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        return users.stream()
                .map(this::toUserDto)
                .toList();
    }

    public UserResponseModel toUserResponseModel(UserDto dto) {
        if (dto == null)
            return null;
        return new UserResponseModel(
                dto.id(),
                dto.resourceId(),
                dto.name(),
                dto.birthDate());
    }

    public List<UserResponseModel> toUserResponseModelList(List<UserDto> dtos) {
        return dtos.stream()
                .map(this::toUserResponseModel)
                .toList();
    }

    public UserRequestDto toUserRequestDto(UserRequestModel model) {
        if (model == null)
            return null;
        return new UserRequestDto(model.name(), model.birthDate());
    }

    public User toUserEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setResourceId(UUID.randomUUID());
        return user;
    }
}
