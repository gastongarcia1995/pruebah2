package com.example.pruebah2.repositories;

import com.example.buensaborback.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}