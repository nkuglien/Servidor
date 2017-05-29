package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DTO.InsumoDTO;
import RemoteObject.TDAInsumo;
import controllers.InsumoController;
import dao.InsumoDAO;
import model.Insumo;

public class InsumoRemoto extends UnicastRemoteObject implements TDAInsumo {

	public InsumoRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public InsumoDTO altaInsumo(InsumoDTO insumo) throws RemoteException {
		return InsumoController.GetInstancia().altaInsumo(insumo);

	}

	@Override
	public InsumoDTO bajaInsumo(Long codigo) throws RemoteException {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public InsumoDTO solicitarInsumoView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsumoDTO modificarInsumo(InsumoDTO insumo) throws RemoteException {
		return InsumoController.GetInstancia().modificarInsumo(insumo);
	}

	@Override
	public InsumoDTO buscarInsumo(Long codigo) throws RemoteException {
		return InsumoController.GetInstancia().buscarInsumo(codigo);
	}

	@Override
	public boolean verificarInsumo(int parseInt) {
		return InsumoController.GetInstancia().verificarInsumo(parseInt);
	}


}
