package model;

import DTO.ReservaVariedadPrendaDTO;
import dao.LoteDAO;

public class ReservaVariedadPrenda {
	
	private Integer id;
	private PedidoCliente pedido;
	private LoteVariedadPrenda lote;
	private int cantidad;
	
	
	public ReservaVariedadPrenda(ReservaVariedadPrendaDTO dto) {
		this.id = dto.getId();
		this.pedido = new PedidoCliente(dto.getPedido());
		this.lote = new LoteVariedadPrenda(dto.getLote());
		this.cantidad = dto.getCantidad();
	}
	
	public ReservaVariedadPrenda(PedidoCliente p, LoteVariedadPrenda l, int cantidad) {
		this.pedido = p;
		this.lote = l;
		this.cantidad = cantidad;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
