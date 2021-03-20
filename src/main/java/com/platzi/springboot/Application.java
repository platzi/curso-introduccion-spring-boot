package com.platzi.springboot;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.component.MyComponent;
import com.platzi.springboot.pojo.properties.UserProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(this.getClass());

    private MyBean myBean;
    private MyComponent myComponent;
    private UserProperties userProperties;

    public Application(MyBean myBean, @Qualifier("cualquierNombre") MyComponent myComponent, UserProperties userProperties) {
        this.myBean = myBean;
        this.myComponent = myComponent;
        this.userProperties = userProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(myBean.hello());
        myComponent.printSomething();
        System.out.println(userProperties.toString());
        System.out.println("hola mundo utilizando spring boot devtools");
        System.out.println("hola mundo utilizando spring boot devtools");
        System.out.println("hola mundo utilizando spring boot devtools");
        logger.info("error en el aplicativo");
    }
}
