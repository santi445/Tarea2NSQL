package com.tarea2.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tarea2.documentos.Domicilio;

public interface DomicilioRepository extends MongoRepository<Domicilio, Integer> {
	Page<Domicilio> findByCedula(int cedula, Pageable pageable);
	List<Domicilio> findByBarrio(String key);
	List<Domicilio> findByLocalidad(String key);
	List<Domicilio> findByDepartamento(String key);
	List<Domicilio> findByBarrioAndLocalidad(String barrioDom, String localidadDom);
	List<Domicilio> findByBarrioAndLocalidadAndDepartamento(String barrioDom, String localidadDom, String departamentoDom);
	List<Domicilio> findByBarrioAndDepartamento(String barrioDom, String departamentoDom);
	List<Domicilio> findByLocalidadAndDepartamento(String localidadDom, String departamentoDom);

}
