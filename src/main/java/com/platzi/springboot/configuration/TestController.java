package com.platzi.springboot.configuration;

import com.platzi.springboot.entity.User;
import com.platzi.springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    UserRepository userRepository;

    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    List<User> list(){
        return userRepository.findByNameLike("%T%");
    }
}
