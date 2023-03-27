package com.example.autoservice.dto.request;

public class CarRequestDto {
    private String manufacture;
    private String model;
    private int year;
    private String number;
    private Long ownerId;

    public String getManufacture() {
        return manufacture;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getNumber() {
        return number;
    }

    public Long getOwnerId() {
        return ownerId;
    }
}
