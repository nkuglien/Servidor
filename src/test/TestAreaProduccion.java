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
		
		AreaProduccion areaMarcado = crearAreaProduccion(1002, "Area de Marcado");
		areaMarcado.agregarLinea("Linea1", true);
		areaMarcado.agregarLinea("Linea2", true);
		areaMarcado.agregarLinea("Linea3", true);
		areaMarcado.save();

		AreaProduccion areaHabilitado = crearAreaProduccion(1003, "Area de Habilitado");
		areaHabilitado.agregarLinea("Linea1", true);
		areaHabilitado.agregarLinea("Linea2", true);
		areaHabilitado.agregarLinea("Linea3", true);
		areaHabilitado.save();
		
		AreaProduccion areaCostura = crearAreaProduccion(1004, "Area de Costura");
		areaCostura.agregarLinea("Linea1", true);
		areaCostura.agregarLinea("Linea2", true);
		areaCostura.agregarLinea("Linea3", true);
		areaCostura.save();
		
		AreaProduccion areaEstampado = crearAreaProduccion(1005, "Area de Estampado");
		areaEstampado.agregarLinea("Linea1", true);
		areaEstampado.agregarLinea("Linea2", true);
		areaEstampado.agregarLinea("Linea3", true);
		areaEstampado.save();
		
		AreaProduccion areaAcabado = crearAreaProduccion(1006, "Area de Acabado");
		areaAcabado.agregarLinea("Linea1", true);
		areaAcabado.agregarLinea("Linea2", true);
		areaAcabado.agregarLinea("Linea3", true);
		areaAcabado.save();
		
		AreaProduccion areaEmpacado = crearAreaProduccion(1007, "Area de Empacado");
		areaEmpacado.agregarLinea("Linea1", true);
		areaEmpacado.agregarLinea("Linea2", true);
		areaEmpacado.agregarLinea("Linea3", true);
		areaEmpacado.save();
		
		areaCorte.cambiarEstadoLinea("Linea1", false);
		areaCorte.save();
	}
	
	private static AreaProduccion crearAreaProduccion(Integer codigo, String nombre) {
		AreaProduccion area = new AreaProduccion(codigo, nombre);
		area.save();
		return area;
	}

}
