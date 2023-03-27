package com.example.autoservice.dto.request;

import java.util.List;

public class MasterRequestDto {
    private String fullName;
    private List<Long> readyOrdersId;

    public String getfullName() {
        return fullName;
    }

    public List<Long> getReadyOrdersId() {
        return readyOrdersId;
    }
}
