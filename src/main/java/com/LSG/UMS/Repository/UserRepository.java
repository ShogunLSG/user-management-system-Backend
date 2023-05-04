package com.LSG.UMS.Repository;

import com.LSG.UMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public final String getUsers = "SELECT * FROM users WHERE role = 'USER'";

    Optional<User> findUserByEmail(String email);


    @Query("SELECT * FROM users WHERE role = 'USER'")
    List<User> findUsers();
}
