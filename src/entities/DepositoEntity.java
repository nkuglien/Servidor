package entities;

import java.util.Map;

public class DepositoEntity {

	private Map<String,PosicionEntity> posiciones;

	public Map<String, PosicionEntity> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Map<String, PosicionEntity> posiciones) {
		this.posiciones = posiciones;
	}
	
}
