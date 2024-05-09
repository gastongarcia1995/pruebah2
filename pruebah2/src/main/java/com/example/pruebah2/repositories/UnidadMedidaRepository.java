package com.example.pruebah2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pruebah2.entities.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida,Long> {
}


