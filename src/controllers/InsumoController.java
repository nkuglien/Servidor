package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.InsumoDTO;
import dao.InsumoDAO;
import model.Insumo;

public class InsumoController {

	private static InsumoController instancia;

	public static InsumoController GetInstancia() {
		if (instancia == null)
			instancia = new InsumoController();
		return instancia;
	}

	public InsumoDTO altaInsumo(InsumoDTO insumo) throws RemoteException {
		InsumoDAO.getInstance().save(new Insumo(insumo));
		return insumo;

	}

	public InsumoDTO modificarInsumo(InsumoDTO dto) throws RemoteException {
		Insumo insumo = InsumoDAO.getInstance().update(new Insumo(dto));
		return insumo != null ? insumo.toDTO() : null;
	}

	public InsumoDTO buscarInsumo(Long cod) throws RemoteException {
		Insumo insumo = InsumoDAO.getInstance().findByCodigo(cod);
		return insumo != null ? insumo.toDTO() : null;
	}

	public List<InsumoDTO> getAllInsumos() {
		List<Insumo> insumos = InsumoDAO.getInstance().getAllInsumos();
		List<InsumoDTO> insumosDTO = new ArrayList<InsumoDTO>();
		for(Insumo insumo : insumos) {
			insumosDTO.add(insumo.toDTO());
		}
		return insumosDTO;
	}

}