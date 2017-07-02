package test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.ClienteDTO;
import DTO.EstadoPedidoCliente;
import DTO.ItemPedidoClienteDTO;
import DTO.PedidoClienteDTO;
import DTO.VariedadPrendaDTO;
import controllers.ClienteController;
import controllers.PedidoController;
import controllers.PrendaController;

public class TestCrearPedidoCompleto {

	public static void main(String[] args) throws RemoteException {

//		crearPedidoConStockDeVariedades();

//		crearPedidoGenerandoOPP();
//
//		crearPedidoGenerandoOPC(); 
//
//		crearPedidoGenerandoOPPyOrdenInsumo();
//
//		crearPedidoGenerandoOPCyOrdenInsumo();
//
//		crearPedidoGenerandoOPPyOPCyOrdenInsumo();

		System.out.println("fin tests pedidos");
	}

	/**
	 * 1 Remeras Rojas XL 1 Jean Verde M
	 *
	 * Descontar stock, generar pedido, no generar orden de produccion ni orden de
	 * compra de insumos
	 *
	 * @throws RemoteException
	 */
	private static void crearPedidoConStockDeVariedades() throws RemoteException {
		long[] idVariedades = { 29, 57 };
		int[] cantidades = { 1, 1 };
		PedidoClienteDTO pedido = crearPedido("20362134596", "test 1", idVariedades, cantidades);

		pedido = PedidoController.getInstance().crearPedido(pedido).toDTO();

		PedidoController.getInstance().cambiarEstadoPedidoCliente(pedido.getNroPedido(), EstadoPedidoCliente.ACEPTADO);
	}

	/**
	 * 2 Jean XL Azul 1 Remera L Azul
	 *
	 * Generar orden de produccion parcial Jean XL Azul
	 *
	 * @throws RemoteException
	 */
	private static void crearPedidoGenerandoOPP() throws RemoteException {

		long[] idVariedades = { 63, 39 };
		int[] cantidades = { 2, 1 };
		PedidoClienteDTO pedido = crearPedido("20362134596", "test 2", idVariedades, cantidades);

		pedido = PedidoController.getInstance().crearPedido(pedido).toDTO();

		PedidoController.getInstance().cambiarEstadoPedidoCliente(pedido.getNroPedido(), EstadoPedidoCliente.ACEPTADO);
	}

	/**
	 * 3 Jean XL Azul
	 *
	 * Generar orden de produccion completa Jean XL Azul
	 *
	 * @throws RemoteException
	 */
	private static void crearPedidoGenerandoOPC() throws RemoteException {

		long[] idVariedades = { 29, 34, 39 };
		int[] cantidades = { 20, 20, 20 };
		PedidoClienteDTO pedido = crearPedido("20362134596", "test 3", idVariedades, cantidades);

		pedido = PedidoController.getInstance().crearPedido(pedido).toDTO();
		
		PedidoController.getInstance().cambiarEstadoPedidoCliente(pedido.getNroPedido(), EstadoPedidoCliente.ACEPTADO);

	}

	/**
	 * 4 Remera L Roja (Colorante x6, Boton x4, Tela x8) 2 Campera L Roja (Tela x18,
	 * Boton x20, Colorante x10)
	 *
	 * Generar orden de produccion parcial Remera L Roja y Campera L Roja y generar
	 * orden de compra de insumo Tela, Boton y Colorante
	 *
	 * @throws RemoteException
	 */
	private static void crearPedidoGenerandoOPPyOrdenInsumo() throws RemoteException {
		long[] idVariedades = { 34, 49 };
		int[] cantidades = { 4, 2 };
		PedidoClienteDTO pedido = crearPedido("20362134596", "test 4", idVariedades, cantidades);

		pedido = PedidoController.getInstance().crearPedido(pedido).toDTO();

		PedidoController.getInstance().cambiarEstadoPedidoCliente(pedido.getNroPedido(), EstadoPedidoCliente.ACEPTADO);

	}

	/**
	 * 4 Jean XL Azul (Tela x15, Boton x15, Colorante x3)
	 *
	 * Generar orden de produccion completa Jean XL Azul y orden de compra insumo
	 * Boton y Tela
	 *
	 * @throws RemoteException
	 */
	private static void crearPedidoGenerandoOPCyOrdenInsumo() throws RemoteException {
		long[] idVariedades = { 63 };
		int[] cantidades = { 4 };
		PedidoClienteDTO pedido = crearPedido("20362134596", "test 5", idVariedades, cantidades);

		pedido = PedidoController.getInstance().crearPedido(pedido).toDTO();

		PedidoController.getInstance().cambiarEstadoPedidoCliente(pedido.getNroPedido(), EstadoPedidoCliente.ACEPTADO);
	}

	/**
	 * 1 Remeras Rojas XL 1 Jean Verde M
	 *
	 * Generar orden de produccion completa Jean XL Azul, Generar orden de
	 * produccion parcial Remera L Roja y orden de compra insumos Tela, Boton y
	 * Colorante
	 *
	 * @throws RemoteException
	 */
	private static void crearPedidoGenerandoOPPyOPCyOrdenInsumo() throws RemoteException {
		long[] idVariedades = { 63, 34 };
		int[] cantidades = { 3, 3 };
		PedidoClienteDTO pedido = crearPedido("20362134596", "Pedido nuevo de cliente desde test", idVariedades,
				cantidades);

		pedido = PedidoController.getInstance().crearPedido(pedido).toDTO();

		PedidoController.getInstance().cambiarEstadoPedidoCliente(pedido.getNroPedido(), EstadoPedidoCliente.ACEPTADO);

	}

	private static PedidoClienteDTO crearPedido(String cuit, String nota, long[] idVariedades, int[] cantidades)
			throws RemoteException {
		PedidoClienteDTO pedido = new PedidoClienteDTO();

		pedido.setFechaGeneracion(new Date());
		pedido.setFechaDespacho(new Date());
		pedido.setFechaProbableDespacho(new Date());

		ClienteDTO cliente = ClienteController.getInstance().buscarCliente(cuit);
		pedido.setCliente(cliente);

		pedido.setSubtotal(Float.valueOf(1000));
		pedido.setImpuestos(Float.valueOf(100));
		pedido.setTotal(Float.valueOf(100));
		pedido.setEstado(EstadoPedidoCliente.CREADO);
		pedido.setNota(nota);

		List<ItemPedidoClienteDTO> items = new ArrayList<>();
		for (int i = 0; i < idVariedades.length; i++) {
			VariedadPrendaDTO variedad = PrendaController.getInstance().buscarVariedad(idVariedades[i]);
			ItemPedidoClienteDTO item1 = new ItemPedidoClienteDTO();
			item1.setCantidad(cantidades[i]);
			item1.setItem(variedad);
			item1.setPrecioItem(variedad.getPrecioVentaActual());
			items.add(item1);
		}
		pedido.setItems(items);
		return pedido;
	}

}
