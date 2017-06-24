package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.InsumoDTO;
import RemoteObject.TDAInsumo;
import controllers.InsumoController;

public class InsumoRemoto extends UnicastRemoteObject implements TDAInsumo {

	private static final long serialVersionUID = -7875362815975562019L;

	public InsumoRemoto() throws RemoteException {
		super();
	}

	@Override
	public InsumoDTO altaInsumo(InsumoDTO insumo) throws RemoteException {
		return InsumoController.getInstance().altaInsumo(insumo);

	}

	@Override
	public InsumoDTO bajaInsumo(Long codigo) throws RemoteException {
		return InsumoController.getInstance().bajaInsumo(codigo);

	}

	@Override
	public InsumoDTO solicitarInsumoView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsumoDTO modificarInsumo(InsumoDTO insumo) throws RemoteException {
		return InsumoController.getInstance().modificarInsumo(insumo);
	}

	@Override
	public InsumoDTO buscarInsumo(Long codigo) throws RemoteException {
		return InsumoController.getInstance().buscarInsumo(codigo);
	}

	@Override
	public boolean verificarInsumo(int parseInt) {
		return InsumoController.getInstance().verificarInsumo(parseInt);

	}

	@Override
	public List<InsumoDTO> getAllInsumos() throws RemoteException {
		return InsumoController.getInstance().getAllInsumos();
	}

}
