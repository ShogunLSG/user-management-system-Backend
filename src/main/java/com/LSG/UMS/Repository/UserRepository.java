package com.LSG.UMS.Repository;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    List<User> findByRole(Role role);
}
