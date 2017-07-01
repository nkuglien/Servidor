package controllers;

import java.util.ArrayList;
import java.util.List;

import DTO.EstadoPedidoCliente;
import DTO.PedidoClienteDTO;
import dao.PedidoClienteDAO;
import model.ItemPedidoCliente;
import model.PedidoCliente;
import model.VariedadPrenda;

public class PedidoController {
	
	private static PedidoController instance;

	public static PedidoController getInstance() {
		if (instance == null) {
			instance = new PedidoController();
		}
		return instance;
	}

	// ========================= MANEJO DE PEDIDOS =========================

	public PedidoCliente getPedidoCliente(Long nroPedido) {
		return PedidoClienteDAO.getInstance().getByNroPedido(nroPedido);
	}

	// el cliente crea un pedido
	public PedidoCliente crearPedido(PedidoClienteDTO dto) {
		PedidoCliente pedido = new PedidoCliente(dto);
		return pedido.save();
	}

	// la sucursal lo valida: lo aprueba, o lo rechaza (alcarando por que)
	public PedidoCliente aprobarPedidoSucursal(Long nroPedido) {
		PedidoCliente pedido = getPedidoCliente(nroPedido);
//
//		String nota = "";
//		EstadoPedidoCliente estado = EstadoPedidoCliente.VALIDADO;
//		List<VariedadPrenda> prendasSinStock = new ArrayList<VariedadPrenda>();
//		for (ItemPedidoCliente item : pedido.getItems()) {
//			VariedadPrenda prenda = item.getItem();
//			if (!prenda.getStock()) {
//				if (!prenda.getEnProduccion()) {
//					estado = EstadoPedidoCliente.RECHAZADO;
//					nota = nota + "La prenda " + prenda.toString() + " esta discontinuada.\n";
//				} else {
//					prendasSinStock.add(prenda);
//				}
//			}
//		}
//
//		generarOrdenesDeProduccin(prendasSinStock);
//		pedido.setNota(nota);
//		pedido.setEstado(estado);
//
//		pedido.save();
		return pedido;
	}

	private void generarOrdenesDeProduccin(List<VariedadPrenda> prendasSinStock) {
		// verifica la lista de prendas enviadas para generar el/las ordenes
		// de produccion competas o parcales

	}

	// el cliente acepta o cancela el pedido validado por la sucursal
	public PedidoCliente aceptarPedidoCliente(Long nroPedido, boolean isAceptado) {
		PedidoCliente pedido = getPedidoCliente(nroPedido);
		if(isAceptado) {
			pedido.setEstado(EstadoPedidoCliente.ACEPTADO);
			pedido.intentarArmar();
		} else {
			pedido.setEstado(EstadoPedidoCliente.CANCELADO);
		}
		pedido.save();
		return pedido;
	}

	public List<PedidoClienteDTO> getAllPedidos() {
		List<PedidoCliente> pedidos = PedidoClienteDAO.getInstance().getAllPedidos();
		List<PedidoClienteDTO> pedidosDTO = new ArrayList<PedidoClienteDTO>();
		for(PedidoCliente pedido : pedidos) {
			pedidosDTO.add(pedido.toDTO());
		}
		return pedidosDTO;
	}

	public List<PedidoClienteDTO> getPedidosByCliente(String cuit) {
		List<PedidoCliente> pedidos = PedidoClienteDAO.getInstance().getPedidosByCliente(cuit);
		List<PedidoClienteDTO> pedidosDTO = new ArrayList<PedidoClienteDTO>();
		for(PedidoCliente pedido : pedidos) {
			pedidosDTO.add(pedido.toDTO());
		}
		return pedidosDTO;
	}

}
