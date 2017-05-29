package test;

import model.AreaProduccion;

public class TestAreaProduccion {
	
	public static void main(String[] args) {
		AreaProduccion areaCorte = crearAreaProduccion(1000, "Area de Corte");
		areaCorte.agregarLinea("Linea1", true);
		areaCorte.agregarLinea("Linea2", true);
		areaCorte.agregarLinea("Linea3", true);
		areaCorte.save();
		
		AreaProduccion areaPlanchado = crearAreaProduccion(1001, "Area de Planchado");
		areaPlanchado.agregarLinea("Linea1", true);
		areaPlanchado.agregarLinea("Linea2", true);
		areaPlanchado.agregarLinea("Linea3", true);
		areaPlanchado.save();
	}
	
	private static AreaProduccion crearAreaProduccion(Integer codigo, String nombre) {
		AreaProduccion area = new AreaProduccion(codigo, nombre);
		area.save();
		return area;
	}

}
