package test;

import dao.ClienteDAO;
import model.Cliente;
import model.Sucursal;

public class TestSucursal {
	
	public static void main(String[] args) {
		TestCliente.main(args);
		Sucursal sucursal = createSucursal(1000, "Sucursal 1000", 9000, 1800, "Calle falsa 123");
		
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		sucursal.altaCliente(cliente);
		sucursal.save();
		
		sucursal.baja();
		
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
