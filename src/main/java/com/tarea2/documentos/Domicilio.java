package com.tarea2.documentos;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Domicilio")
public class Domicilio {

    private int cedula; // CI de la persona a la que está asociado este domicilio.
    private String departamento;
    private String localidad;
    private String calle;
    private String numero;
    private String apartamento;
    private String padron;
    private String ruta;
    private String km;
    private String letra;
    private String barrio;
    
	public Domicilio(int cedula, String departamento, String localidad, String calle, String numero, String apartamento,
			String padron, String ruta, String km, String letra, String barrio) {
		super();
		this.cedula = cedula;
		this.departamento = departamento;
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.apartamento = apartamento;
		this.padron = padron;
		this.ruta = ruta;
		this.km = km;
		this.letra = letra;
		this.barrio = barrio;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getPadron() {
		return padron;
	}

	public void setPadron(String padron) {
		this.padron = padron;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	    
}