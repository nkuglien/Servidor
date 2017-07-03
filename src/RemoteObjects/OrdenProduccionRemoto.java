package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.ClienteDTO;
import DTO.LoteVariedadPrendaDTO;
import DTO.OrdenProduccionDTO;
import RemoteObject.TDACliente;
import RemoteObject.TDAOrdenProduccion;
import controllers.ClienteController;
import controllers.OrdenProduccionController;

public class OrdenProduccionRemoto extends UnicastRemoteObject implements TDAOrdenProduccion {
	
	private static final long serialVersionUID = -1395733353845311456L;

	public OrdenProduccionRemoto() throws RemoteException {
		super();
	}

	@Override
	public List<OrdenProduccionDTO> getAll() throws RemoteException {
		return OrdenProduccionController.getInstance().getAll();
	}

	@Override
	public OrdenProduccionDTO ponerAProducir(Long idOrdenProduccion) throws RemoteException {
		return OrdenProduccionController.getInstance().enviarAProducir(idOrdenProduccion);
	}

	@Override
	public OrdenProduccionDTO finProduccion(Long idOrdenProduccion) throws RemoteException {
		return OrdenProduccionController.getInstance().finProduccion(idOrdenProduccion);
	}

	@Override
	public List<LoteVariedadPrendaDTO> getLotes(Long idOrdenProduccion) throws RemoteException {
		return OrdenProduccionController.getInstance().getLotes(idOrdenProduccion);
	}

	
}
