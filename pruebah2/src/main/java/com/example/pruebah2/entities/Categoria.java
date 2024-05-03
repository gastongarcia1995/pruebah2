package com.example.pruebah2.entities;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Categoria extends Base{

    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private  List<Sucursal> sucursales = new ArrayList();


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,orphanRemoval = true, mappedBy = "categoria")
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private  List<Articulo> articulos = new ArrayList();


    @ManyToOne
    @Nullable
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Categoria> subCategorias = new ArrayList<>();

}