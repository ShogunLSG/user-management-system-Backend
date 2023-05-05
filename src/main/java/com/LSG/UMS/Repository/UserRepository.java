package com.LSG.UMS.Repository;

import com.LSG.UMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
=======
    public final String getUsers = "SELECT * FROM users WHERE role = 'USER'";
>>>>>>> 4fdf0db7de395f2620f0bd679ddca0182ad0f555

    Optional<User> findUserByEmail(String email);


<<<<<<< HEAD
//    @Query("SELECT * FROM users WHERE role = ?1;")
    List<User> GetUsersForUsers();


    @Query("update User set name = ?1, email = ?2 where id = ?3")
    void save(String name, String email, Long id);


=======
    @Query("SELECT * FROM users WHERE role = 'USER'")
    List<User> findUsers();
>>>>>>> 4fdf0db7de395f2620f0bd679ddca0182ad0f555
}
