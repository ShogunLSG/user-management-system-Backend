package com.LSG.UMS.Controllers;

<<<<<<< HEAD
import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Repository.UserRepository;
import com.LSG.UMS.Requests.GetUsersRequestBody;
import com.LSG.UMS.Requests.UpdateUserRequestBody;
=======
import com.LSG.UMS.Repository.UserRepository;
>>>>>>> 4fdf0db7de395f2620f0bd679ddca0182ad0f555
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

<<<<<<< HEAD
    @PatchMapping(path = "/update")
    public void updateUser(@RequestBody UpdateUserRequestBody user) {
=======
    @PatchMapping(path = "user/update")
    public void updateUser(User user) {
>>>>>>> 4fdf0db7de395f2620f0bd679ddca0182ad0f555
        userService.updateUser(user);
    }

    //
<<<<<<< HEAD
    @GetMapping(path = "/users")
    public List<User> getUsers(@RequestBody GetUsersRequestBody request) {

        if (request.getRole() == "ADMIN") {
            return userService.getUsers();
        }
        List<User> users = userService.getUsersForUsers();
=======
    @GetMapping(path = "users")
    public List<User> getUsers() {
        List<User> users = userRepository.findUsers();
>>>>>>> 4fdf0db7de395f2620f0bd679ddca0182ad0f555
        return users;
    }
}
