package entities;

import java.util.Date;

public class OrdenProduccion {

	private Long id;
	private Date fecha;
	private String estado;
	private PedidoCliente pedidoCliente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public PedidoCliente getPedidoCliente() {
		return pedidoCliente;
	}
	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}
	
	
}
