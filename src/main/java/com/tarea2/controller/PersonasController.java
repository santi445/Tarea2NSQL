package com.tarea2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarea2.documentos.Personas;
import com.tarea2.repository.PersonaRepository;

@RestController
@RequestMapping("/Personas")
public class PersonasController {

	@Autowired
	private PersonaRepository personaRepo;
	
	@PostMapping
	public ResponseEntity<?> savePersona(@RequestBody Personas persona) {
	    try {
	        int cedula = persona.getCedula();
	        Personas existingPersona = personaRepo.findByCedula(cedula);
	        if (existingPersona != null) {
	            return new ResponseEntity<String>("La persona ya existe", HttpStatus.UNAUTHORIZED);
	        }
	
	        Personas personasave = personaRepo.save(persona);
	        return new ResponseEntity<Personas>(personasave, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}