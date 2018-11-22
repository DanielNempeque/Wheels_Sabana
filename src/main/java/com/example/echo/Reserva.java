package com.example.echo;

public class Reserva {
	private String correoPasajero;
	private String correoConductor;
	private int asientos;
	private int idRuta;
	
	public String getCorreoPasajero() {
		return correoPasajero;
	}
	public void setCorreoPasajero(String correoPasajero) {
		this.correoPasajero = correoPasajero;
	}
	public int getAsientos() {
		return asientos;
	}
	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}
	public int getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}
}