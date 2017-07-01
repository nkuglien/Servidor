package test;

import model.Cliente;

public class TestCrearCliente {

	public static void main(String[] args) {
		Cliente cliente = crearCliente(1, "Ezequiel", "French 2574", "1136214694", "20347444376", 1);
		Cliente cliente2 = crearCliente(2, "Roberto", "Gorriti 2574", "1136564694", "20346844376", 2);
		Cliente cliente3 = crearCliente(3, "Pedro", "Alberdi 3378", "1124214694", "20347449676", 3);
		Cliente cliente4 = crearCliente(4, "Juan", "Medrano 1723", "1136214214", "20340544376", 4);
		Cliente cliente5 = crearCliente(5, "Rigoberto", "Bulnes 2312", "1136207694", "20347944376", 5);
		
		cliente.habilitarCuentaCorriente(0, -5000);
		
		cliente.agregarValorConsignacion("libro", 20);
		cliente.agregarValorConsignacion("bici", 500);
		
		cliente.addMovimiento(500);
		cliente.addMovimiento(-300);
		cliente.addMovimiento(-800);
		
		cliente.save();
		cliente2.save();
		cliente3.save();
		cliente4.save();
		cliente5.save();
		System.out.println("fin test cliente");
		
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
