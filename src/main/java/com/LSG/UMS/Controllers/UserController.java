package com.LSG.UMS.Controllers;


import com.LSG.UMS.Models.User;
import com.LSG.UMS.Requests.GetUsersRequestBody;
import com.LSG.UMS.Requests.UpdateUserRequestBody;
import com.LSG.UMS.Requests.updatePasswordRequestBody;
import com.LSG.UMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/updateDetails")
    public ResponseEntity updateUser(@RequestBody UpdateUserRequestBody user) {

        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getUsers() {
        System.out.println("Fetching users");

        return userService.getUsersForUsers();

    }

    @GetMapping(path = "/admin")
    public ResponseEntity<List<User>> getUsersForAdmin() {
        System.out.println("Fetching users");


        return userService.getUsersForAdmin();

    }

    @PostMapping(path = "/updatePassword")
    public ResponseEntity updatePassword(@RequestBody updatePasswordRequestBody user) {
        System.out.println("user details "+user);
        userService.updatePassword(user);
        return ResponseEntity.ok().build();
    }



}
