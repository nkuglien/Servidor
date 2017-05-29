package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.InsumoDTO;
import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import RemoteObject.TDAProveedor;
import controllers.ProveedorController;

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
	public void altaProveedor(ProveedorDTO proveedor) throws RemoteException {
		ProveedorController.GetInstancia().altaProveedor(proveedor);
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
	public void modificarProveedor(ProveedorDTO pv) throws RemoteException {
		 ProveedorController.GetInstancia().modificarProveedor(pv);

	}

	@Override
	public List<ProveedorDTO> getAllProveedores() throws RemoteException {
		return ProveedorController.GetInstancia().getAllProveedores();
	}

	@Override
	public InsumoProveedorDTO asociarInsumo(ProveedorDTO proveedor, InsumoDTO insumo, Float precio)
			throws RemoteException {
		return ProveedorController.GetInstancia().asociarInsumo(proveedor, insumo, precio);
	}

}
