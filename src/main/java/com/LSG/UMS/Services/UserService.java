package com.LSG.UMS.Services;

import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


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
}
