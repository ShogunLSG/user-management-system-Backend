package com.LSG.UMS.Controllers;

import com.LSG.UMS.Repository.UserRepository;
import com.LSG.UMS.Services.UserService;
import com.LSG.UMS.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping(path = "user/update")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    //
    @GetMapping(path = "users")
    public List<User> getUsers() {
        List<User> users = userRepository.findUsers();
        return users;
    }
}
