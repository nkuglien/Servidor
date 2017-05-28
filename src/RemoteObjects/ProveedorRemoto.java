package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.ProveedorDTO;
import RemoteObject.TDAProveedor;
import controllers.ProveedorController;
import dao.ClienteDAO;
import dao.ProveedorDAO;
import model.Proveedor;

public class ProveedorRemoto extends UnicastRemoteObject implements TDAProveedor {

	public ProveedorRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verificarProveedor(int parseInt) throws RemoteException {
		return ProveedorController.GetInstancia().verificarProveedor(parseInt);
	}

	@Override
	public void altaProveedor(int parseInt, String text) throws RemoteException {
		 ProveedorController.GetInstancia().altaProveedor(parseInt, text);

	}

	@Override
	public void bajaProveedor(int parseInt) throws RemoteException {
		 ProveedorController.GetInstancia().bajaProveedor(parseInt);

	}

	@Override
	public ProveedorDTO solicitarProveedorView(int parseInt) throws RemoteException {
		return ProveedorController.GetInstancia().solicitarProveedorView(parseInt);
	}

	@Override
	public void modificarProveedor(ProveedorDTO pv, int parseInt) throws RemoteException {
		 ProveedorController.GetInstancia().modificarProveedor(pv, parseInt);

	}

	@Override
	public List<ProveedorDTO> getAllProveedores() throws RemoteException {
		return ProveedorController.GetInstancia().getAllProveedores();
	}

}
