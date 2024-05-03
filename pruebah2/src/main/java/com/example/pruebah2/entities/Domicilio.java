package com.example.pruebah2.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Domicilio extends Base{

    private String calle;
    private Integer numero;
    private Integer cp;

    @ManyToOne(cascade = CascadeType.ALL)
    private Localidad localidad;


    @ManyToMany(mappedBy = "domicilios")
    @Builder.Default
    private List<Cliente> clientes= new ArrayList();


}