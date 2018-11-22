package com.example.echo;


public abstract class Usuario implements IUsuario{
	protected String correo;
	protected String contrasena;
	protected String nombre;
	
	public abstract String adicionar(String correo, String contrasena, String nombre);
	public abstract boolean modificar(String correo, String contrasena);
	public abstract String consultar(String correo);
	
	@Override
	public String getCorreo() {
		return correo;
	}
	@Override
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String getContrasena() {
		return contrasena;
	}
	@Override
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}