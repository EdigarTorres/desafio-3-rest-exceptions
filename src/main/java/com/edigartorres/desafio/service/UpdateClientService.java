package com.edigartorres.desafio.service;

import com.edigartorres.desafio.dto.ClientDTO;
import com.edigartorres.desafio.entity.Client;
import com.edigartorres.desafio.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edigartorres.desafio.service.exception.NoSuchElementException;

@Service
public class UpdateClientService {

    @Autowired
    ClientRepository repository;

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
        Client client = repository.getReferenceById(id);
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
        client = repository.save(client);
        return new ClientDTO(client);
        }
        catch (EntityNotFoundException e) {
            throw new NoSuchElementException("Recurso não encontrado");
        }

    }
}
