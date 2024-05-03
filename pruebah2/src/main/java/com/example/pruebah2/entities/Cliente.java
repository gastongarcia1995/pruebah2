package com.example.pruebah2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Cliente extends Base{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Imagen imagen;

    @OneToMany(mappedBy = "cliente")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList();

    @ManyToMany
    @JoinTable(
            name = "cliente-domicilio",
            joinColumns = @JoinColumn(name = "domicilio_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    @Builder.Default
    private List<Domicilio> domicilios  = new ArrayList();
}
