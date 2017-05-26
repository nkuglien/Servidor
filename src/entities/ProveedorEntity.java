package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.InsumoProveedor;
import model.Proveedor;

@Entity
@Table(name = "PROVEEDOR")
public class ProveedorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proveedor_id")
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PROVEEDOR_INSUMOPROVEEDOR", joinColumns = {
			@JoinColumn(name = "proveedor_id") }, inverseJoinColumns = { @JoinColumn(name = "insumoproveedor_id") })
	private List<InsumoProveedorEntity> insumos;

	public ProveedorEntity() {
	}

	public ProveedorEntity(Proveedor proveedor) {
		this.setId(proveedor.getId());
		this.setNombre(proveedor.getNombre());
		this.setInsumosInsumosEntity(proveedor.getInsumos());
	}

	private void setInsumosInsumosEntity(List<InsumoProveedor> insumos) {
		List<InsumoProveedorEntity> list = new ArrayList<InsumoProveedorEntity>();
		for (InsumoProveedor insumo : insumos) {
			list.add(new InsumoProveedorEntity(insumo));
		}
		this.setInsumos(list);
	}

	public List<InsumoProveedorEntity> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoProveedorEntity> insumos) {
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
