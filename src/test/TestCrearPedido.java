package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.EstadoPedidoCliente;
import dao.ClienteDAO;
import dao.PrendaDAO;
import model.Cliente;
import model.ItemPedidoCliente;
import model.PedidoCliente;
import model.VariedadPrenda;

public class TestCrearPedido {
	
	public static void main(String[] args) {
		PedidoCliente pedido = new PedidoCliente();

		pedido.setFechaGeneracion(new Date());
		pedido.setFechaDespacho(new Date());
		pedido.setFechaProbableDespacho(new Date());
		
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		pedido.setCliente(cliente);
		
		List<ItemPedidoCliente> items = new ArrayList<>();
		
		VariedadPrenda variedad = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(29));
		ItemPedidoCliente item1 = new ItemPedidoCliente();
		item1.setCantidad(1);
		item1.setItem(variedad);
		item1.setPrecioItem(variedad.getPrecioVentaActual());
		
		pedido.setSubtotal(variedad.getPrecioVentaActual());
		pedido.setImpuestos(Float.valueOf((float) (variedad.getPrecioVentaActual()*0.21)));
		pedido.setTotal(Float.valueOf(100));
		pedido.setEstado(EstadoPedidoCliente.CREADO);
		pedido.setNota("Pedido nuevo de cliente desde test");		
		
		items.add(item1);
		pedido.setItems(items);
		
		pedido = pedido.save();
		
		
		pedido.setEstado(EstadoPedidoCliente.VALIDADO);
		pedido = pedido.save();
		
		
		pedido.setEstado(EstadoPedidoCliente.ACEPTADO);
		
		pedido.intentarArmar();
		pedido = pedido.save();
		
		System.out.println("fin tests pedidos");
	}

}
