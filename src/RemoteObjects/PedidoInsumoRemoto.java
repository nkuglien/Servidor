package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import DTO.ClienteDTO;
import DTO.PedidoClienteDTO;
import DTO.PedidoInsumoDTO;
import RemoteObject.TDACliente;
import RemoteObject.TDAPedidoInsumo;
import controllers.ClienteController;
import controllers.PedidoInsumoController;

public class PedidoInsumoRemoto extends UnicastRemoteObject implements TDAPedidoInsumo {
	
	private static final long serialVersionUID = -1395733353845311456L;

	public PedidoInsumoRemoto() throws RemoteException {
		super();
	}

	@Override
	public List<PedidoInsumoDTO> getAllPedidos() throws RemoteException {
		return PedidoInsumoController.getInstance().getAllPedidos();
	}

	@Override
	public void completarPedido(Long id, Long idProveedor, Date fechaDespacho, float precioUnidad)
			throws RemoteException {
		 PedidoInsumoController.getInstance().completarPedido( id,  idProveedor,  fechaDespacho,  precioUnidad);
		
	}

	@Override
	public void terminarPedido(Long id, Date fechaDespachoReal) throws RemoteException {
		 PedidoInsumoController.getInstance().terminarPedido( id, fechaDespachoReal);
		
	}

	

}
