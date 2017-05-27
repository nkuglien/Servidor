package controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import RemoteObject.ClienteRemote;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteController extends UnicastRemoteObject implements ClienteRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1395733353845311456L;

	public ClienteController() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ClienteDTO> getAllClientes() throws RemoteException {
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = ClienteDAO.getInstance().getAllClientes();
		
		for(Cliente cliente : clientes){
			clientesDTO.add(cliente.toDTO());			
		}
		
		return clientesDTO;
	}

	@Override
	public boolean verificarCliente(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void altaCliente(ClienteDTO clienteDTO)
			throws RemoteException {
		ClienteDAO.getInstance().save(new Cliente(clienteDTO));
		
	}

	@Override
	public void bajaCliente(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDTO solicitarClienteView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarCliente(ClienteDTO cv, int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
