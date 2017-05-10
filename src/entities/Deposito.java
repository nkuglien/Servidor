package entities;

import java.util.Map;

public class Deposito {

	private Map<String,Posicion> posiciones;

	public Map<String, Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Map<String, Posicion> posiciones) {
		this.posiciones = posiciones;
	}
	
}
