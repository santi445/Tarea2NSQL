package com.tarea2.documentos;


import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Personas")
public class Personas implements Serializable{

    private int cedula;

    private String nombre;

    private String apellido;

    private int edad;

    public Personas(int cedula, String nombre, String apellido, int edad) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
