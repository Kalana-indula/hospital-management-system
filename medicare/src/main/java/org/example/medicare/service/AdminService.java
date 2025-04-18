package org.example.medicare.service;

import org.example.medicare.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    //create a new admin
    Admin createAdmin(Admin admin);

    //get all admins
    List<Admin> getAllAdmins();
}
