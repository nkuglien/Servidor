package model;

import DTO.InsumoDTO;
import DTO.InsumoProveedorDTO;

public class InsumoProveedor {

	private Long id;
	private Insumo insumo;
	private Float precio;
	
	public InsumoProveedor() {
	}

	public InsumoProveedor(Insumo insumo, float precio) {
		this.setInsumo(insumo);
		this.setPrecio(precio);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public InsumoProveedorDTO toDTO() {
		InsumoProveedorDTO dto = new InsumoProveedorDTO();
		dto.setId(this.id);
		dto.setInsumo(this.insumo.toDTO());
		dto.setPrecio(this.precio);
		return null;
	}

}
