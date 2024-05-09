package com.example.pruebah2.repositories;

import com.example.pruebah2.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
