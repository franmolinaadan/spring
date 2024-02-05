package com.severo.spring.service;

import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Client;
import com.severo.spring.entity.Garage;
import com.severo.spring.exception.ErrorCode;
import com.severo.spring.exception.TaskExeption;
import com.severo.spring.repository.ClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    public Client getById(Long id){
        Optional<Client> optional= clientRepository.findById(id);
        return optional.orElse(null);
    }
    public List<Client> getAllPaginated(Integer pageNo, Integer pageSize, String sortBy, Sort.Direction orderBy){
        Pageable pageable= PageRequest.of(pageNo,pageSize,Sort.by(orderBy,sortBy));
        return clientRepository.findAll(pageable).getContent();
    }
    public Client create(Client client){
        clientRepository.save(client);
        return client;
    }

    public Client changeClient(Client client){
        return clientRepository.save(client);
    }
    public void deleteById(Long id) throws TaskExeption {
        if (!tieneDependencias(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new TaskExeption("No se puede eliminar el cliente debido a dependencias", ErrorCode.DEPENDENCIES);
        }
    }

    public List<Client> getMaleClients(){
        return clientRepository.encontrarClientesHombre();
    }
    /**public Club getClientClub(Long clientId){
        return clientRepository.encontrarClubPorCliente(clientId);
    }*/
    public Garage getClientGarage(Long clientId){
     return clientRepository.encontrarGaragePorCliente(clientId);
     }
    public List<Byke> getClientByke(Long clientId){
        return clientRepository.encontrarMotoPorCliente(clientId);
    }
    public Client getByUsername(String username){
        return clientRepository.searchByUsername(username);
    }
    public int getBykeQuantity(Long clientId){
        return clientRepository.cantidadMotosCliente(clientId);
    }
    private boolean tieneDependencias(Long id) {
        return clientRepository.existsByClientId(id);
    }
    public List<Client> getClientsByBirthYear(int year) {
        return clientRepository.findByBirthYear(year);
    }
    public void update(Client client) throws TaskExeption {
        Optional<Client> existingClientOptional = null;
        if (clientRepository.findById(client.getId())!= null){
             existingClientOptional=clientRepository.findById(client.getId());
        }
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            existingClient.setUsername(client.getUsername());
            clientRepository.save(existingClient);
        } else {
            throw new TaskExeption("No se encontró el cliente con ID: " + client.getId(),ErrorCode.NOT_FOUND);
        }
    }
}
