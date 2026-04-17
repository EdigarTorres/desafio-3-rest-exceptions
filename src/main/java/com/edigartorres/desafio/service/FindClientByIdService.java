package com.edigartorres.desafio.service;

import com.edigartorres.desafio.dto.ClientDTO;
import com.edigartorres.desafio.entity.Client;
import com.edigartorres.desafio.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigartorres.desafio.service.exception.NoSuchElementException;

@Service
public class FindClientByIdService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientDTO findClient(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Recurso não encontrado"));
        return new ClientDTO(client);
    }
}
