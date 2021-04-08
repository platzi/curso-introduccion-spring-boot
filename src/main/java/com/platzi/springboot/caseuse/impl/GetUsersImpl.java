package com.platzi.springboot.caseuse.impl;

import com.platzi.springboot.caseuse.GetUsers;
import com.platzi.springboot.domain.UserDomain;
import com.platzi.springboot.services.UserService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetUsersImpl implements GetUsers {
    private final UserService userService;

    public GetUsersImpl(UserService userService) {
        this.userService = userService;
    }
    @Override
    public List<UserDomain> find() {
        return userService.getUsers()
                .stream()
                .sorted(Comparator.comparing(UserDomain::getBirthDate))
                .collect(Collectors.toList());
    }
}
