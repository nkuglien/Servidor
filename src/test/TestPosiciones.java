package test;

import model.Posicion;

public class TestPosiciones {
	
	public static void main(String[] args) {
		for(char calle = 'A'; calle <= 'P';calle++) {
			for (int bloque=1; bloque < 4 ; bloque++) {
				for (int estante=1; estante < 4 ; estante++) {
					for (int pos=1; pos < 8 ; pos++) {
						String codigo = calle + String.format("%02d", bloque) + String.format("%02d", estante) + String.format("%02d", pos);
						Posicion p = new Posicion(codigo, true);
						p.save();
					}
				}
			}
		}
	}

}
