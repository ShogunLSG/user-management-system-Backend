package com.LSG.UMS.Services;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import com.LSG.UMS.Requests.UpdateUserRequestBody;
import com.LSG.UMS.Requests.updatePasswordRequestBody;
import com.LSG.UMS.dto.userUpdate;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder PasswordEncoder) {
        this.passwordEncoder = PasswordEncoder;
        this.userRepository = userRepository;
    }



    public ResponseEntity<List<User>> getUsersForUsers() {
        return ResponseEntity.ok(userRepository.findByRole(Role.USER));
    }


    public ResponseEntity updateUser(@NotNull UpdateUserRequestBody user) {
        System.out.println("user details "+user);
        var oldUser = userRepository.findById(user.getId());
        System.out.println("old user details "+oldUser);
        if(oldUser.isEmpty()){
            return ResponseEntity.badRequest().body("User does not exist");
        }
        Role role;

        if(user.getIsAdmin()){
            role = Role.ADMIN;
        }else{
            role = Role.USER;
        }
        System.out.println("New updated user: "+user);
        System.out.println("user role: "+role);
        oldUser.get().setRole(role);
        oldUser.get().setEmail(user.getEmail());
        oldUser.get().setName(user.getName());

        return ResponseEntity.ok(userRepository.save(oldUser.get()));
    }

    public ResponseEntity updateUserDetails(@NotNull userUpdate user) {
        System.out.println("user details "+user);
        var oldUser = userRepository.findById(user.getId());
        System.out.println("old user details "+oldUser);
        if(oldUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User does not exist");
        }
        System.out.println("New updated user: "+user);
        oldUser.get().setEmail(user.getEmail());
        oldUser.get().setName(user.getName());
        oldUser.get().setPhone(user.getPhone());



        return ResponseEntity.ok(userRepository.save(oldUser.get()));
    }

    public ResponseEntity<List<User>> getUsersForAdmin() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity updatePassword(updatePasswordRequestBody user) {
        var oldUser = userRepository.findById(user.getId());
        var password = passwordEncoder.encode(user.getPassword());
//        System.out.println("encoded password "+password);
        oldUser.get().setPassword(user.getPassword());

        System.out.println("New updated user: "+oldUser);
        userRepository.save(oldUser.get());
        return  ResponseEntity.ok("Password updated successfully");
    }

    public ResponseEntity deleteUser(Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().body("User does not exist");
        }
        userRepository.delete(user.get());
        return ResponseEntity.ok("User deleted successfully");
    }
}
