package com.app.medicareapp.controller;

import com.app.medicareapp.dto.AdminUpdateDto;
import com.app.medicareapp.entity.Admin;
import com.app.medicareapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
            List<Admin> allAdmins=adminService.getAllAdmins();

            if(allAdmins==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No admins found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(allAdmins);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<?> findAdminById(@PathVariable Long id){
        try{

            Admin existingAdmin= adminService.findAdminById(id);

            if(existingAdmin!=null){
                return ResponseEntity.status(HttpStatus.OK).body(existingAdmin);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No admin found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable Long id,@RequestBody AdminUpdateDto adminUpdateDto){
        try{
            Admin updatedAdmin= adminService.updateAdmin(id,adminUpdateDto);

            if(updatedAdmin!=null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedAdmin);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id){
        try {
            if(adminService.deleteAdmin(id)){
                return ResponseEntity.status(HttpStatus.OK).body("Admin deleted successfully");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
