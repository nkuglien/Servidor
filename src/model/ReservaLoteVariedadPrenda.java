package model;

public class ReservaLoteVariedadPrenda {
	
	private int id;
	private PedidoCliente pedido;
	private LoteVariedadPrenda lote;
	private int cantidad;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PedidoCliente getPedido() {
		return pedido;
	}
	public void setPedido(PedidoCliente pedido) {
		this.pedido = pedido;
	}
	public LoteVariedadPrenda getLote() {
		return lote;
	}
	public void setLote(LoteVariedadPrenda lote) {
		this.lote = lote;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
