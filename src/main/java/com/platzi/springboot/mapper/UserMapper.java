package com.platzi.springboot.mapper;

import com.platzi.springboot.domain.UserDomain;
import com.platzi.springboot.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static User toEntity(UserDomain newUser) {
        return new User(newUser.getName(), newUser.getEmail(), newUser.getBirthDate());
    }

    public static UserDomain toDomain(User save) {
        return new UserDomain(save.getId(), save.getName(), save.getEmail(), save.getBirthDate());
    }

    public static List<UserDomain> toDomainList(List<User> users) {
        return users.stream()
                .map(entity -> new UserDomain(entity.getName(), entity.getEmail(), entity.getBirthDate())
                ).collect(Collectors.toList());
    }
}
