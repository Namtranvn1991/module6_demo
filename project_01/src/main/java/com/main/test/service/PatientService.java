package com.main.test.service;

import com.main.test.model.Patient;
import com.main.test.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {
    @Autowired
    IPatientRepository  patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void remove(String id) {
        patientRepository.deleteById(id);
    }
}
