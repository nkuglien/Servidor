package model;

public class LoteInsumo extends Lote {

	private Insumo insumo;
	private PedidoInsumo pedidoInsumo;
	private Float precioCompra;

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public PedidoInsumo getPedidoInsumo() {
		return pedidoInsumo;
	}

	public void setPedidoInsumo(PedidoInsumo pedidoInsumo) {
		this.pedidoInsumo = pedidoInsumo;
	}

	public Float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}
}
