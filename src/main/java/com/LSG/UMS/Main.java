package com.LSG.UMS;

import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import static com.LSG.UMS.Models.Role.ADMIN;
import static com.LSG.UMS.Models.Role.USER;

@SpringBootApplication
@Import({com.LSG.UMS.config.CorsConfig.class})
public class Main implements CommandLineRunner {
    private final UserRepository userRepository;

    public Main(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("LSG", "user@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", ADMIN,0123456);
        User user2 = new User("LSG2", "user2@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", ADMIN, 0123456);
        User user3 = new User("LSG3", "user3@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", ADMIN, 0123456);
        User user4 = new User("LSG4", "user4@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", ADMIN, 0123456);
        User user5 = new User("LSG5", "user5@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", USER, 0123456);
        User user6 = new User("LSG6", "user6@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", USER, 0123456);
        User user7 = new User("LSG7", "user7@user.com", "$2a$10$/Rd9ANzumSW3FQYvpMTc3e2cLFR7ea1x25SOyFtiBgQTDXxPh7SYe", USER, 0123456);
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        
    }
}
