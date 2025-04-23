package com.app.medicareapp.service;

import com.app.medicareapp.dto.AdminUpdateDto;
import com.app.medicareapp.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    Admin createAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin findAdminById(Long id);

    Admin updateAdmin(Long id, AdminUpdateDto adminUpdateDto);

    Boolean deleteAdmin(Long id);
}
