package com.edigartorres.desafio.service;

import com.edigartorres.desafio.dto.ClientDTO;
import com.edigartorres.desafio.entity.Client;
import com.edigartorres.desafio.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientDTO insert (ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
        client = repository.save(client);
        return new ClientDTO(client);
    }
}
