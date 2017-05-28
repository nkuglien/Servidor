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

	// ========================= MANEJO DE PEDIDOS =========================

	public PedidoCliente getPedidoCliente(Long nroPedido) {
		return PedidoClienteDAO.getInstance().getByNroPedido(nroPedido);
	}

	// el cliente crea un pedido
	public PedidoCliente crearPedido(PedidoClienteDTO dto) {
		PedidoCliente pedido = new PedidoCliente(dto);
		pedido.save();
		return pedido;
	}

	// la sucursal lo valida: lo aprueba, o lo rechaza (alcarando por que)
	public PedidoCliente aprobarPedidoSucursal(Long nroPedido) {
		PedidoCliente pedido = getPedidoCliente(nroPedido);

		String nota = "";
		EstadoPedidoCliente estado = EstadoPedidoCliente.VALIDADO;
		List<VariedadPrenda> prendasSinStock = new ArrayList<VariedadPrenda>();
		for (ItemPedidoCliente item : pedido.getItems()) {
			VariedadPrenda prenda = item.getItem();
			if (!prenda.hayStock()) {
				if (!prenda.getEnProduccion()) {
					estado = EstadoPedidoCliente.RECHAZADO;
					nota = nota + "La prenda " + prenda.toString() + " esta discontinuada.\n";
				} else {
					prendasSinStock.add(prenda);
				}
			}
		}

		generarOrdenesDeProduccin(prendasSinStock);
		pedido.setNota(nota);
		pedido.setEstado(estado);

		pedido.save();
		return pedido;
	}

	private void generarOrdenesDeProduccin(List<VariedadPrenda> prendasSinStock) {
		// verifica la lista de prendas enviadas para generar el/las ordenes
		// de produccion competas o parcales

	}

	// el cliente acepta o cancela el pedido validado por la sucursal
	public PedidoCliente aceptarPedidoCliente(Long nroPedido, boolean isAceptado) {
		PedidoCliente pedido = getPedidoCliente(nroPedido);

		EstadoPedidoCliente estado = isAceptado ? EstadoPedidoCliente.ACEPTADO : EstadoPedidoCliente.CANCELADO;
		pedido.setEstado(estado);
		pedido.save();
		return pedido;
	}

}
