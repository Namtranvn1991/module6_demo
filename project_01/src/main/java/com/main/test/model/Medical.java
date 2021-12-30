package com.main.test.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Medical implements Validator {
    @Id
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private LocalDate dayIn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private LocalDate dayOut;

    @NotBlank
    private String reason;
    @NotBlank
    private String plan;
    @NotBlank
    private String doctor;

    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patientId")
    private Patient patient;

    public Medical() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDayIn() {
        return dayIn;
    }

    public void setDayIn(LocalDate dayIn) {
        this.dayIn = dayIn;
    }

    public LocalDate getDayOut() {
        return dayOut;
    }

    public void setDayOut(LocalDate dayOut) {
        this.dayOut = dayOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Medical medical = (Medical) target;
        try {
            if(Period.between(dayIn,dayOut).getDays()<1){
                errors.rejectValue("dateError","dateError");
            }
        } catch (Exception e){
        }
    }
}
