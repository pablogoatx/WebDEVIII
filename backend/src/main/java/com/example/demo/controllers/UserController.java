package com.example.demo.controllers;

import com.example.demo.dtos.UserDto;
import com.example.demo.facade.IUserFacade;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseModel>> getAll() {
        List<UserDto> dtos = userFacade.getAll();
        List<UserResponseModel> response = userMapper.toUserResponseModelList(dtos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<UserResponseModel> getUser(@PathVariable UUID resourceId) {
        UserDto dto = userFacade.getByResourceId(resourceId);
        return ResponseEntity.ok(userMapper.toUserResponseModel(dto));
    }

    @PostMapping
    public ResponseEntity<UserResponseModel> addUser(@Valid @RequestBody UserRequestModel userRequestModel) {
        var dto = userMapper.toUserRequestDto(userRequestModel);
        var saved = userFacade.addUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toUserResponseModel(saved));
    }
}
