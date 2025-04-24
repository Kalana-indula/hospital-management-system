package com.app.medicareapp.service;

import com.app.medicareapp.entity.Major;
import com.app.medicareapp.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService{

    private MajorRepository majorRepository;

    @Autowired
    public MajorServiceImpl(MajorRepository majorRepository){
        this.majorRepository=majorRepository;
    }

    @Override
    public Major createMajor(Major major) {

        return majorRepository.save(major);
    }

    @Override
    public Major findMajorById(Long id) {

        //Find existing major
        return majorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Major> findAllMajors() {

        //find all majors
        List<Major> allMajors=majorRepository.findAll();

        if(allMajors.isEmpty()){
            return null;
        }
        return allMajors;
    }

    @Override
    public Major updateMajor(Long id, Major major) {

        Major existingMajor=majorRepository.findById(id).orElse(null);

        if(existingMajor!=null){
            existingMajor.setName(major.getName());

            return majorRepository.save(existingMajor);
        }

        return null;
    }

    @Override
    public Boolean deleteMajor(Long id) {

        if(majorRepository.existsById(id)){
            majorRepository.deleteById(id);

            return true;
        }

        return false;
    }

}
