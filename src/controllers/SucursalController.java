package controllers;

import java.rmi.RemoteException;

import DTO.SucursalDTO;

public class SucursalController {

	
private static SucursalController instancia;
	
	public static SucursalController GetInstancia(){
		if(instancia==null)
			instancia= new SucursalController();
		return instancia;
	}
	
	
	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return false;
	}

	
	public void altaSucursal(int parseInt, String text, int parseInt2, int parseInt3) throws RemoteException {
		
		
	}

	
	public void bajaSucursal(int parseInt) throws RemoteException {
			
	}

	
	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		return null;
	}

	
	public void modificarSucursal(SucursalDTO sv, int parseInt) throws RemoteException {
		
		
	}
	
	
	
}
