package com.platzi.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyRestController {
    @GetMapping(path = "/mi-ruta")
    public List<String> myMethod() {
        return Arrays.asList("hola", "mundo");
    }

    @GetMapping(path = "/mi-ruta-dos")
    public List<String> myMethod(@RequestParam("param") String param, @RequestParam("param2") String param2) {
        return Arrays.asList("hola", "mundo", param, param2);
    }

    @GetMapping(path = "/mi-ruta-dos/{param}")
    public List<String> myMethodPathVariable(@PathVariable("param") String param) {
        return Arrays.asList("hola", "mundo", param);
    }
}
