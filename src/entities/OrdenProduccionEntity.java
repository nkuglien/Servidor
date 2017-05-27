package entities;

import java.util.Date;

public class OrdenProduccionEntity {

	private Long id;
	private Date fecha;
	private String estado;
	private PedidoClienteEntity pedidoCliente;
	
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
	
	public PedidoClienteEntity getPedidoCliente() {
		return pedidoCliente;
	}
	
	public void setPedidoCliente(PedidoClienteEntity pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}
	
}
