package com.example.autoservice.dto.request;

import java.math.BigDecimal;

public class ProductRequestDto {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
