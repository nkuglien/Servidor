package test;

import model.Insumo;

public class TestInsumo {

	public static void main(String[] args) {
		crearInsumo(1000, "Tela", "Tela", 100, 100,(float)100);
		crearInsumo(1001, "Boton", "Boton", 200, 200,(float)200);
		crearInsumo(1002, "Colorante", "Colorante", 300, 300,(float)300);
		crearInsumo(1003, "Cierre", "Cierre", 400, 400,(float)400);
	}

	private static void crearInsumo(long codigo, String descripcion, String nombre, Integer stockMinimo, Integer cantCompra,Float precio) {
		Insumo insumo = new Insumo(codigo, descripcion, nombre, stockMinimo, cantCompra,precio);
		insumo.save();
	}

}
