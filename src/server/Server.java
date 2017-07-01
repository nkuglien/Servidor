package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RemoteObject.TDACliente;
import RemoteObject.TDAInsumo;
import RemoteObject.TDAOrdenProduccion;
import RemoteObject.TDAPedido;
import RemoteObject.TDAPrenda;
import RemoteObject.TDAProveedor;
import RemoteObject.TDASucursal;
import RemoteObjects.ClienteRemoto;
import RemoteObjects.InsumoRemoto;
import RemoteObjects.OrdenProduccionRemoto;
import RemoteObjects.PedidoRemoto;
import RemoteObjects.PrendaRemoto;
import RemoteObjects.ProveedorRemoto;
import RemoteObjects.SucursalRemoto;

public class Server {
	
	public static void main(String[] args) {
		new Server();
	}
	
	public Server() {
		iniciar();
	}
	
	public void iniciar() {
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			
			TDACliente clienteRemote = new ClienteRemoto();
			Naming.bind("//localhost:1099/ClienteRemoto", clienteRemote);
			
			TDAProveedor proveedorRemote = new ProveedorRemoto();
			Naming.bind("//localhost:1099/ProveedorRemoto", proveedorRemote);
			
			TDASucursal sucursalRemote = new SucursalRemoto();
			Naming.bind("//localhost:1099/SucursalRemoto", sucursalRemote);
			
			TDAInsumo insumoRemote = new InsumoRemoto();
			Naming.bind("//localhost:1099/InsumoRemoto", insumoRemote);
			
			TDAPrenda prendaRemote = new PrendaRemoto();
			Naming.bind("//localhost:1099/PrendaRemoto", prendaRemote);
			
			TDAPedido pedidoRemote = new PedidoRemoto();
			Naming.bind("//localhost:1099/PedidoRemoto", pedidoRemote);
			
			TDAOrdenProduccion ordenProduccionRemoto = new OrdenProduccionRemoto();
			Naming.bind("//localhost:1099/OordenProduccionRemoto", ordenProduccionRemoto);
			
			System.out.println("Servicios registrados exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
