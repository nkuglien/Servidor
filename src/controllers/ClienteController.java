package controllers;

import java.rmi.RemoteException;

import DTO.ClienteDTO;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {

	private static ClienteController instancia = null;
	private ClienteDAO dao = null;

	public static ClienteController getInstance(){
		if(instancia == null) {
			instancia = new ClienteController();
		} 
		return instancia;
	}
	
	public ClienteController() {
		dao = ClienteDAO.getInstance();
	}
	
	public ClienteDTO buscarCliente(String cuit)throws RemoteException {
		Cliente cliente = dao.findClienteByCuit(cuit);
		return cliente != null? cliente.toDTO() : null;
	}

	public ClienteDTO save(ClienteDTO cliente) {
		return dao.save(new Cliente(cliente)).toDTO();
	}

	public ClienteDTO update(ClienteDTO cliente) {
		return save(cliente);
	}

}
