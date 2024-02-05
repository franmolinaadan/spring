package com.severo.spring.controller;


import com.severo.spring.entity.Byke;
import com.severo.spring.service.BykeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Byke API",description = "Spring application with spring-boot by Fran Molina")
@RestController
@RequestMapping("/api/byke")
public class BykeRestController {
    private final BykeService bykeService;
    public BykeRestController(BykeService bykeService){
        this.bykeService=bykeService;
    }
    @GetMapping("/getAllBykes")
    @Tag(name = "Obtener todos las motos")
    public List<Byke> getBykes(){
        return bykeService.getAll();
    }
    @Tag(name = "Obtener una moto por ID")
    @GetMapping("/getBykeById/{id}")
    public Byke getBykeById(@PathVariable("id")Long id){
        return bykeService.getById(id);
    }
    @Tag(name = "Crear un objeto Byke")
    @PostMapping("/create")
    public ResponseEntity<Byke> newByke(@RequestBody Byke byke){
        Byke newByke = bykeService.create(byke);
        return new ResponseEntity<>(newByke, HttpStatus.CREATED);
    }
}
