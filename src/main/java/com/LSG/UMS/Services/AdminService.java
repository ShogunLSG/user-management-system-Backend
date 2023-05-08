package com.LSG.UMS.Services;

import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public ResponseEntity<List<User>> getUsersForAdmin() {
        return ResponseEntity.ok(adminRepository.findAll());
    }

//    public ResponseEntity toggleUserStatus(long id) {
//        var user = adminRepository.findById(id).orElseThrow();
//
//        user.setLocked(!user.isLocked());
//        adminRepository.save(user);
//        return ResponseEntity.ok().build();
//    }

    public ResponseEntity toggleUserStatus(long id) {
        try {
            var user = adminRepository.findById(id).orElseThrow();

            user.setLocked(!user.isLocked());
            adminRepository.save(user);
            return ResponseEntity.ok("User status changed successfully");
        } catch (Exception e) {
            // Handle the exception here
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity deleteUser(Long id) {
        try {
            adminRepository.deleteById(id);
            return ResponseEntity.ok("User successfully deleted");
        } catch (Exception e) {
            // Handle the exception here
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateUserPerms(Long id) {
        try {
            var user = adminRepository.findById(id).orElseThrow();

            user.setRole(Role.ADMIN);
            adminRepository.save(user);
            return ResponseEntity.ok("User successfully updated");
        } catch (Exception e) {
            // Handle the exception here
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}