package com.example.autoservice.service;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Owner;

import java.util.List;

public interface MasterService {
    Master save(Master master);

    Master update(Master master);

    List<Order> findReadyOrder(Long orderId);

    double getSalary(Long masterId);

    Master findById(Long id);

    List<Master> findAll();
}
