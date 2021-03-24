package com.platzi.springboot;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.component.MyComponent;
import com.platzi.springboot.entity.User;
import com.platzi.springboot.pojo.properties.UserProperties;
import com.platzi.springboot.repository.UserRepository;
import com.platzi.springboot.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(this.getClass());

    private MyBean myBean;
    private MyComponent myComponent;
    private UserProperties userProperties;
    private UserRepository userRepository;
    private UserService userService;

    public Application(MyBean myBean, @Qualifier("cualquierNombre") MyComponent myComponent, UserProperties userProperties, UserRepository userRepository, UserService userService) {
        this.myBean = myBean;
        this.myComponent = myComponent;
        this.userProperties = userProperties;
        this.userRepository = userRepository;
        this.userService = userService;
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
        System.out.println(userProperties.toString());
        System.out.println("hola mundo utilizando spring boot devtools");
        logger.info("error en el aplicativo");
        Function function = uppercase();
        System.out.println(function.apply("michael"));
        saveUsersInDb();
        System.out.println(userService.getUserByEmail("oscar@domain.com"));
    }

    private void saveUsersInDb() {
        User user1 = new User("John", "john@domain.com", LocalDate.now());
        User user2 = new User("Julie", "julie@domain.com", LocalDate.now());
        User user3 = new User("Daniela", "daniela@domain.com", LocalDate.now());
        User user4 = new User("Oscar", "oscar@domain.com", LocalDate.now());
        User user5 = new User("Test1", "Test1@domain.com", LocalDate.now());
        User user6 = new User("Test2", "Test2@domain.com", LocalDate.now());
        User user7 = new User("Test3", "Test3@domain.com", LocalDate.now());
        User user8 = new User("Test4", "Test4@domain.com", LocalDate.now());
        User user9 = new User("Test5", "Test5@domain.com", LocalDate.now());
        User user10 = new User("Test6", "Test6@domain.com", LocalDate.now());
        User user11 = new User("Test7", "Test6@domain.com", LocalDate.now());
        User user12 = new User("Test8", "Test6@domain.com", LocalDate.now());
        User user13 = new User("Test9", "Test6@domain.com", LocalDate.now());
        List<User> list = Arrays.asList(user4, user1, user3, user2, user5, user6, user7, user8, user9, user10, user11, user12, user13);
        list.stream().forEach(userRepository::save);

    }
}
