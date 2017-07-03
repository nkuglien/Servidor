package model;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.PedidoInsumoDTO;
import dao.PedidoInsumoDAO;
import dao.PosicionDAO;

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
	private LoteInsumo lote;

	
	
	
	public LoteInsumo getLote() {
		return lote;
	}


	public void setLote(LoteInsumo lote) {
		this.lote = lote;
	}


	public static void generarPedidoInsumo(Insumo insumo,OrdenProduccion orden ){
		PedidoInsumoDAO DAO = PedidoInsumoDAO.getInstance();
		List<PedidoInsumo> pedidosPendientes= DAO.GetPedidosPendientesInsumo(insumo);
		Boolean loAgregue =false;
		Boolean yaEstaAnotadoEnUno =false;
		for(PedidoInsumo p : pedidosPendientes){
			if(p.getOrdenesProduccion().contains(orden)) yaEstaAnotadoEnUno=true;
		}
		if(!yaEstaAnotadoEnUno){
		for(PedidoInsumo p : pedidosPendientes){
						
			if(p.getOrdenesProduccion().size()<=1){
				p.getOrdenesProduccion().add(orden);
				loAgregue=true;
				p.save();
				break;
			}
			
				
			
		}
		}
		if(!loAgregue){
			PedidoInsumo pedi = new PedidoInsumo(insumo);
			pedi.getOrdenesProduccion().add(orden);
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
	
	public void TerminarPedidoInsumo(Date FechaRealDespacho) throws RemoteException{
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
		try{
		LoteInsumo lote = new LoteInsumo(this);
		
		this.setLote(lote);
		PedidoInsumo ped =this.save();
		Posicion pos = PosicionDAO.getInstance().getPosicionInsumoVacia();
		pos.setLote(ped.getLote());
		pos.save();
		
		}
		catch(Exception e){
			throw new RemoteException("No se pudo almacenar el lote");
		}
	}
	
	
	private PedidoInsumo save() {
		return PedidoInsumoDAO.getInstance().save(this);
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
			Proveedor proveedor2, Insumo insumo2, Float precioUnidad2, int cantidad2, List<OrdenProduccion> ordenes2,LoteInsumo  lote2) {
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
		lote=lote2;
		
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
		String lote="";
		String posicion="";
		String disponible="";
		if(getLote()!=null){
			lote = getLote().getId().toString();
			disponible= getLote().getCantDisponible().toString();
			if(getLote().getPosicion()!=null){
				posicion= getLote().getPosicion().getCodigo();
			}
			
		}
		
		PedidoInsumoDTO dto = new PedidoInsumoDTO(id,provnombre,fechaGeneracion, fechaDespacho, fechaDespachoReal,estado,insumo.getDescripcion(),cantidad,precioUnidad,lote,posicion,disponible);
		return dto;
	}

}
