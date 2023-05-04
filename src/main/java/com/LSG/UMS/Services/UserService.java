package com.LSG.UMS.Services;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUserRole(User user){
        return (userRepository.findUserByEmail(user.getUsername()));
    }

    public ResponseEntity updateUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getUsername());
        if (userOptional.isPresent()) {
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
