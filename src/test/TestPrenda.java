package test;

import dao.AreaProduccionDAO;
import model.AreaProduccion;
import model.Prenda;

public class TestPrenda {
	
	public static void main(String[] args) {
		TestAreaProduccion.main(args);
		
		Prenda remera = crearPrenda(new Long(1000), "Remera", true);
		
		AreaProduccion areaCorte = AreaProduccionDAO.getInstance().findAreaByCodigo(1000);
		AreaProduccion areaPlanchado = AreaProduccionDAO.getInstance().findAreaByCodigo(1001);
		
		remera.agregarArea(areaCorte, 1);
		remera.agregarArea(areaPlanchado, 3);
		remera.save();
		
		Prenda jean = crearPrenda(new Long(1001), "Jean", true);
		
		jean.agregarArea(areaCorte, 2);
		jean.agregarArea(areaPlanchado, 4);
		jean.save();
	}
	
	private static Prenda crearPrenda(Long codigo, String descripcion, boolean enProduccion) {
		Prenda prenda = new Prenda(codigo, descripcion, enProduccion);
		prenda = prenda.save();
		return prenda;
	}

}
