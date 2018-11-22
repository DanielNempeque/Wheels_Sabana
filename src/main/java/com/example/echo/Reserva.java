package com.example.echo;

public class Reserva {
	private String idPasajero;
	private Long idRuta;
	private Long asientos;
	
	/**
	 * The object {@link Reserva} have the information about the route, the passenger that makes the reservation
	 * and the number of seats that will be reserved
	 */
	public Reserva(String pIdPasajero, Long pIdRuta, Long pAsientos) {
		this.idPasajero = pIdPasajero;
		this.idRuta = pIdRuta;
		this.asientos =  pAsientos;
	}

	public String getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(String idPasajero) {
		this.idPasajero = idPasajero;
	}

	public Long getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
	}

	public Long getAsientos() {
		return asientos;
	}

	public void setAsientos(Long asientos) {
		this.asientos = asientos;
	}
	
	
}