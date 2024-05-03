package com.example.pruebah2.entities;

import com.example.pruebah2.entities.enums.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Promocion extends Base {

    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_promocion",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id")
    )
    private ArrayList <Articulo> articulos= new ArrayList();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "imagen_promocion",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "imagen_id")
    )
    private ArrayList <Imagen> imagenes= new ArrayList();


    @ManyToOne
    private Sucursal sucursal;
}
