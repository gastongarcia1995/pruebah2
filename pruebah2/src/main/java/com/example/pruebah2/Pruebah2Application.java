package com.example.pruebah2;

import com.example.pruebah2.entities.*;
import com.example.pruebah2.entities.enums.Estado;
import com.example.pruebah2.entities.enums.FormaPago;
import com.example.pruebah2.entities.enums.TipoEnvio;
import com.example.pruebah2.controller.Controlador;
import com.example.pruebah2.Servicies.CategoriaService;
import com.example.pruebah2.Servicies.ArticuloInsumoService;
import com.example.pruebah2.Servicies.EmpresaService;
import com.example.pruebah2.Servicies.PedidoService;
import com.example.pruebah2.Servicies.UnidadMedidaService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;




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
// Agregar unidades de medida
			UnidadMedida unidadMedidaLitros = UnidadMedida.builder()
					.denominacion("Litros")
					.build();

			UnidadMedida unidadMedPorcion = UnidadMedida.builder()
					.denominacion("porcion")
					.build();

			UnidadMedida unidadMedidaKilogramos = UnidadMedida.builder()
					.denominacion("Kilogramos")
					.build();

		unidadMedidaKilogramos=	controlador.insertUnidadMedida(unidadMedidaKilogramos);
		unidadMedidaLitros=	controlador.insertUnidadMedida(unidadMedidaLitros);
		unidadMedPorcion=	controlador.insertUnidadMedida(unidadMedPorcion);

// Crear y guardar varios ArticuloInsumo
			ArticuloInsumo cocaCola = ArticuloInsumo.builder()
					.denominacion("Coca cola")
					.esParaElaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.stockActual(5)
					.stockMaximo(50)
					.precioCompra(50.0)
					.precioVenta(70.0)
					.build();
			controlador.insertArticuloInsumo(cocaCola);

			Imagen imagenCoca = Imagen
					.builder().url("https://m.media-amazon.com/images/I/51v8nyxSOYL._SL1500_.jpg").build();
			cocaCola.getImagenes().add(imagenCoca);

/*
			ArticuloInsumo pepsi = ArticuloInsumo.builder()
					.denominacion("Pepsi")
					.unidadMedida(unidadMedidaLitros)
					.esParaElaborar(false)
					.stockActual(10)
					.stockMaximo(60)
					.precioCompra(55.0)
					.precioVenta(75.0)
					.build();
			controlador.insertArticuloInsumo(pepsi);
//___________________________
/*
			// Crear una categoría padre
			Categoria categoriaPrincipal = Categoria
					.builder()
					.denominacion("bebida")
					.subCategorias(new ArrayList<>()) // Inicializar la lista de subcategorías
					.build();

			// Insertar la categoría padre en la base de datos utilizando el servicio
			Categoria categoriaPrincipalGuardada = controlador.insertCategoria(categoriaPrincipal);



			Categoria subCategoria1 = Categoria.builder()
					.denominacion("carbonatada naranja")
					.categoriaPadre(categoriaPrincipalGuardada)
					.sucursales(new ArrayList<>(Set.of(sucursal1))) // Inicializar la lista de sucursales
					.articulos(new ArrayList<>()) // Inicializar la lista de artículos
					.build();

			// Crear una subcategoría
			Categoria subCategoria = Categoria.builder()
					.denominacion("carbonatada")
					.categoriaPadre(categoriaPrincipalGuardada)
					.subCategorias(new ArrayList<>(Set.of(subCategoria1))) // Inicializar la lista de subcategorías
					.sucursales(new ArrayList<>(Set.of(sucursal1))) // Inicializar la lista de sucursales
					.articulos(new ArrayList<>(Set.of(cocaCola))) // Inicializar la lista de artículos

					.build();

			// Insertar la subcategoría en la base de datos utilizando el servicio
			Categoria subCategoriaGuardada = controlador.insertCategoria(subCategoria);

			//se crea detalle pedido
			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(1)
					.subTotal(6500.00)
					.articulo(cocaCola)
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
					.build();

// Guardar el pedido
			controlador.insertPedido(pedido);
*/
		};}
}
