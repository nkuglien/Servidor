package controllers;

import java.util.ArrayList;
import java.util.List;

import DTO.InsumoDTO;
import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import dao.ProveedorDAO;
import model.Insumo;
import model.Proveedor;

public class ProveedorController {

	private static ProveedorController instance;

	public static ProveedorController getInstance() {
		if (instance == null) {
			instance = new ProveedorController();
		}
		return instance;
	}

	public boolean verificarProveedor(int parseInt) {
		// TODO Auto-generated method stub
		return false;
	}

	public void altaProveedor(ProveedorDTO proveedor) {
		ProveedorDAO.getInstance().save(new Proveedor(proveedor));
	}

	public void bajaProveedor(int parseInt) {
		// TODO Auto-generated method stub

	}

	public ProveedorDTO solicitarProveedorView(int parseInt) {
		Proveedor prov = ProveedorDAO.getInstance().findProveedorById(parseInt);
		return prov != null ? prov.toDTO() : null;
	}

	public void modificarProveedor(ProveedorDTO pv) {
		Proveedor p = new Proveedor(pv);
		p.save();
	}

	public List<ProveedorDTO> getAllProveedores() {
		List<ProveedorDTO> proveedoresDTO = new ArrayList<ProveedorDTO>();
		List<Proveedor> proveedores = ProveedorDAO.getInstance().getAllProveedores();

		for (Proveedor proveedor : proveedores) {
			proveedoresDTO.add(proveedor.toDTO());
		}

		return proveedoresDTO;
	}

	public InsumoProveedorDTO asociarInsumo(ProveedorDTO proveedorDTO, InsumoDTO insumoDTO, Float precio) {
		Proveedor proveedor = new Proveedor(proveedorDTO);
		InsumoProveedorDTO insumoPorveedor = proveedor.altaInsumo(new Insumo(insumoDTO), precio).toDTO();
		proveedor.save();
		return insumoPorveedor;
	}
}
