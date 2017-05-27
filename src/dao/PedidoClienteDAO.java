package dao;

import model.PedidoCliente;

public class PedidoClienteDAO extends HibernateDAO {
	
	private static PedidoClienteDAO instancia = null;

	public static PedidoClienteDAO getInstance(){
		if(instancia == null) {
			instancia = new PedidoClienteDAO();
		} 
		return instancia;
	}

	public PedidoCliente getByNroPedido(Long nroPedido) {
		//TODO
		return null;
	}

	public void save(PedidoCliente pedidoCliente) {
		//TODO
	}


}
