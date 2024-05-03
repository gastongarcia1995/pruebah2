package com.example.pruebah2.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
public class ArticuloManufacturado extends Articulo{

    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;


    @OneToMany(mappedBy = "articuloInsumo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private final List<ArticuloManufacturadoDetalle> detalles = new ArrayList();
//final para asegura que, una vez que la lista se haya inicializado en el constructor (o en la misma línea de declaración), no se podrá asignar una nueva instancia de lista a la variable detalles.

}