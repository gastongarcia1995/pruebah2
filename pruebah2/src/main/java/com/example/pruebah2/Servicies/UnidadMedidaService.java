package com.example.pruebah2.Servicies;
import com.example.pruebah2.entities.UnidadMedida;
import com.example.pruebah2.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService extends BaseService<UnidadMedida, Long, UnidadMedidaRepository> {

    @Autowired
    public UnidadMedidaService(UnidadMedidaRepository repository) {
        super(repository);
    }

    // Aquí puedes proporcionar cualquier método adicional específico de UnidadMedida si es necesario
}
