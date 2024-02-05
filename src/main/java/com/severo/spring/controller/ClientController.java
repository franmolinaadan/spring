package com.severo.spring.controller;

import com.severo.spring.entity.Client;
import com.severo.spring.exception.ErrorCode;
import com.severo.spring.exception.TaskExeption;
import com.severo.spring.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public String homePage(){
        return "index";
    }
    @GetMapping("/clients")
    public String getClients(Model model){
        model.addAttribute("clients",clientService.getAll());
        return "client/clients";
    }
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("client", new Client());
        return "client/form";
    }
    @PostMapping("/add")
    public String addClient(@ModelAttribute("client")Client client){
        clientService.create(client);
        return "redirect:/view/clients";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Long id, Model model){
        Client client=clientService.getById(id);
        model.addAttribute("client", client);
        return "client/update";
    }
    @PostMapping("/update")
    public String updateClient(@ModelAttribute("client") Client client) {
        try {
            clientService.update(client);
        } catch (TaskExeption e) {
            throw new RuntimeException(e);
        }
        return "redirect:/view/clients";
    }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id, Model model) {
        try {
            clientService.deleteById(id);
            return "redirect:/view/clients";
        } catch (TaskExeption e) {
            model.addAttribute("error", "No se puede eliminar el cliente debido a dependencias.");
            model.addAttribute("clients", clientService.getAll());
            return "client/clients";
        }
    }
}
