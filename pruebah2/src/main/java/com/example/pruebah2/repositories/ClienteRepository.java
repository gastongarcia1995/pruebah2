package com.example.pruebah2.repositories;

import com.example.buensaborback.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
