package test;

import java.util.Date;

import model.Cliente;

public class TestCliente {

	public static void main(String[] args) {
		crearCliente(1, "Ezequiel", "French 2574", "1136214694", "20347444376", 1);
//		crearCliente(2, "Coco", "Colombres 235", "1143579364", "20049807693", 2);
//		crearCliente(3, "Eneas", "Castro Barros 108", "1193414721", "12345678910", 3);
	}

	private static void crearCliente(int nroLegajo, String nombre, String direccion, String telefono, String cuit,
			long nroCliente) {
		Cliente cliente = new Cliente();
		cliente.setNroLegajo(nroLegajo);
		cliente.setNombre(nombre);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setCuit(cuit);
		cliente.setNroCliente(nroCliente);
		
		cliente.addValor(10, "libro");
		cliente.addValor(500, "bici");
		
		cliente.addMovimiento(new Date(), 200);
		cliente.addMovimiento(new Date(), 1500);
		
		cliente.save();
	}
	
}
