package entities;

import java.util.Date;
import java.util.List;

public class PedidoInsumo {

	private Long id;
	private Proveedor proveedor;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaDespachoReal;
	private List<ItemPedidoInsumo> insumos;
	private OrdenProduccion ordenProduccion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
	public Date getFechaDespachoReal() {
		return fechaDespachoReal;
	}
	public void setFechaDespachoReal(Date fechaDespachoReal) {
		this.fechaDespachoReal = fechaDespachoReal;
	}
	public List<ItemPedidoInsumo> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<ItemPedidoInsumo> insumos) {
		this.insumos = insumos;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
	
	
}
