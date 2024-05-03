package com.example.pruebah2.Servicies;


import com.example.pruebah2.entities.Empresa;
import com.example.pruebah2.repositories.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {




    @Autowired
    private EmpresaRepository empresaRepository ;


    public List<Empresa> findall(){
        return this.empresaRepository.findAll();
    }


    public Optional<Empresa> findallbyId(Long id){
        return this.empresaRepository.findById(id);
    }



    @Transactional
    public boolean delete(Long id){
        if(this.empresaRepository.existsById(id)){

            this.empresaRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }

    }

    public Empresa insert(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    public Empresa update(Empresa empresa, Long id) {
        empresa.setId(id);
        return this.empresaRepository.save(empresa);
    }

}
