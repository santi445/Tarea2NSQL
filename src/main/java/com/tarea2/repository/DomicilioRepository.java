package com.tarea2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tarea2.documentos.Domicilio;

public interface DomicilioRepository extends MongoRepository<Domicilio, Integer> {
    List<Domicilio> findByCedula(int cedula);
}
