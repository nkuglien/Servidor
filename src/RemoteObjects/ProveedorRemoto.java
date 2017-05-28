package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.ProveedorDTO;
import RemoteObject.TDAProveedor;
import dao.ProveedorDAO;
import model.Proveedor;

public class ProveedorRemoto extends UnicastRemoteObject implements TDAProveedor {

	public ProveedorRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verificarProveedor(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void altaProveedor(int parseInt, String text) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void bajaProveedor(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ProveedorDTO solicitarProveedorView(int parseInt) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarProveedor(ProveedorDTO pv, int parseInt) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProveedorDTO> getAllProveedores() throws RemoteException {
		List<ProveedorDTO> proveedoresDTO = new ArrayList<ProveedorDTO>();
		List<Proveedor> proveedores = ProveedorDAO.getInstance().getAllProveedores();
		
		for(Proveedor proveedor : proveedores){
			proveedoresDTO.add(proveedor.toDTO());			
		}
		
		return proveedoresDTO;
	}

}
