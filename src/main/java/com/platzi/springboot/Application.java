package com.platzi.springboot;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.component.MyComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private MyBean myBean;
    private MyComponent myComponent;

    public Application(MyBean myBean, @Qualifier("cualquierNombre") MyComponent myComponent) {
        this.myBean = myBean;
        this.myComponent = myComponent;
    }

    @Bean
    public Function<String, String> uppercase() {
        return (String value) -> value.toUpperCase();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(myBean.hello());
        myComponent.printSomething();

        Function function = uppercase();
        System.out.println(function.apply("michael"));
    }
}
