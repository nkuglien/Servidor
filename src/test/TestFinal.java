package test;

import java.rmi.RemoteException;
import java.util.List;

import DTO.PrendaDTO;
import controllers.PrendaController;
import dao.AreaProduccionDAO;
import dao.ClienteDAO;
import dao.InsumoDAO;
import model.AreaProduccion;
import model.Cliente;
import model.Insumo;
import model.LoteVariedadPrenda;
import model.Prenda;
import model.Proveedor;
import model.Sucursal;

public class TestFinal {

	public static void main(String[] args) {
		TestPosiciones.main(null);
		TestAreaProduccion.main(args);
		TestCrearCliente.main(args);
		TestInsumo.main(args);
		TestPrenda.main(args);
		TestProveedor.main(args);
		TestSucursal.main(args);
		
		System.out.println("listo test final");
		
		System.exit(0);
		
	}
	

}
