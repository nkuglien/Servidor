package entities;

public class ItemPedidoClienteEntity {

	private Long id;
	private VariedadPrendaEntity item;
	private Integer cantidad;
	private Float precioItem;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public VariedadPrendaEntity getItem() {
		return item;
	}
	
	public void setItem(VariedadPrendaEntity item) {
		this.item = item;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Float getPrecioItem() {
		return precioItem;
	}
	
	public void setPrecioItem(Float precioItem) {
		this.precioItem = precioItem;
	}
	
}
