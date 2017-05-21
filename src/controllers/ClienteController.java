package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import RemoteObject.ClienteRemote;
import model.Cliente;

public class ClienteController implements ClienteRemote {

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
