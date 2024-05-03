package com.example.pruebah2.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Empresa extends Base{

    private String nombre;
    private String razonSocial;
    private Integer cuil;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Sucursal> sucursales =new ArrayList();

}