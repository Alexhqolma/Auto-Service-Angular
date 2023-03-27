package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.mapper.OwnerMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.OrderService;
import com.example.autoservice.service.OwnerService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final OrderMapper orderMapper;
    private final OrderService orderService;

    public OwnerController(OwnerService ownerService,
                           OwnerMapper ownerMapper, OrderMapper orderMapper,
                           OrderService orderService) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

    @PostMapping
    public OwnerResponseDto create(@RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = ownerService.save(ownerMapper.mapToModel(ownerRequestDto));
        return ownerMapper.mapToDto(owner);
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@PathVariable Long id,
                                   @RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = ownerMapper.mapToModel(ownerRequestDto);
        owner.setId(id);
        return ownerMapper.mapToDto(ownerService.save(owner));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> findAllOrders(@PathVariable Long id) {
        return orderService.findAllOrdersByOwnerId(id)
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<OwnerResponseDto> findAll() {
        return ownerService.findAll().stream()
                .map(ownerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
