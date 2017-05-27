package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import RemoteObject.ClienteRemote;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteRemoto extends UnicastRemoteObject implements ClienteRemote {

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
	public ClienteDTO altaCliente(ClienteDTO clienteDTO)
			throws RemoteException {
		ClienteDAO.getInstance().save(new Cliente(clienteDTO));
		return clienteDTO;
		
	}

	@Override
	public ClienteDTO bajaCliente(long cuit) throws RemoteException {
		return null;
	}


	@Override
	public ClienteDTO modificarCliente(ClienteDTO cliente) throws RemoteException {
		return ClienteDAO.getInstance().update(cliente);
	}

	@Override
	public ClienteDTO buscarCliente(String cuit)throws RemoteException {
		return ClienteDAO.getInstance().findClienteByNroCliente(1).toDTO();
	}

}
