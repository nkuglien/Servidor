package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.PrendaDTO;
import dao.PrendaDAO;
import model.Prenda;

public class PrendaController {
	private static PrendaController instance;

	public static PrendaController getInstance() {
		if (instance == null) {
			instance = new PrendaController();
		}
		return instance;
	}

	public List<PrendaDTO> getAllPrendas() throws RemoteException {
		List<PrendaDTO> prendasDTO = new ArrayList<PrendaDTO>();
		List<Prenda> prendas = PrendaDAO.getInstance().getAllPrendas();

		for (Prenda prenda : prendas) {
			prendasDTO.add(prenda.toDTO());
		}

		return prendasDTO;
	}
	
	public PrendaDTO buscarPrenda(Long codigo) {
		Prenda prenda = PrendaDAO.getInstance().getPrendaByCodigo(codigo);
		return prenda != null? prenda.toDTO() : null;
	}

}
