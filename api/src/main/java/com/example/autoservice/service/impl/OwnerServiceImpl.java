package com.example.autoservice.service.impl;

import com.example.autoservice.model.Owner;
import com.example.autoservice.repository.OwnerRepository;
import com.example.autoservice.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }



    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find owner by id " + id));
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
