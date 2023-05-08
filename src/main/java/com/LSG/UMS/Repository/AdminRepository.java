package com.LSG.UMS.Repository;

import com.LSG.UMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<User, Long> {

}
