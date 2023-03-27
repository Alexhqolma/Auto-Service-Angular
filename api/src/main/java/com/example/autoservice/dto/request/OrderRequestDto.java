package com.example.autoservice.dto.request;

import com.example.autoservice.model.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderRequestDto {
    private Long carId;
    private String problemDescription;
    private LocalDate startDate;
    private List<Long> carServicesId;
    private List<Long> productsId;
    private Status status;
    private BigDecimal price;
    private LocalDate finishDate;

    public Long getCarId() {
        return carId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<Long> getCarServicesId() {
        return carServicesId;
    }

    public Status getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public List<Long> getProductsId() {
        return productsId;
    }
}
