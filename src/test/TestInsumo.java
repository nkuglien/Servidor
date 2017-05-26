package test;

import model.Insumo;

public class TestInsumo {

	public static void main(String[] args) {
		crearInsumo(new Long(1000), "Tela", "Tela", 100, 100);
		crearInsumo(new Long(1001), "Boton", "Boton", 200, 200);
		crearInsumo(new Long(1002), "Colorante", "Colorante", 300, 300);
		crearInsumo(new Long(1003), "Cierre", "Cierre", 400, 400);
	}

	private static void crearInsumo(Long codigo, String descripcion, String nombre, Integer stockMinimo,
			Integer cantCompra) {
		Insumo insumo = new Insumo(codigo, descripcion, nombre, stockMinimo, cantCompra);
		insumo.save();
	}

}
