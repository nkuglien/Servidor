package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.PedidoClienteDTO;
import RemoteObject.TDAPedido;
import controllers.PedidoController;

public class PedidoRemoto extends UnicastRemoteObject implements TDAPedido {

	private static final long serialVersionUID = 5061581304714297160L;

	public PedidoRemoto() throws RemoteException {
		super();
	}

	@Override
	public List<PedidoClienteDTO> getAllPedidos() throws RemoteException {
		return PedidoController.getInstance().getAllPedidos();
	}

}
