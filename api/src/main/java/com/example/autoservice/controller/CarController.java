package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.CarMapper;
import com.example.autoservice.dto.request.CarRequestDto;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public CarResponseDto create(@RequestBody CarRequestDto carRequestDto) {
        Car car = carService.save(carMapper.mapToModel(carRequestDto));
        return carMapper.mapToDto(car);
    }

    @PutMapping("/{id}")
    public CarResponseDto update(@PathVariable Long id, @RequestBody CarRequestDto carRequestDto) {
        Car car = carMapper.mapToModel(carRequestDto);
        car.setId(id);
        return carMapper.mapToDto(carService.save(car));
    }

    @GetMapping
    public List<CarResponseDto> getCars() {
        return carService.findAll().stream()
                .map(carMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
