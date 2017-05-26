package model;

import java.util.Date;
import java.util.List;

public class PedidoCliente {

	private long id;
	private Long nroPedido;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaProbableDespacho;
	private List<ItemPedidoCliente> items;
	private Cliente cliente;
	private Float subtotal;
	private Float impuestos;
	private Float total;
	private Boolean aprobadoSucursal;
	private Boolean aceptadoCliente;

	public Long getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(Long nroPedido) {
		this.nroPedido = nroPedido;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public List<ItemPedidoCliente> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoCliente> items) {
		this.items = items;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Float impuestos) {
		this.impuestos = impuestos;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Boolean getAprobadoSucursal() {
		return aprobadoSucursal;
	}

	public void setAprobadoSucursal(Boolean aprobadoSucursal) {
		this.aprobadoSucursal = aprobadoSucursal;
	}

	public Boolean getAceptadoCliente() {
		return aceptadoCliente;
	}

	public void setAceptadoCliente(Boolean aceptadoCliente) {
		this.aceptadoCliente = aceptadoCliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
