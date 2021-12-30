package com.main.test.service;

import com.main.test.model.Medical;
import com.main.test.repository.IMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public Page<Medical> findAll(Pageable pageable) {
        return iMedicalRepository.findAll(pageable);
    }

    @Override
    public List<Medical> findAll() {
        return null;
    }

    @Override
    public Medical findById(String id) {
        return iMedicalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Medical medical) {
        iMedicalRepository.save(medical);
    }

    @Override
    public void remove(String id) {
        iMedicalRepository.deleteById(id);
    }
}
