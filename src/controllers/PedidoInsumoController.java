package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.PedidoInsumoDTO;
import dao.PedidoInsumoDAO;
import dao.ProveedorDAO;
import model.PedidoInsumo;
import model.Proveedor;

public class PedidoInsumoController {

	private static PedidoInsumoController instance;

	public static PedidoInsumoController getInstance() {
		if (instance == null) {
			instance = new PedidoInsumoController();
		}
		return instance;
	}

	public List<PedidoInsumoDTO> getAllPedidos() throws RemoteException {
		List<PedidoInsumoDTO> pedidosDTO = new ArrayList<PedidoInsumoDTO>();
		List<PedidoInsumo> pedidos = PedidoInsumoDAO.getInstance().getAllInsumos();

		for (PedidoInsumo ped : pedidos) {
			pedidosDTO.add(ped.toDTO());
		}
		return pedidosDTO;
	}

	public void completarPedido(Long id, Long idProveedor, Date fechaDespacho, float precioUnidad) {
		PedidoInsumo pedido = PedidoInsumoDAO.getInstance().getPedido(id);
		Proveedor prove = ProveedorDAO.getInstance().findProveedorById(idProveedor);
		pedido.CompletarPedidoInsumo(prove, fechaDespacho, precioUnidad);
		
	}

	public void terminarPedido(Long id, Date fechaDespachoReal) {
		PedidoInsumo pedido = PedidoInsumoDAO.getInstance().getPedido(id);
		pedido.TerminarPedidoInsumo(fechaDespachoReal);
		
	}



}
