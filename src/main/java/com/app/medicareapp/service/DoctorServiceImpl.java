package com.app.medicareapp.service;

import com.app.medicareapp.dto.DoctorDto;
import com.app.medicareapp.entity.Doctor;
import com.app.medicareapp.entity.Major;
import com.app.medicareapp.repository.DoctorRepository;
import com.app.medicareapp.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorRepository doctorRepository;
    private MajorRepository majorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, MajorRepository majorRepository){
        this.doctorRepository=doctorRepository;
        this.majorRepository=majorRepository;
    }

    //Create a new doctor
    @Override
    public Doctor addDoctor(DoctorDto doctorDto) {

        //Get the major corresponding to the id
        Major major=majorRepository.findById(doctorDto.getMajorId()).orElse(null);

        //Check if the major is null
        if(major==null){
            return null;
        }

        //Create a new 'Doctor' object
        Doctor doctor=new Doctor();

        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setRegistrationNumber(doctorDto.getRegistrationNumber());
        doctor.setHospital(doctorDto.getHospital());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPassword(doctorDto.getPassword());
        doctor.setMajor(major);

        return doctorRepository.save(doctor);
    }

    //Get all doctors
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    //Find a doctor by id
    @Override
    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    //Delete a doctor
    @Override
    public Boolean deleteDoctor(Long id) {

        //Check if a doctor exists for the id
        boolean isExist=doctorRepository.existsById(id);

        //Delete if exist
        if(isExist){
            doctorRepository.deleteById(id);

            return true;
        }

        return false;
    }
}
