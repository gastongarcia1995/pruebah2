package com.example.pruebah2.Servicies;


import com.example.pruebah2.entities.ArticuloInsumo;
import com.example.pruebah2.repositories.ArticuloInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoService extends BaseService<ArticuloInsumo, Long, ArticuloInsumoRepository> {

    @Autowired
    public ArticuloInsumoService(ArticuloInsumoRepository repository) {
        super(repository);
    }
}
