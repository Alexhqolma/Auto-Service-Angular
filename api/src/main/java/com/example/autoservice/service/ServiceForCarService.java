package com.example.autoservice.service;

import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.model.Status;
import java.util.List;

public interface ServiceForCarService {
    ServiceForCar save(ServiceForCar serviceForCar);

    ServiceForCar update(ServiceForCar serviceForCar);

    ServiceForCar serviceStatus(Long serviceId, ServiceForCar serviceForCar, Status status);

    ServiceForCar findById(Long id);

    List<ServiceForCar> findAll();
}
