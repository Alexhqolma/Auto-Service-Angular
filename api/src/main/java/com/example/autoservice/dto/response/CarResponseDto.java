package com.example.autoservice.dto.response;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String manufacture;
    private String model;
    private int year;
    private String number;
    private Long ownerId;
}
