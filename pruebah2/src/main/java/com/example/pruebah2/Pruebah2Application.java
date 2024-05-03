package com.example.pruebah2;

import com.example.pruebah2.controller.Controlador;
import com.example.pruebah2.entities.*;
import com.example.pruebah2.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			Provincia mendoza = Provincia.builder()
					.nombre("Mendoza").pais(argentina).build();

			Localidad localidad_sucursal1 = Localidad.builder()
					.nombre("ciudad de mendoza")
					.provincia(mendoza).build();

			Domicilio domicilio_sucursal1 = Domicilio.builder()
					.calle(" valle de las leñas")
					.numero(123)
					.cp(5536)
					.localidad(localidad_sucursal1)
					.build();


			Sucursal sucursal1 = Sucursal.builder()
					.horarioApertura(LocalTime.parse("08:30"))
					.horarioCierre(LocalTime.parse("21:30"))
					.domicilio(domicilio_sucursal1)
					.nombre("sucursal ciudad de mendoza").build();

			Empresa empresa = Empresa.builder()
					.nombre("El buen sabor")
					.razonSocial("S.A")
					.cuil(123456789).sucursales(new ArrayList<>())
					.build();
			empresa.getSucursales().add(sucursal1); //agrga a la sucursal a empreza
			sucursal1.setEmpresa(empresa);

			controlador.insertEmpresa(empresa);
		};}
}
