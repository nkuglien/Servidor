package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
			
			//Naming.bind("AlumnoRemoto", alumnoRemoto);
			System.out.println("Servicios registrados exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
