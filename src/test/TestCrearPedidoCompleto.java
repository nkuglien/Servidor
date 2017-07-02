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

public class TestCrearPedidoCompleto {
	
	public static void main(String[] args) {
		
//		1 Remeras Rojas XL 
//		1 Jean Verde M 
//
//		Descontar stock, generar pedido, no generar orden de produccion 
//		ni orden de compra de insumos

		PedidoCliente pedido = new PedidoCliente();

		pedido.setFechaGeneracion(new Date());
		pedido.setFechaDespacho(new Date());
		pedido.setFechaProbableDespacho(new Date());
		
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20347944376");
		pedido.setCliente(cliente);
		
		pedido.setSubtotal(Float.valueOf(1000));
		pedido.setImpuestos(Float.valueOf(100));
		pedido.setTotal(Float.valueOf(100));
		pedido.setEstado(EstadoPedidoCliente.CREADO);
		pedido.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items = new ArrayList<>();
	
		VariedadPrenda variedad = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(29));
		ItemPedidoCliente item1 = new ItemPedidoCliente();
		item1.setCantidad(1);
		item1.setItem(variedad);
		item1.setPrecioItem(variedad.getPrecioVentaActual());
		VariedadPrenda variedad2 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(57));
		ItemPedidoCliente item2 = new ItemPedidoCliente();
		item2.setCantidad(1);
		item2.setItem(variedad2);
		item2.setPrecioItem(variedad2.getPrecioVentaActual());
		
		items.add(item1);
		items.add(item2);
		pedido.setItems(items);
		
//		2 Jean XL Azul 
//		1 Remera L Azul 
		
//		Generar orden de produccion parcial Jean XL Azul
		
		PedidoCliente pedido2 = new PedidoCliente();

		pedido2.setFechaGeneracion(new Date());
		pedido2.setFechaDespacho(new Date());
		pedido2.setFechaProbableDespacho(new Date());
		
		Cliente cliente2 = ClienteDAO.getInstance().findClienteByCuit("20340544376");
		pedido2.setCliente(cliente2);
		
		pedido2.setSubtotal(Float.valueOf(1000));
		pedido2.setImpuestos(Float.valueOf(100));
		pedido2.setTotal(Float.valueOf(100));
		pedido2.setEstado(EstadoPedidoCliente.CREADO);
		pedido2.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items2 = new ArrayList<>();
	
		VariedadPrenda variedad3 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(63));
		ItemPedidoCliente item3 = new ItemPedidoCliente();
		item3.setCantidad(2);
		item3.setItem(variedad3);
		item3.setPrecioItem(variedad3.getPrecioVentaActual());
		VariedadPrenda variedad4 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(39));
		ItemPedidoCliente item4 = new ItemPedidoCliente();
		item4.setCantidad(1);
		item4.setItem(variedad4);
		item4.setPrecioItem(variedad4.getPrecioVentaActual());
		
		items2.add(item3);
		items2.add(item4);
		pedido2.setItems(items2);
		
		pedido2.save();
		

//		3 Jean XL Azul 
//
//		Generar orden de produccion completa Jean XL Azul
		
		PedidoCliente pedido3 = new PedidoCliente();

		pedido3.setFechaGeneracion(new Date());
		pedido3.setFechaDespacho(new Date());
		pedido3.setFechaProbableDespacho(new Date());
		
		Cliente cliente3 = ClienteDAO.getInstance().findClienteByCuit("20347449676");
		pedido3.setCliente(cliente3);
		
		pedido3.setSubtotal(Float.valueOf(1000));
		pedido3.setImpuestos(Float.valueOf(100));
		pedido3.setTotal(Float.valueOf(100));
		pedido3.setEstado(EstadoPedidoCliente.CREADO);
		pedido3.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items3 = new ArrayList<>();
	
		VariedadPrenda variedad5 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(63));
		ItemPedidoCliente item5 = new ItemPedidoCliente();
		item3.setCantidad(3);
		item3.setItem(variedad5);
		item3.setPrecioItem(variedad5.getPrecioVentaActual());
		
		items3.add(item5);
		pedido3.setItems(items3);
		
		pedido3.save();
		
