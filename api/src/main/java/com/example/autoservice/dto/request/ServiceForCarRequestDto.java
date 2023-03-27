package com.example.autoservice.dto.request;

import com.example.autoservice.model.Status;

import java.math.BigDecimal;

public class ServiceForCarRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private Status status;
    private String name;

    public String getName() {
        return name;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getMasterId() {
        return masterId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }
}
