package com.example.databasekp.service;

import com.example.databasekp.model.Client;
import com.example.databasekp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client getById(Long id){
        return repository.findById(id).get();
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

    public void save(Client client){
        repository.save(client);
    }


}
