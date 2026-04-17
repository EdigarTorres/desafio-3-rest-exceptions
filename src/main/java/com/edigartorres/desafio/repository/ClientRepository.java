package com.edigartorres.desafio.repository;

import com.edigartorres.desafio.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
