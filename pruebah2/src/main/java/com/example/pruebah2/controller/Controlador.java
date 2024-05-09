package com.example.pruebah2.controller;
import com.example.pruebah2.Servicies.*;
import com.example.pruebah2.entities.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.example.pruebah2.entities.UnidadMedida;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class Controlador {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CategoriaService categoriaService;


    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @Autowired
    private ArticuloInsumoService articuloInsumoService;

    @GetMapping("/allEmpresas")
    public List<Empresa> findAllEmpresas() {
        return empresaService.findAll();
    }

    @GetMapping("/empresa/{id}")
    public Optional<Empresa> findEmpresaById(@PathVariable Long id) {
        return empresaService.findById(id);
    }

    @PostMapping("/empresa/insertEmpresa")
    public Empresa insertEmpresa(@RequestBody Empresa empresa) {
        return empresaService.insert(empresa);
    }

    @GetMapping("/allPedidos")
    public List<Pedido> findAllPedidos() {
        return pedidoService.findAll();
    }

    @GetMapping("/pedido/{id}")
    public Optional<Pedido> findPedidoById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @PostMapping("/pedido/insertPedido")
    public Pedido insertPedido(@RequestBody Pedido pedido) {
        return pedidoService.insert(pedido);
    }
//-----------------------------------------------
    @GetMapping("/allCategorias")
    public List<Categoria> findAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/categoria/{id}")
    public Optional<Categoria> findCategoriaById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/categoria/insertCategoria")
    public Categoria insertCategoria(@RequestBody Categoria categoria) {
        return categoriaService.insert(categoria);
    }
//-----------------------------------------------


    @GetMapping("/allArticulosInsumo")
    public List<ArticuloInsumo> findAllArticulosInsumo() {

        return articuloInsumoService.findAll();
    }

    @GetMapping("/articuloInsumo/{id}")
    public Optional<ArticuloInsumo> findArticuloInsumoById(@PathVariable Long id) {
        return articuloInsumoService.findById(id);
    }

    @PostMapping("/articuloInsumo/insertArticuloInsumo")
    public ArticuloInsumo insertArticuloInsumo(@RequestBody ArticuloInsumo articuloInsumo) {
        return articuloInsumoService.insert(articuloInsumo);
    }
//-----------------------------------------------

    @GetMapping("/allUnidadesMedida")
    public List<UnidadMedida> findAllUnidadesMedida() {
        return unidadMedidaService.findAll();
    }

    @GetMapping("/unidadMedida/{id}")
    public UnidadMedida findUnidadMedidaById(@PathVariable Long id) {
        return unidadMedidaService.findById(id).get();
    }

    @PostMapping("/unidadMedida/insertUnidadMedida")
    public UnidadMedida insertUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
        return unidadMedidaService.insert(unidadMedida);
    }
    }





