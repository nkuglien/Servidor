package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import DTO.PedidoInsumoDTO;
import dao.ClienteDAO;
import dao.PedidoInsumoDAO;
import model.Cliente;
import model.PedidoInsumo;

public class PedidoInsumoController {

	private static PedidoInsumoController instance;

	public static PedidoInsumoController getInstance() {
		if (instance == null) {
			instance = new PedidoInsumoController();
		}
		return instance;
	}

	public List<PedidoInsumoDTO> getAllPedidos() throws RemoteException {
		List<PedidoInsumoDTO> pedidosDTO = new ArrayList<PedidoInsumoDTO>();
		List<PedidoInsumo> pedidos = PedidoInsumoDAO.getInstance().getAllInsumos();

		for (PedidoInsumo ped : pedidos) {
			pedidosDTO.add(ped.toDTO());
		}
		return pedidosDTO;
	}

	

}
