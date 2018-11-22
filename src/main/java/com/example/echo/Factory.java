package com.example.echo;

import java.util.HashMap;

public class Factory {
	
	private static Factory unicaInstancia = null;
	public static Factory reemplazarConstructora() {
		if (unicaInstancia == null)
			unicaInstancia = new Factory();
		return unicaInstancia;
	}
	private HashMap<String, IUsuario> usuarios = new HashMap<String,IUsuario>();
	public void saveUsuario(IUsuario usuario) {
		usuarios.put(usuario.getCorreo(), usuario);
		System.out.println(usuarios.get(usuario.getCorreo()).getCorreo());
		
	}
	public IUsuario getUsuario(String correo){
		if((IUsuario) usuarios.get(correo) != null) {
			return (IUsuario)usuarios.get(correo);
		}
		return null;
	}
}
