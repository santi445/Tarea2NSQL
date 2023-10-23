package com.tarea2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tarea2.documentos.Personas;
 
public interface PersonaRepository extends MongoRepository<Personas, Integer> {

}