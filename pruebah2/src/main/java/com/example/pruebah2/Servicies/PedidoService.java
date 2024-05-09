package com.example.pruebah2.Servicies;


import com.example.pruebah2.entities.Pedido;
import com.example.pruebah2.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoService extends BaseService<Pedido, Long, PedidoRepository> {

    @Autowired
    public PedidoService(PedidoRepository repository) {
        super(repository);
    }
}


