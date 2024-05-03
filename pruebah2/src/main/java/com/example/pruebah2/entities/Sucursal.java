package com.example.pruebah2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Sucursal extends Base{

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal")
    @Builder.Default
    private List<Promocion> promociones = new ArrayList();




    @OneToMany
    @Builder.Default
    private List<Categoria> categorias = new ArrayList();



}