package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DTO.InsumoDTO;
import RemoteObject.InsumoRemote;
import dao.InsumoDAO;
import model.Insumo;

public class InsumoRemoto extends UnicastRemoteObject implements InsumoRemote {

	public InsumoRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public InsumoDTO altaInsumo(InsumoDTO insumo)
			throws RemoteException {
		InsumoDAO.getInstance().save(new Insumo(insumo));
		return insumo;

	}

	@Override
	public void bajaInsumo(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public InsumoDTO solicitarInsumoView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarInsumo(InsumoDTO iv, int parseInt) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public InsumoDTO buscarInsumo(Long codigo) throws RemoteException {
		Insumo insumo = InsumoDAO.getInstance().findByCodigo(codigo);
		return insumo != null? insumo.toDTO() : null;
	}

}
