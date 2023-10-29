package com.tarea2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarea2.documentos.Domicilio;
import com.tarea2.documentos.Personas;
import com.tarea2.repository.DomicilioRepository;
import com.tarea2.repository.PersonaRepository;

@RestController
@RequestMapping("/Domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioRepository domicilioRepo;
    
    @Autowired
    private PersonaRepository personaRepo;

    @PostMapping
    public ResponseEntity<?> saveDomicilio(@RequestBody Domicilio domicilio) {
        try {
            // Verificar si la persona (por cédula) existe en la base de datos de personas
            int cedulaPersona = domicilio.getCedula();
            Personas existingPersona = personaRepo.findByCedula(cedulaPersona);
            if (existingPersona == null) {
                return new ResponseEntity<String>("No existe una persona con la cédula aportada como parámetro", HttpStatus.BAD_REQUEST);
            }

            // Asociar el domicilio a la persona y guardar el domicilio
            domicilio.setCedula(cedulaPersona);
            Domicilio domicilioSave = domicilioRepo.save(domicilio);
            return new ResponseEntity<Domicilio>(domicilioSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> getDomiciliosPorCedula(@RequestParam int cedulaPersona) {
        try {
            // Verificar si la persona (por cédula) existe en la base de datos de personas
            Personas existingPersona = personaRepo.findByCedula(cedulaPersona);
            if (existingPersona == null) {
                return new ResponseEntity<String>("No existe una persona con la cédula aportada como parámetro", HttpStatus.BAD_REQUEST);
            }

            // Realizar la consulta de todos los domicilios asociados a la cédula
            List<Domicilio> domicilios = domicilioRepo.findByCedula(cedulaPersona);

            return new ResponseEntity<List<Domicilio>>(domicilios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
