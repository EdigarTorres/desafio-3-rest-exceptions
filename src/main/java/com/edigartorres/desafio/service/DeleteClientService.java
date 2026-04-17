package com.edigartorres.desafio.service;

import com.edigartorres.desafio.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigartorres.desafio.service.exception.NoSuchElementException;

@Service
public class DeleteClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public void delete (Long id) {
        if(!repository.existsById(id)) {
            throw new NoSuchElementException("Id não encontrado");
        }
        repository.deleteById(id);
    }
}
