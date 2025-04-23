package com.app.medicareapp.service;

import com.app.medicareapp.dto.AdminUpdateDto;
import com.app.medicareapp.entity.Admin;
import com.app.medicareapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {

        List<Admin> allAdmins=adminRepository.findAll();

        //check if there are any admin
        if(allAdmins.isEmpty()){
            return null;
        }

        return allAdmins;
    }

    @Override
    public Admin findAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin updateAdmin(Long id, AdminUpdateDto adminUpdateDto) {

        Admin existingAdmin=adminRepository.findById(id).orElse(null);

        if(existingAdmin!=null){
            existingAdmin.setEmail(adminUpdateDto.getEmail());
            existingAdmin.setPassword(adminUpdateDto.getPassword());

            return adminRepository.save(existingAdmin);
        }

        return null;
    }

    @Override
    public Boolean deleteAdmin(Long id) {

        if(adminRepository.existsById(id)){
            adminRepository.deleteById(id);

            return true;
        }

        return false;
    }

}
