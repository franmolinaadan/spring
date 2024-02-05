package com.severo.spring.controller;


import com.severo.spring.entity.Client;
import com.severo.spring.entity.Club;
import com.severo.spring.entity.Garage;
import com.severo.spring.service.ClubService;
import com.severo.spring.service.GarageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Garage API",description = "Spring application with spring-boot by Fran Molina")
@RestController
@RequestMapping("/api/garage")
public class GarageRestController {
    private final GarageService garageService;
    public GarageRestController(GarageService garageService){
        this.garageService=garageService;
    }
    @GetMapping("/getAllGarages")
    @Tag(name = "Obtener todos los garajes")
    public List<Garage> getGarages(){
        return garageService.getAll();
    }
    @Tag(name = "Obtener un garaje por ID")
    @GetMapping("/getGarageById/{id}")
    public Garage getGarageById(@PathVariable("id")Long id){
        return garageService.getById(id);
    }
    @Tag(name = "Crear un objeto Garage")
    @PostMapping("/create")
    public ResponseEntity<Garage> newGarage(@RequestBody Garage garage){
        Garage newGarage = garageService.create(garage);
        return new ResponseEntity<>(newGarage, HttpStatus.CREATED);
    }
}
