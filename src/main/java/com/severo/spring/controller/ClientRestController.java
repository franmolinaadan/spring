package com.severo.spring.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Client;
import com.severo.spring.entity.Club;
import com.severo.spring.entity.Garage;
import com.severo.spring.exception.TaskExeption;
import com.severo.spring.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Respuestas de una API Rest.
 * -ResponseEntity: util con respuestas personalizadas (ES UNA CLASE)
 * -@ResponseStatus: codigos de respues de http (ES UNA ANOTACION)
 * -@ResponseBody: no se usa mucho (ES UNA ANOTACION)
 */

@Tag(name = "Client API",description = "Spring application with spring-boot by Fran Molina")
@RestController
@RequestMapping("/api/client")
public class ClientRestController {
    private final ClientService clientService;
    private final ObjectMapper objectMapper;
    public ClientRestController(ClientService clientService, ObjectMapper objectMapper){
        this.clientService=clientService;
        this.objectMapper = objectMapper;
    }
    @GetMapping("/getAllClients")
    @Tag(name = "Obtener todos los clientes")
    public List<Client> getClients(){
        return clientService.getAll();
    }
    @Tag(name = "Obtener un cliente por ID")
    @GetMapping("/getClientById/{id}")
    public Client getClientById(@PathVariable("id")Long id){
        return clientService.getById(id);
    }
    @Tag(name = "Mostrar clientes paginados")
    @GetMapping("/getAllClientsPaginated") //se cambian todos los atributos del objeto
    public List<Client> getClientsPaginated(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "3") Integer pageSize,
                               @RequestParam(defaultValue = "username") String sortBy,
                               @RequestParam(defaultValue = "ASC")Sort.Direction orderBy){
        return clientService.getAllPaginated(pageNo-1,pageSize,sortBy,orderBy);
    }
    @Tag(name = "Crear un objeto Client")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Client> newClient(@RequestBody Client client) {
        Client newClient = clientService.create(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @Tag(name = "Cambiar un objeto Client")
    @PutMapping("/changeClient") //se cambian todos los atributos del objeto
    public Client changeClient(@RequestBody Client client){
        return clientService.changeClient(client);
    }
    @Tag(name = "Eliminar un objeto Client por ID")
    @DeleteMapping("/delete/{id}") //se cambian todos los atributos del objeto
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            clientService.deleteById(id);
            return new ResponseEntity<>("The client was deleted",HttpStatus.OK);
        } catch (TaskExeption e) {
            return new ResponseEntity<>("Error al eliminar",HttpStatus.NOT_MODIFIED);
        }

    }
    @Tag(name = "Obtener todos los clientes hombres")
    @GetMapping("/getMaleClients")
    public List<Client> getMaleClients(){
        return clientService.getMaleClients();
    }
    /**@Tag(name = "Obtener el club al que pertenece un cliente")
    @GetMapping("/getClientClub/{clientId}")
    public Club getClientClub(@PathVariable Long clientId){
        return clientService.getClientClub(clientId);
    }*/
    @Tag(name = "Obtener el garage de un cliente")
    @GetMapping("/getClientGarage/{clientId}")
    public Garage getClientGarage(@PathVariable Long clientId){
     return clientService.getClientGarage(clientId);
     }
    @Tag(name = "Obtener las motos de un cliente")
    @GetMapping("/getClientByke/{clientId}")
    public List<Byke> getClientByke(@PathVariable Long clientId){
        return clientService.getClientByke(clientId);
    }
    @Tag(name = "Obtener un cliente por nombre")
    @GetMapping("/getByUsername/{username}")
    public Client getByUsername(@PathVariable String username){
        return clientService.getByUsername(username);
    }

    @GetMapping("/getAllClientsJSON")
    public ResponseEntity<String> getClientsAndSaveToFile() {
        List<Client> clients = clientService.getAll();

        try {
            String json = objectMapper.writeValueAsString(clients);
            String filePath = "./clientes.json";
            File file = new File(filePath);
            objectMapper.writeValue(file, clients);
            return ResponseEntity.ok(json);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al escribir en el archivo JSON.");
        }
    }
    @GetMapping("/byBirthYear/{year}")
    public ResponseEntity<List<Client>> getClientsByBirthYear(@PathVariable int year) {
        List<Client> clients = clientService.getClientsByBirthYear(year);

        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }
    }
}
