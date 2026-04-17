package com.edigartorres.desafio.controller;

import com.edigartorres.desafio.dto.ClientDTO;
import com.edigartorres.desafio.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private FindClientByIdService findClientByIdService;

    @Autowired
    private FindPagedClientService findPagedClientService;

    @Autowired
    private InsertClientService insertClientService;

    @Autowired
    private UpdateClientService updateClientService;

    @Autowired
    private DeleteClientService deleteClientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById (@PathVariable Long id) {
        ClientDTO dto = findClientByIdService.findClient(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll (Pageable pageable) {
        Page<ClientDTO> dto =  findPagedClientService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert (@Valid @RequestBody ClientDTO dto) {
        dto = insertClientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update (@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        dto = updateClientService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        deleteClientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
