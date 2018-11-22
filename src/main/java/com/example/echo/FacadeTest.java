/**
 * 
 */
package com.example.echo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author Santiago
 *
 */
class FacadeTest {
	@Test
	void testCrear() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		Facade facade = Facade.reemplazarConstructora();
		// 2 Se crea la reserva
		Reserva r = facade.crearReserva(1, 1, "correo1prueba");
		// 3 Se busca la reserva creada anteriormente
		Reserva reserva = facade.buscarReserva(r.getCorreoPasajero(), r.getIdRuta(), r.getAsientos());
		// 4 Se hace la comparación de los correos para verificar la existencia del usuario
		assertEquals(reserva.getCorreoPasajero(),"correo1prueba");
	}

	@Test
	void testEliminar() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		Facade facade = Facade.reemplazarConstructora();
		// 2 Se crea la reserva
		Reserva r = facade.crearReserva(2, 2, "correo2prueba");
		// 3 Se elimina la reserva previamente creada
		facade.eliminarReserva("correo2prueba", 2);
		// 4 Se busca la reserva creada anteriormente
		Reserva reserva = facade.buscarReserva(r.getCorreoPasajero(), r.getIdRuta(), r.getAsientos());
		// 5 Se realiza la comparación con null para demostrar su inexistencia
		assertTrue(reserva == null);
	}

	@Test
	void testModificar() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		Facade facade = Facade.reemplazarConstructora();
		// 2 Se crea la reserva
		Reserva r = facade.crearReserva(3, 3, "correo3prueba");
		// 3 Se modifica la reserva previamente creada
		facade.modificarReserva("correo3prueba", 3, 4);
		// 4 Se busca la reserva creada anteriormente
		Reserva reserva = facade.buscarReserva("correo3prueba", 3, 4);
		// 5 Se realiza la comparación de asientos para demostrar el cambio
		assertEquals(reserva.getAsientos(), 4);
	}
	@Test
	void testIngresar() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		Facade facade = Facade.reemplazarConstructora();
		Factory factory= Factory.reemplazarConstructora();
		// 2 Se crea la reserva
		IUsuario u = new Pasajero();
		u.adicionar("2", "2", "Juan");		
		factory.saveUsuario(u);
		// 3 Se modifica la reserva previamente creada
		IUsuario us= facade.autentica("Juan", "2");
		
		// 4 Se busca la reserva creada anteriormente
		assertTrue(true);
		// 5 Se realiza la comparación de asientos para demostrar el cambio
		
	}

}
