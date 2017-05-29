package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DTO.SucursalDTO;
import RemoteObject.TDASucursal;
import controllers.SucursalController;

public class SucursalRemoto extends UnicastRemoteObject implements TDASucursal {

	public SucursalRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return SucursalController.GetInstancia().verificarSucursal(parseInt);
	}

	@Override
	public void altaSucursal(SucursalDTO sucursal) throws RemoteException {
		System.out.println("Sucursal recibida en el servidor");
		 SucursalController.GetInstancia().altaSucursal(sucursal);
		
	}

	@Override
	public void bajaSucursal(int parseInt) throws RemoteException {
		 SucursalController.GetInstancia().bajaSucursal(parseInt);	
	}

	@Override
	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		return SucursalController.GetInstancia().solicitarSucursalView(parseInt);
	}

	@Override
	public void modificarSucursal(SucursalDTO sv) throws RemoteException {
		 SucursalController.GetInstancia().modificarSucursal(sv);
		
	}

}
