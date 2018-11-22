package com.example.echo;

import java.util.HashMap;

public class Factory {
	private HashMap<String, IUsuario> usuarios = new HashMap<String,IUsuario>();
	
	private static Factory unicaInstancia = null;
	
	public static Factory reemplazarConstructora() {
		if (unicaInstancia == null)
			unicaInstancia = new Factory();
		return unicaInstancia;
	}
	public void saveUsuario(IUsuario usuario) {
		usuarios.put(usuario.getCorreo(), usuario);
	}
	public IUsuario getUsuario(String correo){
		if((IUsuario) usuarios.get(correo) != null)
			return (IUsuario)usuarios.get(correo);
		return null;
	}
}