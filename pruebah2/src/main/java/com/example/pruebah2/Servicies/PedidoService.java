package com.example.pruebah2.Servicies;


import com.example.pruebah2.entities.Pedido;
import com.example.pruebah2.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

@Autowired
private PedidoRepository pedidoRepository;



    public List<Pedido> findAll1() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById1(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public boolean delete1(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Pedido insert1(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update1(Pedido pedido, Long id) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }


}


