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
		
		pedido.setSubtotal(Float.valueOf(1000));
		pedido.setImpuestos(Float.valueOf(100));
		pedido.setTotal(Float.valueOf(100));
		pedido.setEstado(EstadoPedidoCliente.CREADO);
		pedido.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items = new ArrayList<>();
	
		VariedadPrenda variedad = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(9));
		ItemPedidoCliente item1 = new ItemPedidoCliente();
		item1.setCantidad(5);
		item1.setItem(variedad);
		item1.setPrecioItem(variedad.getPrecioVentaActual());
		
		items.add(item1);
		pedido.setItems(items);
		
		pedido.save();
		System.out.println("fin tests pedidos");
	}

}
