package application;

import java.util.List;

public class Resultado {
	private String message;
	private List<Dominio> dominios;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Dominio> getDominios() {
		return dominios;
	}
	
	public void setDominios(List<Dominio> dominios) {
		this.dominios = dominios;
	}
}
