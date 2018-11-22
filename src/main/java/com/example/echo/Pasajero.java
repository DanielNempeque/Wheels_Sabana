package com.example.echo;

public class Pasajero extends Usuario {
	
	public Pasajero() {
		super();
	}
	
	@Override
	public String adicionar(String correo, String contrasena, String nombre) {
		if(correo != null && contrasena != null && nombre != null){
			if(correo != "" && contrasena != "" && nombre != ""){
				super.setCorreo(correo);
				super.setContrasena(contrasena);
				super.setNombre(nombre);
				return "Se ha creado un pasajero exitoso con los datos:\n"
						+ "Nombre: "+nombre
						+ "\nCorreo: "+correo
						+ "\nContraseña: "+contrasena;
			}
		}
		return null;
	}

	@Override
	public boolean modificar(String correo, String contrasena) {
		if(correo != null && contrasena != null){
			if(correo != "" && contrasena != ""){
				super.setCorreo(correo);
				super.setContrasena(contrasena);
				return true;
			}
		}
		return false;
	}

	@Override
	public String consultar(String correo) {
		if(super.getCorreo().equals(correo)){
			return super.getContrasena();
		}
		return null;
	}

}