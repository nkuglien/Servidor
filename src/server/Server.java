package server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RemoteObject.ClienteRemote;
import RemoteObject.InsumoRemote;
import RemoteObject.ProveedorRemote;
import RemoteObjects.ClienteRemoto;
import RemoteObjects.InsumoRemoto;
import RemoteObjects.ProveedorRemoto;

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
			
			ClienteRemote clienteRemote = new ClienteRemoto();
			Naming.bind("//localhost:1099/ClienteRemoto", clienteRemote);
			
			ProveedorRemote proveedorRemote = new ProveedorRemoto();
			Naming.bind("//localhost:1099/ProveedorRemoto", proveedorRemote);
			
			InsumoRemote insumoRemote = new InsumoRemoto();
			Naming.bind("//localhost:1099/InsumoRemoto", insumoRemote);
			
			System.out.println("Servicios registrados exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
