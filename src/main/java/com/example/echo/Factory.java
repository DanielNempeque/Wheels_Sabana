package com.example.echo;

import java.util.HashMap;

public class Factory {
	private HashMap<String, IUsuario> usuarios = new HashMap<String,IUsuario>();
	public void saveUsuario(IUsuario usuario) {
		usuarios.put(usuario.getCorreo(), usuario);
	}
	public IUsuario getUsuario(String correo){
		if((IUsuario) usuarios.get(correo) != null)
			return (IUsuario)usuarios.get(correo);
		return null;
	}
}