//		4 Remera L Roja (Colorante x6, Boton x4, Tela x8)
//		2 Campera L Roja (Tela x18, Boton x20, Colorante x10)
//
//		Generar orden de produccion parcial Remera L Roja y Campera L Roja y 
//		generar orden de compra de insumo Tela, Boton y Colorante
		
		PedidoCliente pedido4 = new PedidoCliente();

		pedido4.setFechaGeneracion(new Date());
		pedido4.setFechaDespacho(new Date());
		pedido4.setFechaProbableDespacho(new Date());
		
		Cliente cliente4 = ClienteDAO.getInstance().findClienteByCuit("20346844376");
		pedido4.setCliente(cliente4);
		
		pedido4.setSubtotal(Float.valueOf(1000));
		pedido4.setImpuestos(Float.valueOf(100));
		pedido4.setTotal(Float.valueOf(100));
		pedido4.setEstado(EstadoPedidoCliente.CREADO);
		pedido4.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items4 = new ArrayList<>();
	
		VariedadPrenda variedad6 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(34));
		ItemPedidoCliente item6 = new ItemPedidoCliente();
		item6.setCantidad(4);
		item6.setItem(variedad6);
		item6.setPrecioItem(variedad6.getPrecioVentaActual());
		VariedadPrenda variedad7 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(49));
		ItemPedidoCliente item7 = new ItemPedidoCliente();
		item7.setCantidad(2);
		item7.setItem(variedad7);
		item7.setPrecioItem(variedad7.getPrecioVentaActual());
		
		items4.add(item6);
		items4.add(item7);
		pedido4.setItems(items4);
		
		pedido4.save();
		
//		4 Jean XL Azul (Tela x15, Boton x15, Colorante x3)
//
//		Generar orden de produccion completa Jean XL Azul y orden de compra
//		insumo Boton y Tela
		
		PedidoCliente pedido5 = new PedidoCliente();

		pedido5.setFechaGeneracion(new Date());
		pedido5.setFechaDespacho(new Date());
		pedido5.setFechaProbableDespacho(new Date());
		
		Cliente cliente5 = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		pedido5.setCliente(cliente5);
		
		pedido5.setSubtotal(Float.valueOf(1000));
		pedido5.setImpuestos(Float.valueOf(100));
		pedido5.setTotal(Float.valueOf(100));
		pedido5.setEstado(EstadoPedidoCliente.CREADO);
		pedido5.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items5 = new ArrayList<>();
	
		VariedadPrenda variedad8 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(63));
		ItemPedidoCliente item8 = new ItemPedidoCliente();
		item8.setCantidad(4);
		item8.setItem(variedad8);
		item8.setPrecioItem(variedad8.getPrecioVentaActual());
		
		items5.add(item8);
		pedido5.setItems(items5);
		
		pedido5.save();

//		3 Jean XL Azul 
//		3 Remera L Roja 
//
//		Generar orden de produccion completa Jean XL Azul, Generar orden
//		de produccion parcial Remera L Roja y orden de compra insumos Tela, 
//		Boton y Colorante
		
		PedidoCliente pedido6 = new PedidoCliente();

		pedido6.setFechaGeneracion(new Date());
		pedido6.setFechaDespacho(new Date());
		pedido6.setFechaProbableDespacho(new Date());
		
		Cliente cliente6 = ClienteDAO.getInstance().findClienteByCuit("20346844376");
		pedido6.setCliente(cliente6);
		
		pedido6.setSubtotal(Float.valueOf(1000));
		pedido6.setImpuestos(Float.valueOf(100));
		pedido6.setTotal(Float.valueOf(100));
		pedido6.setEstado(EstadoPedidoCliente.CREADO);
		pedido6.setNota("Pedido nuevo de cliente desde test");
		
		List<ItemPedidoCliente> items6 = new ArrayList<>();
	
		VariedadPrenda variedad9 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(63));
		ItemPedidoCliente item9 = new ItemPedidoCliente();
		item9.setCantidad(3);
		item9.setItem(variedad9);
		item9.setPrecioItem(variedad9.getPrecioVentaActual());
		VariedadPrenda variedad10 = PrendaDAO.getInstance().getVariedadPrendaById(Long.valueOf(34));
		ItemPedidoCliente item10 = new ItemPedidoCliente();
		item10.setCantidad(3);
		item10.setItem(variedad10);
		item10.setPrecioItem(variedad10.getPrecioVentaActual());
		
		items6.add(item9);
		items6.add(item10);
		pedido6.setItems(items6);
		
		pedido6.save();
		
		
		
		System.out.println("fin tests pedidos");
	}

}
