package com.tarea2.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tarea2.documentos.Personas;
import com.tarea2.repository.PersonaRepository;

@RestController
@RequestMapping("/Personas")
public class PersonasController{

	@Autowired
	private PersonaRepository personaRepo;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Personas savePersona(@RequestBody Personas persona)throws IOException{
	    try {
	        int cedula = persona.getCedula();
	        Personas existingPersona = personaRepo.findByCedula(cedula);
	        if (existingPersona != null) {
	        	throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "La persona ya existe.");         
	        }
	
	        Personas personasave = personaRepo.save(persona);
	        return personasave;
	    } catch (Exception e) {
	    	throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "La persona ya existe.");         
	    }
	}
	
}