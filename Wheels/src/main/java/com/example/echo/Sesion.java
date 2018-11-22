package com.example.echo;

public class Sesion {
String sesion;

public String getSesion() {
	return sesion;
}

public void setSesion(String sesion) {
	this.sesion = sesion;
}
public void nuevasesion() {
	
	this.sesion= Math.random()+"";
}
}
