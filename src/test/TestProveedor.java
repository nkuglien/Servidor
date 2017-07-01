package test;

import dao.InsumoDAO;
import model.Insumo;
import model.Proveedor;

public class TestProveedor {
	
	public static void main(String[] args) {
		
		Proveedor proveedor = crearProveedor("Proveedor 1");
		
		Insumo insumo = InsumoDAO.getInstance().findByCodigo(1000);
		proveedor.altaInsumo(insumo, 10);
		
		insumo = InsumoDAO.getInstance().findByCodigo(1001);
		proveedor.altaInsumo(insumo, 20);
		
		insumo = InsumoDAO.getInstance().findByCodigo(1003);
		proveedor.altaInsumo(insumo, 30);
		
		proveedor.save();
		
		Proveedor proveedor2 = crearProveedor("Proveedor 2");
		
		Insumo insumo2 = InsumoDAO.getInstance().findByCodigo(1000);
		proveedor2.altaInsumo(insumo, 10);
		
		insumo2 = InsumoDAO.getInstance().findByCodigo(1001);
		proveedor2.altaInsumo(insumo, 20);
		
		insumo2 = InsumoDAO.getInstance().findByCodigo(1003);
		proveedor2.altaInsumo(insumo, 30);
		
		proveedor2.save();
	}
	
	private static Proveedor crearProveedor(String nombre) {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(nombre);
		proveedor = proveedor.save();
		return proveedor;
	}

}
