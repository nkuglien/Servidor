package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.EstadosPedidoCliente;
import DTO.PedidoClienteDTO;
import dao.PedidoClienteDAO;
import model.ItemPedidoCliente;
import model.PedidoCliente;
import model.VariedadPrenda;

public class Controller {

	// ========================= MANEJO DE PEDIDOS =========================

	public PedidoCliente getPedidoCliente(Long nroPedido) {
		return PedidoClienteDAO.get(nroPedido);
	}

	// el cliente crea un pedido
	public PedidoCliente crearPedido(PedidoClienteDTO dto) {
		PedidoCliente pedido = new PedidoCliente(dto);
		PedidoClienteDAO.save(pedido);
		return pedido;
	}

	// la sucursal lo valida: lo aprueba, o lo rechaza (alcarando por que)
	public PedidoCliente aprobarPedidoSucursal(Long nroPedido) {
		PedidoCliente pedido = getPedidoCliente(nroPedido);

		String nota = "";
		EstadosPedidoCliente estado = EstadosPedidoCliente.VALIDADO;
		List<VariedadPrenda> prendasSinStock = new ArrayList<VariedadPrenda>();
		for (ItemPedidoCliente item : pedido.getItems()) {
			VariedadPrenda prenda = item.getItem();
			if (!prenda.hayStock()) {
				if (!prenda.getEnProduccion()) {
					estado = EstadosPedidoCliente.RECHAZADO;
					nota = nota + "La prenda " + prenda.toString() + " esta discontinuada.\n";
				} else {
					prendasSinStock.add(prenda);
				}
			}
		}

		generarOrdenesDeProduccin(prendasSinStock);
		pedido.setNota(nota);
		pedido.setEstado(estado);

		PedidoClienteDAO.update(pedido);
		return pedido;
	}

	private void generarOrdenesDeProduccin(List<VariedadPrenda> prendasSinStock) {
		// verifica la lista de prendas enviadas para generar el/las ordenes
		// de produccion competas o parcales

	}

	// el cliente acepta o cancela el pedido validado por la sucursal
	public PedidoCliente aceptarPedidoCliente(Long nroPedido, boolean isAceptado) {
		PedidoCliente pedido = getPedidoCliente(nroPedido);

		EstadosPedidoCliente estado = isAceptado ? EstadosPedidoCliente.ACEPTADO : EstadosPedidoCliente.CANCELADO;
		pedido.setEstado(estado);

		PedidoClienteDAO.update(pedido);
		return pedido;
	}

}
