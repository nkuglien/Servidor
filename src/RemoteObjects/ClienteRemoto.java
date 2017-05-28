package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import RemoteObject.TDACliente;
import controllers.ClienteController;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteRemoto extends UnicastRemoteObject implements TDACliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1395733353845311456L;

	public ClienteRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ClienteDTO> getAllClientes() throws RemoteException {
		
		return ClienteController.GetInstancia().getAllClientes();
		}

	@Override
	public boolean verificarCliente(int parseInt) throws RemoteException {
		return ClienteController.GetInstancia().verificarCliente(parseInt);
	}

	@Override
	public ClienteDTO altaCliente(ClienteDTO clienteDTO)
			throws RemoteException {
		return ClienteController.GetInstancia().altaCliente(clienteDTO);
		
	}

	@Override
	public ClienteDTO bajaCliente(long cuit) throws RemoteException {
		return ClienteController.GetInstancia().bajaCliente(cuit);
	}


	@Override
	public ClienteDTO modificarCliente(ClienteDTO cliente) throws RemoteException {
		return ClienteController.GetInstancia().modificarCliente(cliente);
	}

	@Override
	public ClienteDTO buscarCliente(String cuit)throws RemoteException {
		return ClienteController.GetInstancia().buscarCliente(cuit);
	}

	
	

}
