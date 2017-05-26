package entities;

public class LoteInsumoEntity extends LoteEntity{

	private InsumoEntity insumo;
	private PedidoInsumoEntity pedidoInsumo;
	private Float precioCompra;
	
	public InsumoEntity getInsumo() {
		return insumo;
	}
	
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	
	public PedidoInsumoEntity getPedidoInsumo() {
		return pedidoInsumo;
	}
	
	public void setPedidoInsumo(PedidoInsumoEntity pedidoInsumo) {
		this.pedidoInsumo = pedidoInsumo;
	}
	
	public Float getPrecioCompra() {
		return precioCompra;
	}
	
	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}
	
}
