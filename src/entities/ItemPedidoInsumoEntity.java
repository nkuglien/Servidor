package entities;

public class ItemPedidoInsumoEntity {

	private Long id;
	private InsumoEntity insumo;
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
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
