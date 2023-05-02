package com.LSG.UMS.Services;

import com.LSG.UMS.Models.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User(
                        "Miguel",
                        "miguel@gmail.com", "12345678", "admin"
                ),
                new User(
                        "Pepe",
                        "pepeTheFrog@gmail.com", "123456756", "user"
                ),
                new User(
                        "IShowSpeed",
                        "Siwi7@gmail.com", "Suiiii", "user"
                )
        );
    }
}
