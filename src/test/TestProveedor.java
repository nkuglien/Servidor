package test;

import java.util.ArrayList;
import java.util.List;

import dao.InsumoDAO;
import model.Insumo;
import model.InsumoProveedor;
import model.Proveedor;

public class TestProveedor {
	
	public static void main(String[] args) {
		TestInsumo.main(args);
		
		List<InsumoProveedor> insumos = new ArrayList<InsumoProveedor>();
		Insumo insumo = InsumoDAO.getInstance().findByCodigo(new Long(1000));
		insumos.add(new InsumoProveedor(insumo, 100));
		insumo = InsumoDAO.getInstance().findByCodigo(new Long(1001));
		insumos.add(new InsumoProveedor(insumo, 4));
		insumo = InsumoDAO.getInstance().findByCodigo(new Long(1003));
		insumos.add(new InsumoProveedor(insumo, 2));
		crearProveedor("Proveedor Carlitos", insumos);
	}
	
	private static void crearProveedor(String nombre, List<InsumoProveedor> insumos) {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(nombre);
		proveedor.setInsumos(insumos);
		proveedor.save();
	}

}
