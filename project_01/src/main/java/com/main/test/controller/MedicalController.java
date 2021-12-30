package com.main.test.controller;

import com.main.test.model.Medical;
import com.main.test.service.IMedicalService;
import com.main.test.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalController {
    @Autowired
    IMedicalService iMedicalService;

    @Autowired
    IPatientService iPatientService;

    @GetMapping
    public Page<Medical> getAllMedical(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,3,Sort.by("id"));
        Page<Medical> medicalPage = iMedicalService.findAll(pageable);
        return  medicalPage;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medical> getById(@PathVariable String id){
        return new ResponseEntity<>(iMedicalService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public void edit(@RequestBody Medical medical){
        iMedicalService.save(medical);
        iPatientService.save(medical.getPatient());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        iMedicalService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
