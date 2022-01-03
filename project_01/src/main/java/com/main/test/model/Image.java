package com.main.test.model;

import org.springframework.web.multipart.MultipartFile;

public class Image {
    private String documentId;
    private String name;
    private Integer number;

    public Image() {
    }

    public Image(String documentId, String name, Integer number) {
        this.documentId = documentId;
        this.name = name;
        this.number = number;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Image{" +
                "documentId='" + documentId + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
