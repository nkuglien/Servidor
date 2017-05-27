package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import RemoteObject.ClienteRemote;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteController implements ClienteRemote {

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
	public void altaCliente(int parseInt, String text, String text2, int parseInt2, String text3)
			throws RemoteException {
		// TODO Auto-generated method stub
		
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
