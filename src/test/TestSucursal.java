package test;

import dao.ClienteDAO;
import model.Cliente;
import model.Sucursal;

public class TestSucursal {
	
	public static void main(String[] args) {
		Sucursal sucursal = createSucursal(1000, "Sucursal 1000", 9000, 1800, "Calle falsa 123");
		
		Cliente cliente = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		sucursal.altaCliente(cliente);
		sucursal.save();
		
		Sucursal sucursal2 = createSucursal(2000, "Sucursal 2000", 9000, 1800, "Lima 747");
		Cliente cliente1 = ClienteDAO.getInstance().findClienteByCuit("20347444376");
		sucursal2.altaCliente(cliente1);
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
