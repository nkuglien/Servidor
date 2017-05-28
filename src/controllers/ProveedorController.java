package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.InsumoDTO;
import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import dao.ProveedorDAO;
import model.Insumo;
import model.Proveedor;

public class ProveedorController {

private static ProveedorController instancia;
	
	public static ProveedorController GetInstancia(){
		if(instancia==null)
			instancia= new ProveedorController();
		return instancia;
	}
	
	
	
	
	public boolean verificarProveedor(int parseInt)  {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void altaProveedor(int parseInt, String text)  {
		// TODO Auto-generated method stub

	}

	
	public void bajaProveedor(int parseInt)  {
		// TODO Auto-generated method stub

	}

	
	public ProveedorDTO solicitarProveedorView(int parseInt)  {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void modificarProveedor(ProveedorDTO pv, int parseInt)  {
		// TODO Auto-generated method stub

	}

	
	public List<ProveedorDTO> getAllProveedores()  {
		List<ProveedorDTO> proveedoresDTO = new ArrayList<ProveedorDTO>();
		List<Proveedor> proveedores = ProveedorDAO.getInstance().getAllProveedores();
		
		for(Proveedor proveedor : proveedores){
			proveedoresDTO.add(proveedor.toDTO());			
		}
		
		return proveedoresDTO;
	}




	public InsumoProveedorDTO asociarInsumo(ProveedorDTO proveedorDTO, InsumoDTO insumoDTO, Float precio) {
		Proveedor proveedor =  new Proveedor(proveedorDTO);
		InsumoProveedorDTO insumoPorveedor = proveedor.altaInsumo(new Insumo(insumoDTO), precio).toDTO();
		proveedor.save();
		return insumoPorveedor;
	}
}
