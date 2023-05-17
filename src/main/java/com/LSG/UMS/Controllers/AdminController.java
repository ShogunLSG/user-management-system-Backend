package com.LSG.UMS.Controllers;

import com.LSG.UMS.Models.User;
import com.LSG.UMS.Requests.GetUsersRequestBody;
import com.LSG.UMS.Services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    //Get requests
    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestBody GetUsersRequestBody request) {
        return adminService.getUsersForAdmin();
    }
    //Patch requests
    @PatchMapping(path = "/toggleUserStatus/{id}")
    public ResponseEntity toggleUserStatus(@PathVariable Long id) {
        return adminService.toggleUserStatus(id);
    }

    @PatchMapping(path = "/updateUser/{id}")
    public ResponseEntity updateUserPermissions(@PathVariable Long id) {
        return adminService.updateUserPerms(id);
    }

    //Delete requests
    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        return adminService.deleteUser(id);
    }

    @GetMapping(path = "/admins")
    public ResponseEntity<List<User>> getUsersForAdmin() {
        System.out.println("Fetching users");

        return adminService.getUsersForAdmin();

    }
}
