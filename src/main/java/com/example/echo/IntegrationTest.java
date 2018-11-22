package com.example.echo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Facade.class, ProxyTest.class })
public class IntegrationTest {

	@Test
	void testAutentica() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		// al igual que el Factory
		Facade facade = Facade.reemplazarConstructora();
		Factory factory = Factory.reemplazarConstructora();
		// 2 Se crea el usuario y se guarda en el factory
		IUsuario u = new Pasajero();
		u.adicionar("2", "2", "Juan");
		factory.saveUsuario(u);
		// 3 Se busca el usuario previmente creado
		IUsuario us = facade.autentica("2", "2");
		// 4 Se compara con nulo para ver si devuelve al usuario de forma correcta
		assertTrue(us != null);
	}

	@Test
	void testCreaIngresaApplicacion() {
		// 1 Se reemplaza la constructora del Facade, o en caso de que no exista se crea
		// al igual que el Factory y el Proxy
		Facade facade = Facade.reemplazarConstructora();
		Factory factory = Factory.reemplazarConstructora();
		Proxy proxy= Proxy.reemplazarConstructura();
		// 2 Se crea el usuario y se guarda en el factory
		IUsuario u = new Pasajero();
		u.adicionar("3", "3", "Fabio");
		factory.saveUsuario(u);
		// 3 Se busca el usuario previmente creado por medio del proxy y se crea la nueva sesion
		Sesion s=proxy.ingresarAplicacion(u.getCorreo(), u.getContrasena());
		// 4 Se compara con nulo para ver si devuelve la sesion de forma correcta
		assertTrue(s != null);
	}

}
