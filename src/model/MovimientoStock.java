package model;

public class MovimientoStock {

	private Long id;
	private Integer cantidad;
	private String posicion;
	private Lote lote;
	private String descripcion;
	private String responsable;
	private PedidoCliente pedido;
	
	
	public PedidoCliente getPedido() {
		return pedido;
	}
	public void setPedido(PedidoCliente pedido) {
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
	public Lote getLote() {
		return lote;
	}
	public void setLote(Lote lote) {
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
