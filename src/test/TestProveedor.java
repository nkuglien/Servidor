package test;

import dao.InsumoDAO;
import model.Insumo;
import model.Proveedor;

public class TestProveedor {
	
	public static void main(String[] args) {
		TestInsumo.main(args);
		
		Proveedor proveedor = crearProveedor("Proveedor Carlitos");
		
		Insumo insumo = InsumoDAO.getInstance().findByCodigo(1000);
		proveedor.altaInsumo(insumo, 10);
		
		insumo = InsumoDAO.getInstance().findByCodigo(1001);
		proveedor.altaInsumo(insumo, 20);
		
		insumo = InsumoDAO.getInstance().findByCodigo(1003);
		proveedor.altaInsumo(insumo, 30);
		
		proveedor.save();
	}
	
	private static Proveedor crearProveedor(String nombre) {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(nombre);
		proveedor = proveedor.save();
		return proveedor;
	}

}
