package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.MasterMapper;
import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.service.MasterService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;
    private final MasterMapper masterMapper;
    private final OrderMapper orderMapper;

    public MasterController(MasterService masterService,
                            MasterMapper masterMapper, OrderMapper orderMapper) {
        this.masterService = masterService;
        this.masterMapper = masterMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public MasterResponseDto create(@RequestBody MasterRequestDto masterRequestDto) {
        Master master = masterService.save(masterMapper.mapToModel(masterRequestDto));
        return masterMapper.mapToDto(master);
    }

    @PutMapping("/{id}")
    public MasterResponseDto update(@PathVariable Long id,
                                    @RequestBody MasterRequestDto masterRequestDto) {
        Master master = masterMapper.mapToModel(masterRequestDto);
        master.setId(id);
        return masterMapper.mapToDto(masterService.save(master));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> findAllOrders(@PathVariable Long id) {
        return masterService.findReadyOrder(id)
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/salary")
    public double getSalary(@PathVariable Long id) {
        return masterService.getSalary(id);
    }

    @GetMapping
    public List<MasterResponseDto> getMasters() {
        return masterService.findAll().stream()
                .map(masterMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
