package com.severo.spring.controller;


import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Client;
import com.severo.spring.entity.Garage;
import com.severo.spring.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Respuestas de una API Rest.
 * -ResponseEntity: util con respuestas personalizadas (ES UNA CLASE)
 * -@ResponseStatus: codigos de respues de http (ES UNA ANOTACION)
 * -@ResponseBody: no se usa mucho (ES UNA ANOTACION)
 */

@Tag(name = "Statistics API",description = "Spring application with spring-boot by Fran Molina")
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final ClientService clientService;
    public StatisticsController(ClientService clientService){
        this.clientService=clientService;
    }
    @Tag(name = "Obtener la cantidad de motos de un cliente")
    @GetMapping("/getClientBykeNum/{clientId}")
    public int getBykeQuantity(@PathVariable Long clientId){
        return clientService.getBykeQuantity(clientId);
    }
}
