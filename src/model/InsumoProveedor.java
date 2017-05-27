package model;

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

}
