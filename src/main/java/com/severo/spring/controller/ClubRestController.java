package com.severo.spring.controller;



import com.severo.spring.entity.Club;

import com.severo.spring.service.ClubService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Respuestas de una API Rest.
 * -ResponseEntity: util con respuestas personalizadas (ES UNA CLASE)
 * -@ResponseStatus: codigos de respues de http (ES UNA ANOTACION)
 * -@ResponseBody: no se usa mucho (ES UNA ANOTACION)
 */

@Tag(name = "Club API",description = "Spring application with spring-boot by Fran Molina")
@RestController
@RequestMapping("/api/club")
public class ClubRestController {
    private final ClubService clubService;
    public ClubRestController(ClubService clubService){
        this.clubService=clubService;
    }
    @GetMapping("/getAllClubs")
    @Tag(name = "Obtener todos los clubs")
    public List<Club> getClubs(){
        return clubService.getAll();
    }
    @Tag(name = "Obtener un club por ID")
    @GetMapping("/getClubById/{id}")
    public Club getClubById(@PathVariable("id")Long id){
        return clubService.getById(id);
    }
    @Tag(name = "Obtener un club por nombre")
    @GetMapping("/getClubByName/{name}")
    public List<Club> getClubByName(@PathVariable("name")String name){
        return clubService.searchByName(name);
    }
}
