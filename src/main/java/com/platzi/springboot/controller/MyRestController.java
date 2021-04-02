package com.platzi.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyRestController {
    @GetMapping(path = "/mi-ruta")
    public List<String> myMethod() {
        return Arrays.asList("hola", "mundo");
    }
}
