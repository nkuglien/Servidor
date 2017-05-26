package controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import RemoteObject.ClienteRemote;
import model.Cliente;

public class ClienteController extends UnicastRemoteObject implements ClienteRemote {

	public ClienteController() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}




	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public List<ClienteDTO> GetClientes() throws RemoteException {
		List<ClienteDTO> clientesRetorno = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = ClienteDAO.getInstancia().GetClientes();
		
		for(Iterator<Cliente> cli =clientes.iterator(); cli.hasNext();){
			Cliente sig = cli.next();
			clientesRetorno.add(sig.toDTO());			
		}
		return clientesRetorno;
	}

}
