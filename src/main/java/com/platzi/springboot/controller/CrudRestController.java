package com.platzi.springboot.controller;

import com.platzi.springboot.entity.Posts;
import com.platzi.springboot.entity.User;
import com.platzi.springboot.repository.PostRepository;
import com.platzi.springboot.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CrudRestController {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CrudRestController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/posts")
    List<Posts> allPost() {
        return postRepository.findAll();
    }

    @PostMapping("/")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
//Todo: Ejemplo con responseEntity

//    @PostMapping("/users")
//    ResponseEntity<User> newUserResponseEntity(@RequestBody User newUser) {
//        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    User getOne(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    // Todo: Ejemplo con responseEntity

//    @GetMapping("/users/{id}")
//    ResponseEntity<User> getOne(@PathVariable Long id) {
//        if (userRepository.existsById(id)) {
//            return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//    }

    @PutMapping("/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
// Todo: Ejemplo con responseEntity:

//    @PutMapping("/users/{id}")
//    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id) {
//        if (userRepository.existsById(id)) {
//            return new ResponseEntity(userRepository.findById(id)
//                    .map(user -> {
//                        user.setEmail(newUser.getEmail());
//                        user.setBirthDate(newUser.getBirthDate());
//                        user.setName(newUser.getName());
//                        return userRepository.save(user);
//                    }).get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
// Todo: Ejemplo con responseEntity:

//    @DeleteMapping("/users/{id}")
//    ResponseEntity deleteUser(@PathVariable Long id) {
//        boolean existsUserById = userRepository.existsById(id);
//        if (existsUserById) {
//            userRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//
//    }

    @GetMapping("/pageable")
    public List<User> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }

}
