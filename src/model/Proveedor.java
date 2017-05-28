package model;

import java.util.ArrayList;
import java.util.List;

import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import dao.ProveedorDAO;

public class Proveedor {

	private long id;
	private String nombre;
	private List<InsumoProveedor> insumos;
	
	public Proveedor() {
		this.insumos = new ArrayList<InsumoProveedor>();
	}
	
	public Proveedor(ProveedorDTO proveedor) {
		this.id = proveedor.getId();
		this.nombre = proveedor.getNombre();
		List<InsumoProveedor> insumosProveedor = new ArrayList<InsumoProveedor>();
		for(InsumoProveedorDTO insumoProv : proveedor.getInsumos()) {
			insumosProveedor.add(new InsumoProveedor(insumoProv));
		}
		this.insumos = insumosProveedor;
	}

	public Proveedor save() {
		return ProveedorDAO.getInstance().save(this);
	}
	
	public InsumoProveedor altaInsumo(Insumo insumo, float precio) {
		InsumoProveedor insumoProveedor = new InsumoProveedor(insumo, precio);
		this.getInsumos().add(insumoProveedor);
		return insumoProveedor;
	}
	
	public List<InsumoProveedor> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoProveedor> insumos) {
		this.insumos = insumos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProveedorDTO toDTO() {
		ProveedorDTO dto = new ProveedorDTO();
		dto.setId(this.id);
		dto.setNombre(this.nombre);

		List<InsumoProveedorDTO> insumosDTO = new ArrayList<InsumoProveedorDTO>();
		for(InsumoProveedor insumo : insumos){
			insumosDTO.add(insumo.toDTO());			
		}
		dto.setInsumos(insumosDTO);
		return dto;
	}

}
