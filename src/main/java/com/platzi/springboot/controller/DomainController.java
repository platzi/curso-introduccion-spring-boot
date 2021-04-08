package com.platzi.springboot.controller;

import com.platzi.springboot.caseuse.GetUsers;
import com.platzi.springboot.caseuse.impl.GetUsersImpl;
import com.platzi.springboot.caseuse.SaveUser;
import com.platzi.springboot.domain.UserDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class DomainController {
    private final SaveUser saveUser;
    private final GetUsers getUsers;

    public DomainController(SaveUser saveUser, GetUsers getUsers) {
        this.saveUser = saveUser;
        this.getUsers = getUsers;
    }

    @GetMapping("/v2")
    List<UserDomain> all() {
        return getUsers.find();
    }

    @PostMapping("/v2")
    ResponseEntity<UserDomain> newUserResponseEntity(@RequestBody UserDomain newUser) {
        return new ResponseEntity<>(saveUser.save(newUser), HttpStatus.CREATED);
    }
}
