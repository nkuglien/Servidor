package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.AreaProduccionDTO;
import DTO.PrendaDTO;
import DTO.VariedadPrendaDTO;
import dao.AreaProduccionDAO;
import dao.PrendaDAO;
import model.AreaProduccion;
import model.Prenda;
import model.VariedadPrenda;

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

	public List<AreaProduccionDTO> getAllAreasProduccion() {
		List<AreaProduccionDTO> areasDTO = new ArrayList<AreaProduccionDTO>();
		List<AreaProduccion> areas = AreaProduccionDAO.getInstance().getAllAreasProduccion();

		for (AreaProduccion area : areas) {
			areasDTO.add(area.toDTO());
		}

		return areasDTO;
	}

	public VariedadPrendaDTO buscarVariedad(Long id) {
		VariedadPrenda variedad = PrendaDAO.getInstance().getVariedadPrendaById(id);
		return variedad != null? variedad.toDTO() : null;
	}

	public Object getPrendasVigentes() {
		List<PrendaDTO> prendasDTO = new ArrayList<PrendaDTO>();
		List<Prenda> prendas = PrendaDAO.getInstance().getPrendasVigentes();

		for (Prenda prenda : prendas) {
			prendasDTO.add(prenda.toDTO());
		}

		return prendasDTO;
	}

}
