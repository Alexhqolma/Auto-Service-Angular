package com.example.autoservice.dto.response;

import com.example.autoservice.model.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceForCarResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private Status status;
    private String name;
}
