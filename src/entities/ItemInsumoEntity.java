package entities;

public class ItemInsumoEntity {
	
	private Long id;
	private InsumoEntity insumo;
	private Float desperdicio;
	private Integer cantidad;
	
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
