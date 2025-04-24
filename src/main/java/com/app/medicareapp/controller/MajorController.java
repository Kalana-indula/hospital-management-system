package com.app.medicareapp.controller;

import com.app.medicareapp.entity.Major;
import com.app.medicareapp.service.MajorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MajorController {

    private MajorService majorService;

    public MajorController(MajorService majorService){
        this.majorService=majorService;
    }

    @PostMapping("/majors")
    public ResponseEntity<?> createMajor(@RequestBody Major major){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(majorService.createMajor(major));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/majors")
    public ResponseEntity<?> findAllMajors(){
        try {
            List<Major> allMajors=majorService.findAllMajors();

            if(allMajors==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category found");
            }

            return ResponseEntity.status(HttpStatus.OK).body(allMajors);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/majors/{id}")
    public ResponseEntity<?> findMajorById(@PathVariable Long id){
        try {
            Major existingMajor=majorService.findMajorById(id);

            if(existingMajor==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category found");
            }

            return ResponseEntity.status(HttpStatus.OK).body(existingMajor);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/majors/{id}")
    public ResponseEntity<?> updateMajor(@PathVariable Long id,@RequestBody Major major){
        try{
            Major updatedMajor=majorService.updateMajor(id,major);

            if(updatedMajor==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category found");
            }

            return ResponseEntity.status(HttpStatus.OK).body(updatedMajor);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/majors/{id}")
    public ResponseEntity<?> deleteMajor(@PathVariable Long id){
        try{
            if(!majorService.deleteMajor(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category found");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
