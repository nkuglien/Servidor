package test;

import DTO.PedidoClienteDTO;
import controllers.PedidoController;
import model.PedidoCliente;

public class TestCrearPedidoConLogicaNegocio {
	
	public static void main(String[] args) {
		TestAreaProduccion.main(null);
		TestPrenda.main(null);
		TestCrearPedido.main(null);
		
		PedidoController controller = PedidoController.getInstance();
		PedidoCliente pc = controller.getPedidoCliente(Long.parseLong("12"));
		pc = PedidoController.getInstance().aceptarPedidoCliente(pc.getNroPedido(), true);
		System.out.println(pc);
	}
}