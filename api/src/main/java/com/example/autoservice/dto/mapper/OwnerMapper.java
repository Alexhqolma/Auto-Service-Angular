package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.OrderService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements RequestDtoMapper<OwnerRequestDto, Owner>,
        ResponseDtoMapper<OwnerResponseDto, Owner> {
    private final CarService carService;
    private final OrderService orderService;

    public OwnerMapper(CarService carService, OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }

    @Override
    public Owner mapToModel(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setName(dto.getName());
        owner.setCars(dto.getCarsId()
                .stream()
                .map(carService::findById)
                .collect(Collectors.toList()));
        owner.setOrders(dto.getOrdersId()
                .stream()
                .map(orderService::findById)
                .collect(Collectors.toList()));
        return owner;
    }

    @Override
    public OwnerResponseDto mapToDto(Owner owner) {
        OwnerResponseDto ownerResponseDto = new OwnerResponseDto();
        ownerResponseDto.setName(owner.getName());
        ownerResponseDto.setId(owner.getId());
        ownerResponseDto.setCarsId(owner.getCars()
                .stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        ownerResponseDto.setOrdersId(owner.getOrders()
                .stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return ownerResponseDto;
    }
}
