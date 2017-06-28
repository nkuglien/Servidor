package model;

import java.util.List;

import entities.ReservaInsumoEntity;

public class LoteInsumo extends Lote {

	private Insumo insumo;
	private PedidoInsumo pedidoInsumo;
	private Float precioCompra;
	private List<ReservaInsumo> reservas;
	
	
	public LoteInsumo(Long id, Integer cantDisponible, Posicion posicion, Insumo insumo, PedidoInsumo pedido, Float precioCompra2,
			List<ReservaInsumo> reservasBO) {
		this.setId(id);
		this.setCantDisponible(cantDisponible);
		this.setPosicion(posicion);
		this.setInsumo(insumo);
		this.setPedidoInsumo(pedido);
		this.setPrecioCompra(precioCompra2);
		this.setReservas(reservasBO);
		
	}

	public LoteInsumo(PedidoInsumo pedidoInsumo2) {
		this.setPedidoInsumo(pedidoInsumo2);
		this.setInsumo(pedidoInsumo2.getInsumo());
		this.setCantDisponible(pedidoInsumo2.getCantidad());
		this.setPrecioCompra(pedidoInsumo2.getPrecioUnidad());
		this.setPosicion(Posicion.getPosicionLibre());
	}

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

	public List<ReservaInsumo> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaInsumo> reservas) {
		this.reservas = reservas;
	}
	
	public void save(){
	 
	}
}
