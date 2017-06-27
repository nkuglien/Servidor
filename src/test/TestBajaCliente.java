package test;

import dao.ClienteDAO;
import model.Cliente;

public class TestBajaCliente {
	
	public static void main(String[] args) {
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		cliente.baja();
		System.out.println(cliente);
		System.out.println("fin test cliente");
	}

}
