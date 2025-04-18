package org.example.medicare.controller;

import org.example.medicare.entity.Admin;
import org.example.medicare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(@Qualifier("adminServiceImpl") AdminService adminService){
        this.adminService=adminService;
    }

    @PostMapping("/admins")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin){
        try{
            Admin newAdmin=adminService.createAdmin(admin);

            return ResponseEntity.status(HttpStatus.OK).body(newAdmin);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllAdmins());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
