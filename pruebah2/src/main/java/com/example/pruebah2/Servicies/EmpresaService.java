package com.example.pruebah2.Servicies;


import com.example.pruebah2.entities.Empresa;
import com.example.pruebah2.repositories.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService extends BaseService<Empresa, Long, EmpresaRepository> {

    @Autowired
    public EmpresaService(EmpresaRepository repository) {
        super(repository);
    }
}
