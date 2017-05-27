package server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RemoteObject.ClienteRemote;
import controllers.ClienteController;

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
			
			ClienteRemote clienteRemote = new ClienteController();
			Naming.bind("//localhost:1099/ClienteController", clienteRemote);
			System.out.println("Servicios registrados exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
