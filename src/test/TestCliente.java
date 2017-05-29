package test;

import model.Cliente;

public class TestCliente {

	public static void main(String[] args) {
		Cliente cliente = crearCliente(1, "Ezequiel", "French 2574", "1136214694", "20347444376", 1);
		
		cliente.habilitarCuentaCorriente(0, -5000);
		
		cliente.agregarValorConsignacion("libro", 20);
		cliente.agregarValorConsignacion("bici", 500);
		
		cliente.addMovimiento(500);
		cliente.addMovimiento(-300);
		cliente.addMovimiento(-800);
		
		cliente.save();

		cliente.baja();
		
//		crearCliente(2, "Coco", "Colombres 235", "1143579364", "20049807693", 2);
//		crearCliente(3, "Eneas", "Castro Barros 108", "1193414721", "12345678910", 3);
	}

	private static Cliente crearCliente(int nroLegajo, String nombre, String direccion, String telefono, String cuit,
			long nroCliente) {
		Cliente cliente = new Cliente();
		cliente.setNroLegajo(nroLegajo);
		cliente.setNombre(nombre);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setCuit(cuit);
		cliente.setNroCliente(nroCliente);
		cliente.setActivo(true);
		cliente = cliente.save();
		
		return cliente;
	}

}
