package com.example.pruebah2.repositories;

import com.example.buensaborback.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
