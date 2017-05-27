package entities;

public class MovimientoStockEntity {

	private Long id;
	private Integer cantidad;
	private String posicion;
	private LoteEntity lote;
	private String descripcion;
	private String responsable;
	private PedidoClienteEntity pedido;
	
	public PedidoClienteEntity getPedido() {
		return pedido;
	}
	
	public void setPedido(PedidoClienteEntity pedido) {
		this.pedido = pedido;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getPosicion() {
		return posicion;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public LoteEntity getLote() {
		return lote;
	}
	
	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getResponsable() {
		return responsable;
	}
	
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
}
