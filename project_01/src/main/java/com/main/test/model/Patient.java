package com.main.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Patient {
    @Id
    String patientId;

    @Pattern(regexp = "[A-Z][a-z]*([ ][A-Z][a-z]*)*",message = "Name wrong format")
    @Size(min = 6,max = 40,message = "Name too short or too long. 6-40 chars")
    @NotBlank
    String name;

    @OneToMany(mappedBy = "patient")
    private List<Medical> medicalList;

    public Patient() {
    }

    public String getId() {
        return patientId;
    }

    public void setId(String id) {
        this.patientId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
