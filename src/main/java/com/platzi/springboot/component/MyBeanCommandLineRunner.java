package com.platzi.springboot.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBeanCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("Hello from MyBean");
    }
}
