package entities;

public class ItemInsumo {
	
	private Long id;
	private Insumo insumo;
	private Float desperdicio;
	private Integer cantidad;
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
