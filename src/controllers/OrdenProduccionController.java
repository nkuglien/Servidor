package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import DTO.OrdenProduccionDTO;
import dao.ClienteDAO;
import dao.OrdenProduccionDAO;
import model.Cliente;
import model.OrdenProduccion;

public class OrdenProduccionController {

	private static OrdenProduccionController instance;

	public static OrdenProduccionController getInstance() {
		if (instance == null) {
			instance = new OrdenProduccionController();
		}
		return instance;
	}

	public List<OrdenProduccionDTO> getAll() throws RemoteException {
		List<OrdenProduccionDTO> DTOs = new ArrayList<OrdenProduccionDTO>();
		List<OrdenProduccion> ordenes = OrdenProduccionDAO.getInstance().getAll();

		for (OrdenProduccion ord : ordenes) {
			DTOs.add(ord.toDTO());
		}

		return DTOs;
	}

	public OrdenProduccionDTO enviarAProducir(Long idOrden) throws RemoteException {
		
		OrdenProduccion ordenBD = OrdenProduccionDAO.getInstance().getByID(idOrden);
		ordenBD.ponerAproducir();
		
		return ordenBD.toDTO();

	}
	public OrdenProduccionDTO finProduccion(Long idOrden) throws RemoteException {
		
		OrdenProduccion ordenBD = OrdenProduccionDAO.getInstance().getByID(idOrden);
		ordenBD.finProduccion();
		
		return ordenBD.toDTO();

	}

	

}
