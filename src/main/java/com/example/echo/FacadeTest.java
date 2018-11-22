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
	void testListar() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		Facade facade = Facade.reemplazarConstructora();
		// 2 Se crea el ArrayList de reservas
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		// 3 Se crean las diferentes reservas
		Reserva r1 = facade.crearReserva(4, 4, "correo4prueba");
		Reserva r2 = facade.crearReserva(5, 4, "correo4prueba");
		Reserva r3 = facade.crearReserva(6, 3, "correo4prueba");
		Reserva r4 = facade.crearReserva(7, 2, "correo4prueba");
		// 4 Se asigna al arrayList el array de reservas creadas
		reservas=facade.listarReservasHechas("correo4prueba");
		// 5 Se garantiza que el Array de reservas no se encuentre vacio
		assertTrue(!reservas.isEmpty());
	}
	@Test
	void testBuscar() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		Facade facade = Facade.reemplazarConstructora();
		// 3 Se crean las diferentes reservas
		Reserva r1 = facade.crearReserva(4, 4, "correo5prueba");
		// 4 Se asigna al arrayList el array de reservas creadas
		Reserva reserva= facade.buscarReserva("correo5prueba", 4, 4);
		// 5 Se garantiza que el Array de reservas no se encuentre vacio
		assertEquals(reserva.getCorreoPasajero(),"correo5prueba");
	}

}
