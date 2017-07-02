package test;

import model.Posicion;

public class TestPosiciones {
	
	public static void main(String[] args) {
		for(char calle = 'A'; calle <= 'A';calle++) {
			for (int bloque=1; bloque < 6 ; bloque++) {
				for (int estante=1; estante < 7 ; estante++) {
					for (int pos=1; pos < 22 ; pos++) {
						String codigo = calle + String.format("%02d", bloque) + String.format("%02d", estante) + String.format("%02d", pos);
						Posicion p = new Posicion(codigo, true);
						p.save();
					}
				}
			}
		}
	}

}
