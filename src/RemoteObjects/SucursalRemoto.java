package RemoteObjects;

import java.rmi.RemoteException;

import DTO.SucursalDTO;
import RemoteObject.TDASucursal;
import controllers.SucursalController;

public class SucursalRemoto implements TDASucursal {

	@Override
	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return SucursalController.GetInstancia().verificarSucursal(parseInt);
	}

	@Override
	public void altaSucursal(int parseInt, String text, int parseInt2, int parseInt3) throws RemoteException {
		 SucursalController.GetInstancia().altaSucursal(parseInt, text, parseInt2, parseInt3);
		
	}

	@Override
	public void bajaSucursal(int parseInt) throws RemoteException {
		 SucursalController.GetInstancia().solicitarSucursalView(parseInt);	
	}

	@Override
	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		return SucursalController.GetInstancia().solicitarSucursalView(parseInt);
	}

	@Override
	public void modificarSucursal(SucursalDTO sv, int parseInt) throws RemoteException {
		 SucursalController.GetInstancia().modificarSucursal(sv, parseInt);
		
	}

}
