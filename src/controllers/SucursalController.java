package controllers;

import java.rmi.RemoteException;

import DTO.SucursalDTO;
import dao.SucursalDAO;
import model.Sucursal;

public class SucursalController {

	
private static SucursalController instancia;
	
	public static SucursalController GetInstancia(){
		if(instancia==null)
			instancia= new SucursalController();
		return instancia;
	}
	
	
	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return SucursalDAO.getInstance().ExisteSucursal(parseInt);
	}

	
	public void altaSucursal(SucursalDTO sucursal) throws RemoteException {
		SucursalDAO.getInstance().save(new Sucursal(sucursal));
		
	}

	
	public void bajaSucursal(int parseInt) throws RemoteException {
		SucursalDAO.getInstance().BajaSucursal(parseInt);
	}

	
	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		return SucursalDAO.getInstance().findSucursalByNumero(parseInt).toDTO();
	}

	
	public void modificarSucursal(SucursalDTO sv) throws RemoteException {
		SucursalDAO.getInstance().save(new Sucursal(sv) );
		
	}
	
	
	
}
