package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProveedorDAO;

public class Proveedor {

	private long id;
	private String nombre;
	private List<InsumoProveedor> insumos;
	
	public Proveedor() {
		this.insumos = new ArrayList<InsumoProveedor>();
	}
	
	public void save() {
		ProveedorDAO.getInstance().save(this);
	}
	
	public void agregarInsumo(Insumo insumo, float precio) {
		this.getInsumos().add(new InsumoProveedor(insumo, precio));
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

}
