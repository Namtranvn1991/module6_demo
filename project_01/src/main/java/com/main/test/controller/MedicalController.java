package com.main.test.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.main.test.model.Image;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalController {
    @Autowired
    IMedicalService iMedicalService;

    @Autowired
    IPatientService iPatientService;

    @PostMapping
    public void upload(@RequestParam("img") List<MultipartFile> image) throws ExecutionException, InterruptedException {
        List<MultipartFile> img1 = image;
        System.out.println(123);
//        Image image1 = new Image("qqq","ddd",333);
//        Firestore firestore = FirestoreClient.getFirestore();
//
//        DocumentReference documentReference = firestore.collection("img").document("img_1");
//        ApiFuture<DocumentSnapshot> future = documentReference.get();
//        DocumentSnapshot documentSnapshot = future.get();
//        Image image2;
//        if(documentSnapshot.exists()){
//            image2 = documentSnapshot.toObject(Image.class);
//            System.out.println(image2);
//        }
//        ApiFuture<WriteResult> collection = firestore.collection("img").document(image1.getName()).set(image1);
//        String a = collection.get().getUpdateTime().toString();
//        System.out.println(a);
    }

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
