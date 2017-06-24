package test;

import java.util.ArrayList;
import java.util.List;

import dao.AreaProduccionDAO;
import dao.InsumoDAO;
import dao.PrendaDAO;
import model.AreaProduccion;
import model.Insumo;
import model.ItemInsumo;
import model.Prenda;
import model.VariedadPrenda;

public class TestPrenda {

	public static void main(String[] args) {
		TestAreaProduccion.main(args);
		TestInsumo.main(args);
		
		Prenda remera = crearPrenda(1000, "Remera", true);

		AreaProduccion areaCorte = AreaProduccionDAO.getInstance().findAreaByCodigo(1000);
		AreaProduccion areaPlanchado = AreaProduccionDAO.getInstance().findAreaByCodigo(1001);

		remera.agregarArea(areaCorte, 1);
		remera.agregarArea(areaPlanchado, 3);
		remera = remera.save();

		Prenda jean = crearPrenda(1001, "Jean", true);

		jean.agregarArea(areaCorte, 2);
		jean.agregarArea(areaPlanchado, 4);
		jean.save();
		
		
		VariedadPrenda rojaXL = crearVariedad(remera, "XL", "Roja", true, 50, 100, 200);
		rojaXL.save();	
		
		Prenda remeraRecuperada = PrendaDAO.getInstance().getAllPrendas().get(0);
		System.out.println(remeraRecuperada);		
		
		long prendaAreaProduccionId = 0;
		remera.removerArea(prendaAreaProduccionId);
		remera.save();
		
		
		Prenda remeraReload = PrendaDAO.getInstance().getPrendaByCodigo(1000);
		System.out.println(remeraReload);
		
		remeraReload.baja();
	}

	private static Prenda crearPrenda(long codigo, String descripcion, boolean enProduccion) {
		Prenda prenda = new Prenda(codigo, descripcion, enProduccion);
		prenda = prenda.save();
		return prenda;
	}

	private static VariedadPrenda crearVariedad(Prenda prenda, String talle, String color, boolean enProduccion,
			float costoProduccionActual, float precioVentaActual, int cantidadProduccionFija) {
		VariedadPrenda variedad = new VariedadPrenda();
		variedad.setPrenda(prenda);
		variedad.setTalle(talle);
		variedad.setColor(color);
		variedad.setEnProduccion(enProduccion);
		variedad.setCostoProduccionActual(costoProduccionActual);
		variedad.setPrecioVentaActual(precioVentaActual);
		variedad.setCantidadProduccionFija(cantidadProduccionFija);
		List<ItemInsumo> insumos = new ArrayList<ItemInsumo>();
		Insumo insumoTela = InsumoDAO.getInstance().findByCodigo(1000);
		insumos.add(new ItemInsumo(insumoTela, 1, 4));
		Insumo insumoBoton = InsumoDAO.getInstance().findByCodigo(1001);
		insumos.add(new ItemInsumo(insumoBoton, 2, 7));
		variedad.setInsumos(insumos);
		return variedad;
	}

}
