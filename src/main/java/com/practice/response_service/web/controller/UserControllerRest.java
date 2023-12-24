package com.practice.response_service.web.controller;

import com.practice.response_service.domain.User;
import com.practice.response_service.service.UserService;
import com.practice.response_service.web.dto.UserDto;
import com.practice.response_service.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/users")
@RequiredArgsConstructor
public class UserControllerRest {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    @QueryMapping(name = "users")
    public List<UserDto> getAll() {
        List<User> users = userService.getAll();
        return userMapper.toDto(users);
    }

    @GetMapping("/{id}")
    @QueryMapping(name = "userById")
    public UserDto getById(@PathVariable("id") @Argument Long id) {
        User user =  userService.getById(id);
        return userMapper.toDto(user);
    }

    @PostMapping
    @MutationMapping(name = "updateUser")
    public UserDto create(@RequestBody @Argument UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userService.create(user);
        return userMapper.toDto(user);
    }

}
