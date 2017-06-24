package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.InsumoDTO;
import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import RemoteObject.TDAProveedor;
import controllers.ProveedorController;

public class ProveedorRemoto extends UnicastRemoteObject implements TDAProveedor {

	private static final long serialVersionUID = 1902762847109205777L;

	public ProveedorRemoto() throws RemoteException {
		super();
	}

	@Override
	public boolean verificarProveedor(int parseInt) throws RemoteException {
		return ProveedorController.getInstance().verificarProveedor(parseInt);
	}

	@Override
	public void altaProveedor(ProveedorDTO proveedor) throws RemoteException {
		ProveedorController.getInstance().altaProveedor(proveedor);
	}

	@Override
	public void bajaProveedor(int parseInt) throws RemoteException {
		ProveedorController.getInstance().bajaProveedor(parseInt);

	}

	@Override
	public ProveedorDTO solicitarProveedorView(int parseInt) throws RemoteException {
		return ProveedorController.getInstance().solicitarProveedorView(parseInt);
	}

	@Override
	public void modificarProveedor(ProveedorDTO pv) throws RemoteException {
		ProveedorController.getInstance().modificarProveedor(pv);

	}

	@Override
	public List<ProveedorDTO> getAllProveedores() throws RemoteException {
		return ProveedorController.getInstance().getAllProveedores();
	}

	@Override
	public InsumoProveedorDTO asociarInsumo(ProveedorDTO proveedor, InsumoDTO insumo, Float precio)
			throws RemoteException {
		return ProveedorController.getInstance().asociarInsumo(proveedor, insumo, precio);
	}

}
