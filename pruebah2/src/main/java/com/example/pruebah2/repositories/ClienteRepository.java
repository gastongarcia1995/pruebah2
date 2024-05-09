package com.example.pruebah2.repositories;

import com.example.pruebah2.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
