package com.platzi.springboot.services;

import com.platzi.springboot.entity.User;
import com.platzi.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    public static final String MESSAGE_USER_NOT_FOUND = "Ha ocurrido un error buscando el usuario por email";
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
//        Optional<User> optionalUser = userRepository.findMyUserByEmail(email);
//        if (optionalUser.isPresent()) {
//            return optionalUser.get();
//        }
        return userRepository.findMyUserByEmail(email).orElseThrow(()-> new RuntimeException(MESSAGE_USER_NOT_FOUND));
//        throw new RuntimeException("Ha ocurrido un error buscando el usuario por email");
    }
}
