package com.example.pruebah2.controller;

import com.example.pruebah2.Servicies.EmpresaService;
import com.example.pruebah2.entities.Domicilio;
import com.example.pruebah2.entities.Empresa;
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
    public Optional<Empresa> findallEmpresabyId(@PathVariable Long id){

        return this.empresaService.findallbyId(id);
    }



    @PostMapping ("/empresa/insertEmpresa")
    public Empresa insertEmpresa(@RequestBody  Empresa empresa){

        return this.empresaService.insert(empresa);
    }


}
