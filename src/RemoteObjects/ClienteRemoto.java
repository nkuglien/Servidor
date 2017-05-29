package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.ClienteDTO;
import RemoteObject.TDACliente;
import controllers.ClienteController;

public class ClienteRemoto extends UnicastRemoteObject implements TDACliente {
	
	private static final long serialVersionUID = -1395733353845311456L;

	public ClienteRemoto() throws RemoteException {
		super();
	}

	@Override
	public List<ClienteDTO> getAllClientes() throws RemoteException {

		return ClienteController.getInstance().getAllClientes();
	}

	@Override
	public ClienteDTO altaCliente(ClienteDTO clienteDTO) throws RemoteException {
		return ClienteController.getInstance().altaCliente(clienteDTO);

	}

	@Override
	public ClienteDTO bajaCliente(ClienteDTO cliente) throws RemoteException {
		return ClienteController.getInstance().bajaCliente(cliente);
	}

	@Override
	public ClienteDTO modificarCliente(ClienteDTO cliente) throws RemoteException {
		return ClienteController.getInstance().modificarCliente(cliente);

	}

	@Override
	public ClienteDTO buscarCliente(String cuit) throws RemoteException {
		return ClienteController.getInstance().buscarCliente(cuit);

	}

}
