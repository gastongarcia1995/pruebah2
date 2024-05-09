package com.example.pruebah2.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

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

    protected final ArrayList<Imagen> imagenes = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} ,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidadMedida")
    protected UnidadMedida unidadMedida;

    @ManyToMany(mappedBy = "articulos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Builder.Default
    protected Set<Promocion> estaEnPromociones = new HashSet<>();

    @ManyToOne
    @JoinTable(name = "articulo-categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    protected Categoria categoria;
}
