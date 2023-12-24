package com.practice.response_service.service;


import com.practice.response_service.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long id);
    User create(User user);

}
