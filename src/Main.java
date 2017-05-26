import RemoteObject.ClienteRemote;
import controllers.ClienteController;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.util.Iterator;
import java.util.List;

import DTO.ClienteDTO;
public class Main {

		ClienteRemote objetoRemoto;
		
		public static void main(String[] args)
		{
			try{
			new Main();
			ClienteRemote gestionClientes = new ClienteController();
			List<ClienteDTO> clientes = gestionClientes.GetClientes();
			
			for(Iterator<ClienteDTO> clis = clientes.iterator();clis.hasNext();){
				ClienteDTO cli = clis.next();
				System.out.println(cli.getNombre());
			}
			
			}
			catch(Exception e){
				
			}
		}
		
		public Main() {
			iniciar();
		}
		
	    public void iniciar() {
	    	try {
	    		LocateRegistry.createRegistry(1099);	
	            ClienteRemote gestionClientes = new ClienteController();
	            Naming.rebind ("//localhost/GestionClientes", gestionClientes);
	            System.out.println("Fijado en //localhost/GestionClientes");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	
}
