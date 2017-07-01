package test;

import dao.InsumoDAO;
import model.Insumo;
import model.Proveedor;

public class TestProveedor {
	
	public static void main(String[] args) {
		TestInsumo.main(args);
		
		Proveedor proveedor = crearProveedor("Proveedor Carlitos");
		Proveedor proveedor2 = crearProveedor("Alfredo marcos");
		Proveedor proveedor3 = crearProveedor("Armando paredes");
		
		
		
		
	}
	
	private static Proveedor crearProveedor(String nombre) {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(nombre);
		proveedor = proveedor.save();
		return proveedor;
	}

}
