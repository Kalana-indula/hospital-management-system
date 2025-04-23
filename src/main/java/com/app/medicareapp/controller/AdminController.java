package com.app.medicareapp.controller;

import com.app.medicareapp.dto.AdminUpdateDto;
import com.app.medicareapp.entity.Admin;
import com.app.medicareapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    @PostMapping("/admins")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(adminService.createAdmin(admin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<?> findAllAdmin(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllAdmins());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<?> findAdminById(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(adminService.findAdminById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable Long id,@RequestBody AdminUpdateDto adminUpdateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(adminService.updateAdmin(id,adminUpdateDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id){
        try {
            String responseMessage=null;

            if(adminService.deleteAdmin(id)){
                responseMessage="Admin deleted successfully";
            }else{
                responseMessage="Admin not found";
            }
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
