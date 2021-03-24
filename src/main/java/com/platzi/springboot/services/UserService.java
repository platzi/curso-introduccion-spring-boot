package com.platzi.springboot.services;

import com.platzi.springboot.entity.User;

public interface UserService {
    User getUserByEmail(String email);
}
