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

<<<<<<< HEAD
	
=======
	public ClienteDTO altaCliente(ClienteDTO clienteDTO) throws RemoteException {
		ClienteDAO.getInstance().save(new Cliente(clienteDTO, true));
		return clienteDTO;

	}

	public ClienteDTO bajaCliente(ClienteDTO cliente) throws RemoteException {
		ClienteDAO.getInstance().baja(new Cliente(cliente, true));
		return cliente;
	}

	public ClienteDTO modificarCliente(ClienteDTO dto) throws RemoteException {
		Cliente cliente = ClienteDAO.getInstance().update(new Cliente(dto, true));
		return cliente != null ? cliente.toDTO() : null;
	}

	public ClienteDTO buscarCliente(String cuit) throws RemoteException {
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit(cuit);
		return cliente != null ? cliente.toDTO() : null;
	}
>>>>>>> branch 'master' of https://github.com/nkuglien/Servidor.git

}
