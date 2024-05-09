package com.example.pruebah2.Servicies;
import com.example.pruebah2.entities.Categoria;
import com.example.pruebah2.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository> {

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        super(repository);
    }
}