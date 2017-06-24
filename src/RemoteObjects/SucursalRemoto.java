package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DTO.SucursalDTO;
import RemoteObject.TDASucursal;
import controllers.SucursalController;

public class SucursalRemoto extends UnicastRemoteObject implements TDASucursal {

	private static final long serialVersionUID = 1139558590307604463L;

	public SucursalRemoto() throws RemoteException {
		super();
	}

	@Override
	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return SucursalController.getInstance().verificarSucursal(parseInt);
	}

	@Override
	public void altaSucursal(SucursalDTO sucursal) throws RemoteException {
		System.out.println("Sucursal recibida en el servidor");
		SucursalController.getInstance().altaSucursal(sucursal);
	}

	@Override
	public void bajaSucursal(int parseInt) throws RemoteException {
		SucursalController.getInstance().bajaSucursal(parseInt);
	}

	@Override
	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		return SucursalController.getInstance().solicitarSucursalView(parseInt);
	}

	@Override
	public void modificarSucursal(SucursalDTO sv) throws RemoteException {
		SucursalController.getInstance().modificarSucursal(sv);

	}

}
