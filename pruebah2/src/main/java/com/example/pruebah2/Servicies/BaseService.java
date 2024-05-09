package com.example.pruebah2.Servicies;
// BaseService.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

    protected R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Transactional
    public boolean deleteById(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional

    public T insert(T entity) {
        return repository.save(entity);
    }

    public T update(T entity, ID id) {
        // Implementar la actualización según sea necesario
        return entity;
    }
}
