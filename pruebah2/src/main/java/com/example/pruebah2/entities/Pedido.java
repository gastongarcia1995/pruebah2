package com.example.pruebah2.entities;

import com.example.pruebah2.entities.enums.Estado;
import com.example.pruebah2.entities.enums.FormaPago;
import com.example.pruebah2.entities.enums.TipoEnvio;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Pedido extends Base{

    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private  Cliente cliente;
    @OneToOne
    private Domicilio domicilio;

    @OneToOne
    private Sucursal sucursal;


    @OneToOne(mappedBy = "pedido")
    private Factura factura;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList();


}