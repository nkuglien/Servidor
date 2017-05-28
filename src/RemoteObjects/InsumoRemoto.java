package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DTO.InsumoDTO;
import RemoteObject.TDAInsumo;
import dao.InsumoDAO;
import model.Insumo;

public class InsumoRemoto extends UnicastRemoteObject implements TDAInsumo {

	public InsumoRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public InsumoDTO altaInsumo(InsumoDTO insumo) throws RemoteException {
		InsumoDAO.getInstance().save(new Insumo(insumo));
		return insumo;

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
	public void modificarInsumo(InsumoDTO iv, int parseInt) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public InsumoDTO buscarInsumo(Long codigo) throws RemoteException {
		Insumo insumo = InsumoDAO.getInstance().findByCodigo(codigo);
		return insumo != null ? insumo.toDTO() : null;
	}

	@Override
	public boolean verificarInsumo(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void altaInsumo(int parseInt, String text, String text2, int parseInt2, int parseInt3)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bajaInsumo(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
