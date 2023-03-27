package com.example.autoservice.service;

import com.example.autoservice.model.Owner;

import java.util.List;

public interface OwnerService {
    Owner save(Owner owner);

    Owner update(Owner owner);

    Owner findById(Long id);

    List<Owner> findAll();
}
