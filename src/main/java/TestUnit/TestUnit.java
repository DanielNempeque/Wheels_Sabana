package TestUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.echo.Facade;
import com.example.echo.Factory;
import com.example.echo.IUsuario;
import com.example.echo.Pasajero;
import com.example.echo.Reserva;

class TestUnit {

	@Test
	void testsaveUsuario() {
		Facade f = Facade.remplazarConstructora();
		Factory fw = new Factory();
		IUsuario usuario = new Pasajero();
		usuario.adicionar("prueba@unisabana.edu.co","123","prueba");
		fw.saveUsuario(usuario);
		assertEquals(fw.getUsuario(usuario.getCorreo()),usuario);
		
		
	}
	@Test
	void testcrearReserva() {
		Facade f = Facade.remplazarConstructora();
		Reserva r = new Reserva();
		r.setAsientos(1);
		r.setCorreoPasajero("prueba1@unisabana.edu.co");
		r.setIdRuta(1);
	f.crearReserva(r.getIdRuta(), r.getAsientos(), r.getCorreoPasajero());
		
	assertTrue(f.listarReservasHechas("prueba1@unisabana.edu.co")!=null);
		
		
		}
	@Test
	void testEliminar() {
		Facade f = Facade.remplazarConstructora();
		Reserva r = new Reserva();
		r.setAsientos(2);
		r.setCorreoPasajero("prueba2@unisabana.edu.co");
		r.setIdRuta(2);
	f.crearReserva(r.getIdRuta(), r.getAsientos(), r.getCorreoPasajero());
	f.eliminarReserva("prueba2@unisabana.edu.co", 2);

		
	assertTrue(f.listarReservasHechas("prueba2@unisabana.edu.co")==null);
		
		
		}

	

	

}
