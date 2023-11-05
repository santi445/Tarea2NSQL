package com.tarea2.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Pageable;

import com.tarea2.documentos.Domicilio;
import com.tarea2.documentos.Personas;
import com.tarea2.repository.DomicilioRepository;
import com.tarea2.repository.PersonaRepository;

@RestController
@RequestMapping("/Domicilio")
@ResponseStatus(HttpStatus.OK)
public class DomicilioController extends Exception{

    @Autowired
    private DomicilioRepository domicilioRepo;
    @Autowired
    private PersonaRepository personaRepo;

    @Cacheable(value="cachedGetDom")
    @GetMapping
    public Object getDomiciliosPorCedula(@RequestParam int cedulaPersona, Pageable pageable) throws IOException {
        try {
            // Verifica si la persona (por cédula) existe en la base de datos de personas
            Personas existingPersona = personaRepo.findByCedula(cedulaPersona);
            if (existingPersona == null) {
            	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe una persona con la cédula aportada como parámetro");	
            }
            // Realiza la consulta de todos los domicilios asociados a la cédula
            Page<Domicilio> domiciliosPage = domicilioRepo.findByCedula(cedulaPersona, pageable);
            return domiciliosPage;
        }catch (Exception e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe una persona con la cédula aportada como parámetro");
        }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Domicilio saveDomicilio(@RequestBody Domicilio domicilio)throws IOException{
        try {
            // Verifica si la persona (por cédula) existe en la base de datos de personas
            int cedulaPersona = domicilio.getCedula();
            Personas existingPersona = personaRepo.findByCedula(cedulaPersona);
            if (existingPersona == null) {
            	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe una persona con la cédula aportada como parámetro");
            }
            // Asocia el domicilio a la persona y guarda el domicilio
            domicilio.setCedula(cedulaPersona);
            Domicilio domicilioSave = domicilioRepo.save(domicilio);
            return domicilioSave;
        } catch (Exception e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe una persona con la cédula aportada como parámetro");
        }
    }

    @Cacheable(value="cachedGetDomicilio")
    @GetMapping(value = "/getDomicilio")
    public Object getDomiciliosPorBarrio(@RequestParam Map<String, String> requestParams) {
        try {
        	String barrioDom=requestParams.get("barrio");
        	String localidadDom=requestParams.get("localidad");   	
        	String departamentoDom=requestParams.get("departamento");
        	if(barrioDom!=null & localidadDom!=null & departamentoDom!=null) {
        		List<Domicilio> domicilios = domicilioRepo.findByBarrioAndLocalidadAndDepartamento(barrioDom, localidadDom, departamentoDom);
        		return domicilios;
        	}else if (barrioDom!=null & localidadDom!=null){
        		List<Domicilio> domicilios = domicilioRepo.findByBarrioAndLocalidad(barrioDom, localidadDom);
        		return domicilios;
        	}else if(barrioDom!=null & departamentoDom!=null) {
        		List<Domicilio> domicilios = domicilioRepo.findByBarrioAndDepartamento(barrioDom, departamentoDom);
        		return domicilios;
        	}else if(localidadDom!=null & departamentoDom!=null) {
        		List<Domicilio> domicilios = domicilioRepo.findByLocalidadAndDepartamento(localidadDom, departamentoDom);
        		return domicilios;
        	}else if(departamentoDom!=null){
        		List<Domicilio> domicilios = domicilioRepo.findByDepartamento(departamentoDom);
        		return domicilios;
        	}else if(localidadDom!=null) {
        		List<Domicilio> domicilios = domicilioRepo.findByLocalidad(localidadDom);
        		return domicilios;
        	}else if(barrioDom!=null) {
        		List<Domicilio> domicilios = domicilioRepo.findByBarrio(barrioDom);
        		return domicilios;
        	}
        	//return domicilios;
        } catch (Exception e) {
        	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
   
}