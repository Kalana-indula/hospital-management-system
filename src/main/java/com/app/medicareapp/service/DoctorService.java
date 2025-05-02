package com.app.medicareapp.service;

import com.app.medicareapp.dto.DoctorDto;
import com.app.medicareapp.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {

    Doctor addDoctor(DoctorDto doctorDto);

    List<Doctor> getAllDoctors();
}
