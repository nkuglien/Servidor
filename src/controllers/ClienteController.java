package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteController{

	private static ClienteController instancia;
	
	public static ClienteController GetInstancia(){
		if(instancia==null)
			instancia= new ClienteController();
		return instancia;
	}
	
	
	
	public List<ClienteDTO> getAllClientes() throws RemoteException {
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = ClienteDAO.getInstance().getAllClientes();
		
		for(Cliente cliente : clientes){
			clientesDTO.add(cliente.toDTO());			
		}
		
		return clientesDTO;
	}


	public boolean verificarCliente(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public ClienteDTO altaCliente(ClienteDTO clienteDTO)
			throws RemoteException {
		ClienteDAO.getInstance().save(new Cliente(clienteDTO));
		return clienteDTO;
		
	}

	public ClienteDTO bajaCliente(long cuit) throws RemoteException {
		return null;
	}


	public ClienteDTO modificarCliente(ClienteDTO cliente) throws RemoteException {
		return ClienteDAO.getInstance().update(cliente);
	}


	public ClienteDTO buscarCliente(String cuit)throws RemoteException {
		return ClienteDAO.getInstance().findClienteByNroCliente(1).toDTO();
	}

		
	public void bajaCliente(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public ClienteDTO solicitarClienteView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
