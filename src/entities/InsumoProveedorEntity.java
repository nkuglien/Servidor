package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.InsumoProveedor;

@Entity
@Table(name = "INSUMO_PROVEEDOR")
public class InsumoProveedorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insumoproveedor_id")
	private Long id;
	
	@ManyToOne
	private InsumoEntity insumo;
	
	@Column(name = "precio")
	private Float precio;
	
	public InsumoProveedorEntity() {
	}
	
	public InsumoProveedorEntity(InsumoProveedor insumo) {
		this.setId(insumo.getId());
		this.setInsumo(new InsumoEntity(insumo.getInsumo()));
		this.setPrecio(insumo.getPrecio());
	}

	public InsumoProveedor toBO() {
		InsumoProveedor insumoProveedor = new InsumoProveedor();
		insumoProveedor.setId(this.getId());
		insumoProveedor.setInsumo(this.getInsumo().toBO());
		insumoProveedor.setPrecio(this.getPrecio());
		return insumoProveedor;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public InsumoEntity getInsumo() {
		return insumo;
	}
	
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	
	public Float getPrecio() {
		return precio;
	}
	
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
}
