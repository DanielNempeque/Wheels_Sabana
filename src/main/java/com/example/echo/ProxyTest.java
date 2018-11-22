package com.example.echo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProxyTest {

	@Test
	void testIngresarAplicación() {
		/// 1 Se reemplaza la constructora del Proxy, o en caso de que no exista se crea
		Proxy proxy= Proxy.reemplazarConstructura();
		// 2 Se asigna a una nueva sesion el usuario creado por defecto
		Sesion sesion=proxy.ingresarAplicacion("1", "1");
		// 3 Se compara con null para verificar la existencia de la sesion
		assertTrue(sesion!=null);
	}
	
	

}
