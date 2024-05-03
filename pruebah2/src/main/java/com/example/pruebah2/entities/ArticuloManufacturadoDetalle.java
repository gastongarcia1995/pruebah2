package com.example.pruebah2.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class ArticuloManufacturadoDetalle extends Base {
    private Double cantidad;


    @JoinColumn(name = "articuloInsumo_id")
    private ArticuloInsumo articuloInsumo;
}