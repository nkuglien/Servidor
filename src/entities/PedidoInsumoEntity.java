package entities;

import java.util.Date;
import java.util.List;

public class PedidoInsumoEntity {

	private Long id;
	private ProveedorEntity proveedor;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaDespachoReal;
	private List<ItemPedidoInsumoEntity> insumos;
	private OrdenProduccionEntity ordenProduccion;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ProveedorEntity getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(ProveedorEntity proveedor) {
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
	
	public List<ItemPedidoInsumoEntity> getInsumos() {
		return insumos;
	}
	
	public void setInsumos(List<ItemPedidoInsumoEntity> insumos) {
		this.insumos = insumos;
	}
	
	public OrdenProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}
	
	public void setOrdenProduccion(OrdenProduccionEntity ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
}
