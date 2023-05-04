package com.LSG.UMS.Services;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import com.LSG.UMS.Requests.UpdateUserRequestBody;
import org.jetbrains.annotations.NotNull;
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

    public List<User> getUsersForUsers() {
        return userRepository.GetUsersForUsers();
    }

//    public Optional<User> getUserRole(User user){
//        return (userRepository.findUserByEmail(user.getUsername()));
//    }

    public ResponseEntity updateUser(@NotNull UpdateUserRequestBody user) {
        userRepository.save(user.getName(),user.getEmail(),user.getId());
        return ResponseEntity.ok().build();




    }

}
