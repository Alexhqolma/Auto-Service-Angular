package com.example.autoservice.service;

import com.example.autoservice.model.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);

    Car update(Car car);

    Car findById(Long id);

    List<Car> findAll();
}
