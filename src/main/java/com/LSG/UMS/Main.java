package com.LSG.UMS;

import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
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
        User user = new User("LSG", "user@user.com", "password", true);
        userRepository.save(user);
    }
}
