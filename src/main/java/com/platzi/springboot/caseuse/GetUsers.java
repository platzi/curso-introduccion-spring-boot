package com.platzi.springboot.caseuse;

import com.platzi.springboot.domain.UserDomain;
import com.platzi.springboot.services.UserService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetUsers {
    private final UserService userService;

    public GetUsers(UserService userService) {
        this.userService = userService;
    }

    public List<UserDomain> find() {
        return userService.getUsers()
                .stream()
                .sorted(Comparator.comparing(UserDomain::getBirthDate))
                .collect(Collectors.toList());
    }
}
