package com.example.pruebah2;

import com.example.pruebah2.controller.Controlador;
import com.example.pruebah2.entities.*;
import com.example.pruebah2.entities.enums.Estado;
import com.example.pruebah2.entities.enums.FormaPago;
import com.example.pruebah2.entities.enums.TipoEnvio;
import com.example.pruebah2.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootApplication
public class Pruebah2Application {

	public static void main(String[] args) {SpringApplication.run(Pruebah2Application.class, args);


	}



	@Bean
	public CommandLineRunner initialize(Controlador controlador) {
		return args -> {


			Pais argentina = Pais.builder()
					.nombre("Argentina").build();
//Se crea provincia
			Provincia mendoza = Provincia.builder()
					.nombre("Mendoza").pais(argentina).build();

			Localidad localidad_sucursal1 = Localidad.builder()
					.nombre("ciudad de mendoza")
					.provincia(mendoza).build();

//Se crea domicilio para sucursal
			Domicilio domicilio_sucursal1 = Domicilio.builder()
					.calle(" valle de las leñas")
					.numero(123)
					.cp(5536)
					.localidad(localidad_sucursal1)
					.build();

//Se crea sucursal
			Sucursal sucursal1 = Sucursal.builder()
					.horarioApertura(LocalTime.parse("08:30"))
					.horarioCierre(LocalTime.parse("21:30"))
					.domicilio(domicilio_sucursal1)
					.nombre("sucursal ciudad de mendoza").build();

//Se crea empresa
			Empresa empresa = Empresa.builder()
					.nombre("El buen sabor")
					.razonSocial("S.A")
					.cuil(123456789).sucursales(new ArrayList<>())
					.build();
			empresa.getSucursales().add(sucursal1); //agrga a la sucursal a empreza
//Se agregan las sucursales a la empresa
			sucursal1.setEmpresa(empresa);

			controlador.insertEmpresa(empresa);
//-----------------------------
			//se crea detalle pedido
			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(1)
					.subTotal(6500.00)
					.articulo(pizzaNapolitana)
					.build();
////////////////////////////////////////
			// Crear pedido
			Pedido pedido = Pedido.builder()
					.horaEstimadaFinalizacion(LocalTime.of(11,16,10))
					.total(100.0)
					.totalCosto(20.0)
					.estado(Estado.Preparacion)
					.tipoEnvio(TipoEnvio.TakeAway)
					.formaPago(FormaPago.MercadoPago)
					.fechaPedido(LocalDate.of(2024,4,23))
					.sucursal(sucursal1)  // Asociar el pedido con la sucursal
					.detallePedidos()
					.build();

// Guardar el pedido
			controlador.insertPedido(pedido);



		};}
}
