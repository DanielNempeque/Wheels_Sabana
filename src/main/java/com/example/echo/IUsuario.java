package com.example.echo;

public interface IUsuario {
	public abstract String adicionar(String correo, String contrasena, String nombre);
	public abstract boolean modificar(String correo, String contrasena);
	public abstract String consultar(String correo);
	public String getCorreo();
	public void setCorreo(String correo);
	public String getContrasena();
	public void setContrasena(String contrasena);
	public String getNombre();
	public void setNombre(String nombre);
}
