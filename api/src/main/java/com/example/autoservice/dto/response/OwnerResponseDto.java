package com.example.autoservice.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class OwnerResponseDto {
    private Long id;
    private String name;
    private List<Long> carsId;
    private List<Long> ordersId;
}
