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
import model.Prenda;
import model.Proveedor;
import model.Sucursal;

public class TestFinal {

	public static void main(String[] args) {
		TestAreaProduccion.main(args);
		TestCrearCliente.main(args);
		TestCrearPedido.main(args);
		TestInsumo.main(args);
		try {
			TestPedidoInsumoOrdenProduccion.main(args);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestPrenda.main(args);
		TestProveedor.main(args);
		TestSucursal.main(args);
		
	}
	

}
