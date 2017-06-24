package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {

	private static ClienteController instance;

	public static ClienteController getInstance() {
		if (instance == null) {
			instance = new ClienteController();
		}
		return instance;
	}

	public List<ClienteDTO> getAllClientes() throws RemoteException {
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = ClienteDAO.getInstance().getAllClientes();

		for (Cliente cliente : clientes) {
			clientesDTO.add(cliente.toDTO());
		}

		return clientesDTO;
	}

	public ClienteDTO altaCliente(ClienteDTO clienteDTO) throws RemoteException {
		ClienteDAO.getInstance().save(new Cliente(clienteDTO));
		return clienteDTO;

	}

	public ClienteDTO bajaCliente(ClienteDTO cliente) throws RemoteException {
		ClienteDAO.getInstance().baja(new Cliente(cliente));
		return cliente;
	}

	public ClienteDTO modificarCliente(ClienteDTO dto) throws RemoteException {
		Cliente cliente = ClienteDAO.getInstance().update(new Cliente(dto));
		return cliente != null ? cliente.toDTO() : null;
	}

	public ClienteDTO buscarCliente(String cuit) throws RemoteException {
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit(cuit);
		return cliente != null ? cliente.toDTO() : null;
	}

}
