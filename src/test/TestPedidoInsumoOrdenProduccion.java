package test;

import java.rmi.RemoteException;
import java.util.List;

import DTO.PrendaDTO;
import controllers.PrendaController;

public class TestPedidoInsumoOrdenProduccion {

	public static void main(String[] args) throws RemoteException {
		List<PrendaDTO> prenda = PrendaController.getInstance().getAllPrendas();
		System.out.println(prenda);
		
	}

}
