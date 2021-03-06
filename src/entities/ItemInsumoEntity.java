package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.ItemInsumo;

@Entity
@Table(name = "ITEM_INSUMO")
public class ItemInsumoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_insumo_id")
	private Long id;
	
	@ManyToOne
	private InsumoEntity insumo;
	
	@Column(name = "desperdicio")
	private Float desperdicio;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	public ItemInsumoEntity() {
	}
	
	public ItemInsumoEntity(ItemInsumo itemInsumo) {
		this.setId(itemInsumo.getId());
		this.setInsumo(new InsumoEntity(itemInsumo.getInsumo()));
		this.setDesperdicio(itemInsumo.getDesperdicio());
		this.setCantidad(itemInsumo.getCantidad());		
	}
	
	public ItemInsumo toBO() {
		ItemInsumo itemInsumo = new ItemInsumo();
		itemInsumo.setId(this.getId());
		itemInsumo.setInsumo(this.getInsumo().toBO());
		itemInsumo.setDesperdicio(this.getDesperdicio());
		itemInsumo.setCantidad(this.getCantidad());
		return itemInsumo;
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
	
	public Float getDesperdicio() {
		return desperdicio;
	}
	
	public void setDesperdicio(Float desperdicio) {
		this.desperdicio = desperdicio;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
