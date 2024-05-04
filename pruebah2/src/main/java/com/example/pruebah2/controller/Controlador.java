package com.example.pruebah2.controller;

import com.example.pruebah2.Servicies.EmpresaService;
import com.example.pruebah2.Servicies.PedidoService;
import com.example.pruebah2.entities.Empresa;
import com.example.pruebah2.entities.Pedido;
import com.example.pruebah2.repositories.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;





@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")

@Getter
public class Controlador {


    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/allEmpresas")
    public List<Empresa> findallEmpresas() {
        return this.empresaService.findall();
    }

    @GetMapping("/empresa/{id}")
    public Optional<Empresa> findallEmpresabyId(@PathVariable Long id) {

        return this.empresaService.findallbyId(id);
    }


    @PostMapping("/empresa/insertEmpresa")
    public Empresa insertEmpresa(@RequestBody Empresa empresa) {

        return this.empresaService.insert(empresa);
    }

    ////////////////__________________________________________________________________________
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/allPedidos")
    public List<Pedido> findAllPedidos() {
        return pedidoService.findAll1();
    }

    @GetMapping("/pedido/{id}")
    public Optional<Pedido> findPedidoById(@PathVariable Long id) {
        return pedidoService.findById1(id);
    }

    @PostMapping("/insertPedido")
    public Pedido insertPedido(@RequestBody Pedido pedido) {
        return pedidoService.insert1(pedido);
    }
}
