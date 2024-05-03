package com.example.pruebah2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class DetallePedido extends Base{

    private Integer cantidad;
    private Double subTotal;

    @OneToOne
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;


}