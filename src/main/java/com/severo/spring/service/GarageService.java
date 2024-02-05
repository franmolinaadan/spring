package com.severo.spring.service;

import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Client;
import com.severo.spring.entity.Garage;
import com.severo.spring.repository.ClientRepository;
import com.severo.spring.repository.GarageRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GarageService {
    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository){
        this.garageRepository=garageRepository;
    }

    public List<Garage> getAll(){
        return garageRepository.findAll();
    }
    public Garage getById(Long id){
        Optional<Garage> optional= garageRepository.findById(id);
        return optional.orElse(null);
    }
    public Garage create(Garage garage){
        garageRepository.save(garage);
        return garage;
    }
}
