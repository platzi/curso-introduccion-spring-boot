package com.platzi.springboot.caseuse;

import com.platzi.springboot.domain.UserDomain;
import com.platzi.springboot.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class SaveUser {

    private final UserService userService;

    public SaveUser(UserService userService) {
        this.userService = userService;
    }

    public UserDomain save(UserDomain newUser) {
        //Todas las validaciones de negocio que tengamos
        newUser.isAgeCorrect();
        return userService.saveOneUser(newUser);
    }
}
