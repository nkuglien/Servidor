package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.AreaProduccionDTO;
import DTO.PrendaDTO;
import DTO.VariedadPrendaDTO;
import RemoteObject.TDAPrenda;
import controllers.PrendaController;
import dao.PrendaDAO;
import model.Prenda;
import model.VariedadPrenda;

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
		Prenda p = new Prenda(prenda);
		p.baja();
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

	@Override
	public void altaVariedadPrenda(VariedadPrendaDTO varPrenda) throws RemoteException {
		VariedadPrenda vp = new VariedadPrenda(varPrenda);
		vp.save();
	}

	@Override
	public List<AreaProduccionDTO> getAllAreasProduccion() throws RemoteException {
		return PrendaController.getInstance().getAllAreasProduccion();
	}

}
