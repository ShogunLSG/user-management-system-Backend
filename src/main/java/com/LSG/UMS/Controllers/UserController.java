package com.LSG.UMS.Controllers;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Repository.UserRepository;
import com.LSG.UMS.Requests.GetUsersRequestBody;
import com.LSG.UMS.Requests.UpdateUserRequestBody;
import com.LSG.UMS.Services.UserService;
import com.LSG.UMS.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping(path = "/update")
    public void updateUser(@RequestBody UpdateUserRequestBody user) {
        userService.updateUser(user);
    }

    //
    @GetMapping(path = "/users")
    public List<User> getUsers(@RequestBody GetUsersRequestBody request) {

        if (request.getRole() == "ADMIN") {
            return userService.getUsers();
        }
        List<User> users = userService.getUsersForUsers();
        return users;
    }
}
