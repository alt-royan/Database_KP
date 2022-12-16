package com.example.databasekp.controller;

import com.example.databasekp.model.Client;
import com.example.databasekp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client")
    public String clients(Model model) {
        var clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @PostMapping("/client")
    public String saveClient(@RequestParam String name,
                             @RequestParam String phone,
                             @RequestParam String email,
                             @RequestParam String address,
                             @RequestParam String id) {
        var client = new Client();
        client.setId(Long.parseLong(id));
        client.setEmail(email);
        client.setPhone(phone);
        client.setAddress(address);
        client.setFullName(name);
        clientService.save(client);
        return "redirect:/client";
    }

    @GetMapping("/client/{id}")
    public String getClient(@PathVariable Long id, Model model) {
        var client = clientService.getById(id);
        model.addAttribute("client", client);
        return "clientPage";
    }

}