package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.repositories.UserRepository;
import com.exceptions.ResourceNotFoundException;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User addUser(UserRequestDto userRequestDto) {

        User user = userMapper.toUserEntity(userRequestDto);

        user.setResourceId(UUID.randomUUID());

        return userRepository.save(user);
    }

    @Override
    public User getByResourceId(UUID resourceId) {
        return userRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with resourceId: " + resourceId));
    }
}
