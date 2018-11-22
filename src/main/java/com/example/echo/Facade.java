package com.example.echo;

import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;

@Api(name = "facade", version = "v1", namespace = @ApiNamespace(ownerDomain = "echo.example.com", ownerName = "echo.example.com", packagePath = ""))

public class Facade {
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<String> identidades = new ArrayList<>();
	private static Facade unicaInstancia = null;
	private static Factory factory = Factory.reemplazarConstructora();

	static {
		IUsuario u = new Pasajero();
		u.adicionar("1", "1", "Pedro");
		factory.saveUsuario(u);
	}

	public Facade() {
	}

	public IUsuario autentica(@Named("user") String user, @Named("contrasena") String contrasena) {

		IUsuario usuario = factory.getUsuario(user);
		if (usuario != null) {
			if (usuario.getContrasena().equals(contrasena)) {
				return usuario;
			}
		}
		return null;
	}

	public static Facade reemplazarConstructora() {
		if (unicaInstancia == null)
			unicaInstancia = new Facade();
		return unicaInstancia;
	}

	public void addIdentidad(@Named("ide") String ide) {
		this.identidades.add(ide);
	}

	@ApiMethod(name = "crearReserva")
	public Reserva crearReserva(@Named("idRuta") int idRuta, @Named("asientos") int asientos,
			@Named("correoPasajero") String correoPasajero) {

		Reserva response = new Reserva();
		response.setCorreoPasajero(correoPasajero);
		response.setAsientos(asientos);
		response.setIdRuta(idRuta);
		reservas.add(response);
		return response;
	}

	@ApiMethod(name = "buscarReservasUsuario")
	public ArrayList<Reserva> listarReservasHechas(@Named("correoPasajero") String correoPasajero) {
		ArrayList<Reserva> reservasUsuario = new ArrayList<Reserva>();
		for (Reserva r : reservas) {
			if (r.getCorreoPasajero().equals(correoPasajero)) {
				reservasUsuario.add(r);

			}
		}
		return reservasUsuario;

	}

	@ApiMethod(name = "eliminarReserva")
	public void eliminarReserva(@Named("correoPasajero") String correoPasajero, @Named("idRuta") int idRuta) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getCorreoPasajero().equals(correoPasajero) && reservas.get(i).getIdRuta() == idRuta) {
				reservas.remove(reservas.get(i));
			}
		}

	}

	@ApiMethod(name = "modificarReserva")
	public Reserva modificarReserva(@Named("correoPasajero") String correoPasajero, @Named("idRuta") int idRuta,
			@Named("asientos") int asientos) {
		
		eliminarReserva(correoPasajero, idRuta);
		Reserva r=crearReserva(idRuta, asientos, correoPasajero);
	return r;
	}
	
	public Reserva buscarReserva( String correoPasajero,  int idRuta,
			 int asientos) {
		for (Reserva r : reservas) {
			if (r.getCorreoPasajero().equals(correoPasajero)&&r.getAsientos()==asientos&&r.getIdRuta()==idRuta) {
				return r;

			}
		}
		return null;

	}
	
	
}
