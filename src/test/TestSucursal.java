package test;

import dao.ClienteDAO;
import model.Cliente;
import model.Sucursal;

public class TestSucursal {
	
	public static void main(String[] args) {
		Sucursal sucursal = createSucursal(1000, "Sucursal 1000", 9000, 1800, "Calle falsa 123");
		
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20349296722");
		sucursal.altaCliente(cliente);
		sucursal.save();
		
		Sucursal sucursal2 = createSucursal(2000, "Sucursal 2000", 7000, 1500, "Rivadavia 678");
		
		Cliente cliente2 = ClienteDAO.getInstance().findClienteByCuit("20362134596");
		sucursal2.altaCliente(cliente2);
		sucursal2.save();
	

	}

	public static Sucursal createSucursal(int numero, String nombre, int horAp, int horCier, String dir) {
		Sucursal sucursal = new Sucursal();
		sucursal.setNumero(numero);
		sucursal.setNombre(nombre);
		sucursal.setHorarioApertura(horAp);
		sucursal.setHorarioCierre(horCier);
		sucursal.setDireccion(dir);
		sucursal = sucursal.save();
		sucursal.setActivo(true);
		return sucursal;
	}
	
}
