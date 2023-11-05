package com.tarea2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tarea2.documentos.Domicilio;

public interface DomicilioRepository extends MongoRepository<Domicilio, Integer> {
    Page<Domicilio> findByCedula(int cedula, Pageable pageable);
}
