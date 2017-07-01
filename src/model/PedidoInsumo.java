package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.PedidoInsumoDTO;
import dao.PedidoInsumoDAO;

public class PedidoInsumo {

	private Long id;
	private Proveedor proveedor;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaDespachoReal;
	private String estado;
	private Insumo insumo;
	private int cantidad;
	private Float precioUnidad;	
	private List<OrdenProduccion> ordenesProduccion;

	
	
	
	public static void generarPedidoInsumo(Insumo insumo,OrdenProduccion orden ){
		PedidoInsumoDAO DAO = PedidoInsumoDAO.getInstance();
		List<PedidoInsumo> pedidosPendientes= DAO.GetPedidosPendientesInsumo(insumo);
		Boolean flag =false;
		for(PedidoInsumo p : pedidosPendientes){
			if(p.ordenesProduccion.size()<=1){
				p.ordenesProduccion.add(orden);
				flag=true;
				p.save();
				break;
			}
		}
		if(!flag){
			PedidoInsumo pedi = new PedidoInsumo(insumo,orden);
			pedi.save();
		}
		
	}
	
	
	public void CompletarPedidoInsumo(Proveedor proveedor, Date fechaDespacho, Float precioUnidad){
		this.setProveedor(proveedor);
		this.setPrecioUnidad(precioUnidad);
		this.setFechaDespacho(fechaDespacho);
		this.setEstado("COMPLETO");
		this.save();
	}
	
	public void TerminarPedidoInsumo(Date FechaRealDespacho){
		this.setFechaDespachoReal(FechaRealDespacho);
		this.setEstado("TERMINADO");
		if(this.getOrdenesProduccion()!=null){
			for(OrdenProduccion o : this.getOrdenesProduccion()){
				o.intentarCompletar();
			}
		}
		this.save();
		this.getInsumo().setPrecio(this.getPrecioUnidad());
		this.getInsumo().save();
		LoteInsumo lote = new LoteInsumo(this);
		lote.save();
	}
	
	
	private void save() {
		PedidoInsumoDAO DAO = PedidoInsumoDAO.getInstance();
		DAO.save(this);
		
	}




	public PedidoInsumo(Insumo insumo){
		setInsumo(insumo);
		setFechaGeneracion(new Date());
		setEstado("INICIAL");
		setCantidad(insumo.getCantCompra());
		ordenesProduccion = new ArrayList<OrdenProduccion>();
	}
	public PedidoInsumo(Insumo insumo, OrdenProduccion orden){
		this(insumo);
		getOrdenesProduccion().add(orden);
	}
	public PedidoInsumo() {
		// TODO Auto-generated constructor stub
	}




	public PedidoInsumo(Long id2, String estado2, Date fechaGeneracion2, Date fechaDespacho2, Date fechaDespachoReal2,
			Proveedor proveedor2, Insumo insumo2, Float precioUnidad2, int cantidad2, List<OrdenProduccion> ordenes2) {
		id=id2;
		estado=estado2;
		fechaGeneracion=fechaGeneracion2;
		fechaDespacho=fechaDespacho2;
		fechaDespachoReal=fechaDespachoReal2;
		proveedor=proveedor2;
		insumo=insumo2;
		cantidad=cantidad2;
		ordenesProduccion=ordenes2;	
		precioUnidad=precioUnidad2;
		
	}




	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(Float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	
	public Long getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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

	

	public List<OrdenProduccion> getOrdenesProduccion() {
		return ordenesProduccion;
	}

	public void setOrdenesProduccion(List<OrdenProduccion> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}


	public PedidoInsumoDTO toDTO() {
		String provnombre="";
		if(proveedor!=null) provnombre=proveedor.getNombre();
		PedidoInsumoDTO dto = new PedidoInsumoDTO(id,provnombre,fechaGeneracion, fechaDespacho, fechaDespachoReal,estado,insumo.getDescripcion(),cantidad,precioUnidad);
		return dto;
	}

}
