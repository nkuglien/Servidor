package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.EstadoPedidoCliente;
import DTO.FacturaDTO;
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

	@Override
	public PedidoClienteDTO cargarPedidoCliente(PedidoClienteDTO dto) throws RemoteException {
		return PedidoController.getInstance().crearPedido(dto).toDTO();
	}

	@Override
	public List<PedidoClienteDTO> getPedidosByCliente(String cuit) throws RemoteException {
		return PedidoController.getInstance().getPedidosByCliente(cuit);
	}

	@Override
	public void cambiarEstadoPedido(Long nroPedido, EstadoPedidoCliente estado) throws RemoteException {
		PedidoController.getInstance().cambiarEstadoPedidoCliente(nroPedido, estado);
	}

	@Override
	public FacturaDTO obtenerFactura(Long nroPedido) throws RemoteException {
		return PedidoController.getInstance().obtenerFactura(nroPedido).toDTO();
	}

}
