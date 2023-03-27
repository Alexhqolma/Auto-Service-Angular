package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.service.OrderService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper implements RequestDtoMapper<MasterRequestDto, Master>,
        ResponseDtoMapper<MasterResponseDto, Master> {
    private final OrderService orderService;

    public MasterMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Master mapToModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setFullName(dto.getfullName());
        master.setReadyOrders(dto.getReadyOrdersId()
                .stream()
                .map(orderService::findById)
                .collect(Collectors.toList()));
        return master;
    }

    @Override
    public MasterResponseDto mapToDto(Master master) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setId(master.getId());
        masterResponseDto.setFullName(master.getFullName());
        masterResponseDto.setReadyOrdersId(master.getReadyOrders()
                .stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return masterResponseDto;
    }
}
