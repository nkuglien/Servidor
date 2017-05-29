package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.PrendaDTO;
import RemoteObject.TDAPrenda;
import controllers.PrendaController;
import dao.PrendaDAO;
import model.Prenda;

public class PrendaRemoto extends UnicastRemoteObject implements TDAPrenda {

	private static final long serialVersionUID = -6532975774132254572L;

	public PrendaRemoto() throws RemoteException {
		super();
	}

	@Override
	public boolean verificarPrenda(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public void altaPrenda(PrendaDTO prenda) throws RemoteException {
		Prenda p = new Prenda(prenda);
		p.save();
	}

	@Override
	public void bajaprenda(PrendaDTO prenda) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public PrendaDTO solicitarPrendaView(Long codigo) throws RemoteException {
		return PrendaController.getInstance().buscarPrenda(codigo);
	}

	@Override
	public void modificarPrenda(PrendaDTO prenda) throws RemoteException {
		Prenda p = new Prenda(prenda);
		p.save();
	}

	@Override
	public List<PrendaDTO> getAllPrendas() throws RemoteException {
		return PrendaController.getInstance().getAllPrendas();
	}

}
