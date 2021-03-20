package com.platzi.springboot;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.component.MyComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private MyBean myBean;
    private MyComponent myComponent;

    public Application(MyBean myBean, @Qualifier("cualquierNombre") MyComponent myComponent) {
        this.myBean = myBean;
        this.myComponent = myComponent;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(myBean.hello());
        myComponent.printSomething();
    }
}
