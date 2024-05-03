package com.example.pruebah2.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Provincia extends Base{

    private String nombre;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Pais pais;

}
