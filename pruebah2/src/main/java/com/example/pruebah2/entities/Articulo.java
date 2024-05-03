package com.example.pruebah2.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    protected String denominacion;
    protected Double precioVenta;

    protected final ArrayList <Imagen>  imagenes= new ArrayList();


    @ManyToOne(cascade = CascadeType.ALL)
    protected UnidadMedida unidadMedida;


    @ManyToMany(mappedBy = "articulos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Builder.Default //cambbi
    protected ArrayList <Promocion> estaEnPromociones= new ArrayList();

    @ManyToOne
    @JoinTable(name = "articulo-categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    protected Categoria categoria;
}