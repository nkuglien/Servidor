package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DTO.PrendaDTO;
import RemoteObject.TDAInsumo;
import RemoteObject.TDAPrenda;

public class PrendaRemoto extends UnicastRemoteObject implements TDAPrenda {

	public PrendaRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verificarPrenda(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void altaPrenda(int parseInt, String text) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bajaprenda(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrendaDTO solicitarPrendaView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarPrenda(PrendaDTO pv, int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
