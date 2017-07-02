package test;

import DTO.EstadoPedidoCliente;
import controllers.PedidoController;
import model.PedidoCliente;

public class TestCrearPedidoConLogicaNegocio {
	
	public static void main(String[] args) {
		TestAreaProduccion.main(null);
		TestPrenda.main(null);
		TestCrearPedido.main(null);
		
		PedidoController controller = PedidoController.getInstance();
		PedidoCliente pc = controller.getPedidoCliente(Long.parseLong("12"));
		pc = PedidoController.getInstance().cambiarEstadoPedidoCliente(pc.getNroPedido(), EstadoPedidoCliente.ACEPTADO);
		System.out.println(pc);
	}
}