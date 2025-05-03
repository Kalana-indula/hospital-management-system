package com.app.medicareapp.controller;

import com.app.medicareapp.dto.DoctorDto;
import com.app.medicareapp.entity.Doctor;
import com.app.medicareapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DoctorController {

    //Create a 'DoctorService' instance
    private DoctorService doctorService;

    //Inject an instance of 'DoctorService'
    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    //Add a new doctor
    @PostMapping("/doctors")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorDto doctorDto){
        try{
            Doctor doctor=doctorService.addDoctor(doctorDto);

            //Check if the 'doctor' is null
            if(doctor==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No specialization found");
            }

            return ResponseEntity.status(HttpStatus.OK).body(doctor);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    //Find all doctors
    @GetMapping("/doctors")
    public ResponseEntity<?> findAllDoctors(){
        try{
            List<Doctor> doctors=doctorService.getAllDoctors();

            if(doctors.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No doctors found");
            }

            return ResponseEntity.status(HttpStatus.OK).body(doctors);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    //Find a doctor by id
    @GetMapping("/doctors/{id}")
    public ResponseEntity<?> findDoctorById(@PathVariable Long id){
        try {
            Doctor doctor=doctorService.findDoctorById(id);

            //Check if the doctor is null
            if(doctor==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No doctors found for the id");
            }
            return ResponseEntity.status(HttpStatus.OK).body(doctor);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id){
        try {
            boolean isDeleted=doctorService.deleteDoctor(id);

            if(!isDeleted){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No doctors found for the id");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
