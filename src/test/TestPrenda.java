package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AreaProduccionDAO;
import dao.InsumoDAO;
import dao.PrendaDAO;
import model.AreaProduccion;
import model.Insumo;
import model.ItemInsumo;
import model.LoteVariedadPrenda;
import model.Posicion;
import model.Prenda;
import model.VariedadPrenda;

public class TestPrenda {

	public static void main(String[] args) {
		
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
		
		Prenda campera = crearPrenda(1002, "Campera", true);
		
		campera.agregarArea (areaCorte, 2);
		campera.save();
		
		List<ItemInsumo> insumos1 = new ArrayList<ItemInsumo>();
		Insumo insumoTela = InsumoDAO.getInstance().findByCodigo(1000);
		insumos1.add(new ItemInsumo(insumoTela, 1, 10));
		Insumo insumoBoton = InsumoDAO.getInstance().findByCodigo(1001);
		insumos1.add(new ItemInsumo(insumoBoton, 2, 5));
		Insumo insumoColorante = InsumoDAO.getInstance().findByCodigo(1002);
		insumos1.add(new ItemInsumo(insumoColorante, 1, 3));
		VariedadPrenda rojaXL = crearVariedad(remera, "XL", "Roja", true, 50, 100, 200, insumos1);
		rojaXL = rojaXL.save();
		LoteVariedadPrenda lote = new LoteVariedadPrenda();
		Posicion p = new Posicion("A010320", false, lote);
		lote = new LoteVariedadPrenda(null, 5, 5, p, rojaXL, null, new Date(), Float.parseFloat("100"));
		lote.save();
		
		List<ItemInsumo> insumos2 = new ArrayList<ItemInsumo>();
		Insumo insumoTela2 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos2.add(new ItemInsumo(insumoTela2, 1, 4));
		Insumo insumoBoton2 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos2.add(new ItemInsumo(insumoBoton2, 2, 2));
		Insumo insumoColorante2 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos2.add(new ItemInsumo(insumoColorante2, 1, 3));
		VariedadPrenda rojaL = crearVariedad(remera, "L", "Roja", true, 50, 100, 200, insumos2);
		rojaL = rojaL.save();
		LoteVariedadPrenda lote1 = new LoteVariedadPrenda();
		Posicion p1 = new Posicion("A010321", false, lote1);
		lote1 = new LoteVariedadPrenda(null, 2, 2, p1, rojaL, null, new Date(), Float.parseFloat("150"));
		lote1.save();
		
		List<ItemInsumo> insumos3 = new ArrayList<ItemInsumo>();
		Insumo insumoTela3 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos3.add(new ItemInsumo(insumoTela3, 1, 4));
		Insumo insumoBoton3 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos3.add(new ItemInsumo(insumoBoton3, 2, 3));
		Insumo insumoColorante3 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos3.add(new ItemInsumo(insumoColorante3, 1, 1));
		VariedadPrenda azulRemeraL = crearVariedad(remera, "L", "Azul", true, 50, 100, 200, insumos3);
		azulRemeraL = azulRemeraL.save();
		LoteVariedadPrenda lote2 = new LoteVariedadPrenda();
		Posicion p2 = new Posicion("A010322", false, lote2);
		lote2 = new LoteVariedadPrenda(null, 10, 10, p2, azulRemeraL, null, new Date(), Float.parseFloat("200"));
		lote2.save();
		
		List<ItemInsumo> insumos4 = new ArrayList<ItemInsumo>();
		Insumo insumoTela4 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos4.add(new ItemInsumo(insumoTela4, 1, 9));
		Insumo insumoBoton4 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos4.add(new ItemInsumo(insumoBoton4, 2, 10));
		Insumo insumoColorante4 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos4.add(new ItemInsumo(insumoColorante4, 1, 1));
		VariedadPrenda azulL = crearVariedad (campera, "L", "Azul", true, 50, 100, 200, insumos4);
		azulL = azulL.save();
		LoteVariedadPrenda lote3 = new LoteVariedadPrenda();
		Posicion p3 = new Posicion("A010323", false, lote3);
		lote3 = new LoteVariedadPrenda(null, 10, 10, p3, azulL, null, new Date(), Float.parseFloat("100"));
		lote3.save();
		
		List<ItemInsumo> insumos5 = new ArrayList<ItemInsumo>();
		Insumo insumoTela5 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos5.add(new ItemInsumo(insumoTela5, 1, 9));
		Insumo insumoBoton5 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos5.add(new ItemInsumo(insumoBoton5, 2, 10));
		Insumo insumoColorante5 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos5.add(new ItemInsumo(insumoColorante5, 1, 5));
		VariedadPrenda rojaCamperaL = crearVariedad (campera, "L", "Roja", true, 50, 100, 200, insumos5);
		rojaCamperaL = rojaCamperaL.save();
		
		List<ItemInsumo> insumos6 = new ArrayList<ItemInsumo>();
		Insumo insumoTela6 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos6.add(new ItemInsumo(insumoTela6, 1, 7));
		Insumo insumoBoton6 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos6.add(new ItemInsumo(insumoBoton6, 2, 8));
		Insumo insumoColorante6 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos6.add(new ItemInsumo(insumoColorante6, 1, 2));
		VariedadPrenda azulM = crearVariedad (campera, "M", "Azul", true, 50, 100, 200, insumos6);
		azulM = azulM.save();
		
		List<ItemInsumo> insumos7 = new ArrayList<ItemInsumo>();
		Insumo insumoTela7 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos7.add(new ItemInsumo(insumoTela7, 1, 2));
		Insumo insumoBoton7 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos7.add(new ItemInsumo(insumoBoton7, 2, 5));
		Insumo insumoCierre7 = InsumoDAO.getInstance().findByCodigo(1003);
		insumos7.add(new ItemInsumo(insumoCierre7, 2, 1));
		Insumo insumoColorante7 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos7.add(new ItemInsumo(insumoColorante7, 1, 4));
		VariedadPrenda verdeM = crearVariedad (jean, "M", "Verde", true, 50, 100, 200, insumos7);
		verdeM = verdeM.save();
		LoteVariedadPrenda lote4 = new LoteVariedadPrenda();
		Posicion p4 = new Posicion("A010324", false, lote);
		lote4 = new LoteVariedadPrenda(null, 7, 7, p4, verdeM, null, new Date(), Float.parseFloat("150"));
		lote4.save();
		
		List<ItemInsumo> insumos8 = new ArrayList<ItemInsumo>();
		Insumo insumoTela8 = InsumoDAO.getInstance().findByCodigo(1000);
		insumos8.add(new ItemInsumo(insumoTela8, 1, 5));
		Insumo insumoBoton8 = InsumoDAO.getInstance().findByCodigo(1001);
		insumos8.add(new ItemInsumo(insumoBoton8, 2, 5));
		Insumo insumoColorante8 = InsumoDAO.getInstance().findByCodigo(1002);
		insumos8.add(new ItemInsumo(insumoColorante8, 1, 1));
		VariedadPrenda azulXL = crearVariedad (jean, "XL", "Azul", true, 50, 100, 200, insumos8);
		azulXL = azulXL.save();
		
		

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
			float costoProduccionActual, float precioVentaActual, int cantidadProduccionFija, List<ItemInsumo> insumos) {
		VariedadPrenda variedad = new VariedadPrenda();
		variedad.setPrenda(prenda);
		variedad.setTalle(talle);
		variedad.setColor(color);
		variedad.setEnProduccion(enProduccion);
		variedad.setCostoProduccionActual(costoProduccionActual);
		variedad.setPrecioVentaActual(precioVentaActual);
		variedad.setCantidadProduccionFija(cantidadProduccionFija);
		
		variedad.setInsumos(insumos);
		return variedad;
	}

}
