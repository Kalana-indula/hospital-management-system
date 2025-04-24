package com.app.medicareapp.service;

import com.app.medicareapp.entity.Major;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MajorService {

    Major createMajor(Major major);

    Major findMajorById(Long id);

    List<Major> findAllMajors();

    Major updateMajor(Long id,Major major);

    Boolean deleteMajor(Long id);

}
