package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import DTO.LoteVariedadPrendaDTO;
import DTO.OrdenProduccionDTO;
import dao.ClienteDAO;
import dao.LoteDAO;
import dao.OrdenProduccionDAO;
import dao.PrendaDAO;
import model.Cliente;
import model.LoteVariedadPrenda;
import model.OrdenProduccion;
import model.PedidoCliente;
import model.Prenda;
import model.VariedadPrenda;

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
	

	public OrdenProduccion generarOrdenCompleta(Prenda prenda, PedidoCliente pedido) {
		PrendaDAO dao = PrendaDAO.getInstance();
		List<VariedadPrenda> variedades = dao.getAllVariedadesPrenda(prenda);
		return generarOrden(variedades, pedido,"COMPLETA");
	}

	public OrdenProduccion generarOrdenParcial(List<VariedadPrenda> variedades, PedidoCliente pedido) {
		// Se fija si ya no hay ordenes de produccion que puedan satisfacer el pedido
		return generarOrden(variedades, pedido,"PARCIAL");
		
	}

	private OrdenProduccion generarOrden(List<VariedadPrenda> variedades, PedidoCliente pedido, String tipo){
		OrdenProduccionDAO dao = OrdenProduccionDAO.getInstance();
		OrdenProduccion orden = new OrdenProduccion(variedades, pedido,tipo);

		// Se guarda en la base de datos en estado de espera
		orden = orden.save();
		orden.intentarCompletar();
		return orden;
	}

	public List<LoteVariedadPrendaDTO> getLotes(Long idOrdenProduccion) {
		List<LoteVariedadPrenda> lotes= LoteDAO.getInstance().getLotesFromOrden(idOrdenProduccion);
		 List<LoteVariedadPrendaDTO> lotesDTO = new ArrayList<LoteVariedadPrendaDTO>();
		for(LoteVariedadPrenda lo : lotes){
			lotesDTO.add(lo.toDTO());
		}
		return lotesDTO;
	}
	

}
