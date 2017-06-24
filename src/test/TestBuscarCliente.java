package test;

import dao.ClienteDAO;
import model.Cliente;

public class TestBuscarCliente {
	
	public static void main(String[] args) {
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		System.out.println(cliente);
		System.out.println("fin test cliente");
	}

}
