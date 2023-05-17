package com.LSG.UMS.Services;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import com.LSG.UMS.Requests.UpdateUserRequestBody;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getUsersForUsers() {
        return ResponseEntity.ok(userRepository.findByRole(Role.USER));
    }


    public ResponseEntity updateUser(@NotNull UpdateUserRequestBody user) {
        System.out.println("user details "+user);
        var oldUser = userRepository.findUserByEmail(user.getEmail()).orElseThrow(() -> new IllegalStateException("User with email " + user.getEmail() + " does not exist"));

        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        System.out.println("old user details "+oldUser);

        return ResponseEntity.ok(userRepository.save(oldUser));
    }

    public ResponseEntity<List<User>> getUsersForAdmin() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
