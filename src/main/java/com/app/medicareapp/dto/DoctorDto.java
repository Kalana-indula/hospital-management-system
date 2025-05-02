package com.app.medicareapp.dto;

public class DoctorDto {
    private Long firstName;
    private Long lastName;
    private String phone;
    private String registrationNumber;
    private String hospital;
    private String password;
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getLastName() {
        return lastName;
    }

    public void setLastName(Long lastName) {
        this.lastName = lastName;
    }

    public Long getFirstName() {
        return firstName;
    }

    public void setFirstName(Long firstName) {
        this.firstName = firstName;
    }
}
