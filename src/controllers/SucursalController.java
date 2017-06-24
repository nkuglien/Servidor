package controllers;

import java.rmi.RemoteException;

import DTO.SucursalDTO;
import dao.SucursalDAO;
import model.Sucursal;

public class SucursalController {

	private static SucursalController instance;

	public static SucursalController getInstance() {
		if (instance == null) {
			instance = new SucursalController();
		}
		return instance;
	}

	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return SucursalDAO.getInstance().ExisteSucursal(parseInt);
	}

	public void altaSucursal(SucursalDTO sucursal) throws RemoteException {
		SucursalDAO.getInstance().save(new Sucursal(sucursal));

	}

	public void bajaSucursal(int numero) throws RemoteException {
		Sucursal sucursal = SucursalDAO.getInstance().findSucursalByNumero(numero);
		sucursal.baja();
	}

	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		Sucursal suc = SucursalDAO.getInstance().findSucursalByNumero(parseInt);
		return suc != null ? suc.toDTO() : null;
	}

	public void modificarSucursal(SucursalDTO sv) throws RemoteException {
		SucursalDAO.getInstance().save(new Sucursal(sv));

	}

}
