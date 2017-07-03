package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;

import model.Insumo;
import model.LoteInsumo;
import model.OrdenProduccion;
import model.PedidoInsumo;
import model.Proveedor;

@Entity
@Table(name = "PedidoInsumo")
public class PedidoInsumoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private ProveedorEntity proveedor;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaDespachoReal;
	private String estado;
	@ManyToOne
	private InsumoEntity insumo;
	private int cantidad;
	private Float precioUnidad;
	@ManyToMany
	private List<OrdenProduccionEntity> ordenesProduccion;
	
	@OneToOne(cascade=CascadeType.ALL)
	private LoteInsumoEntity lote;

	public PedidoInsumoEntity() {
	}

	public PedidoInsumoEntity(PedidoInsumo pedido, boolean setLote) {
		
		setCantidad(pedido.getCantidad());
		setEstado(pedido.getEstado());
		setFechaDespacho(pedido.getFechaDespacho());
		setFechaDespachoReal(pedido.getFechaDespachoReal());
		setFechaGeneracion(pedido.getFechaGeneracion());
		setId(pedido.getId());
		setInsumo(new InsumoEntity(pedido.getInsumo()));
		if (pedido.getOrdenesProduccion() != null) {
			List<OrdenProduccionEntity> ordenes = new ArrayList<OrdenProduccionEntity>();
			for (OrdenProduccion o : pedido.getOrdenesProduccion()) {
				ordenes.add(new OrdenProduccionEntity(o));
			}
			setOrdenesProduccion(ordenes);
		}
		setPrecioUnidad(pedido.getPrecioUnidad());
		if (pedido.getProveedor() != null) {
			setProveedor(new ProveedorEntity(pedido.getProveedor()));
		}
		if(setLote && pedido.getLote()!=null)
			setLote(new LoteInsumoEntity(pedido.getLote(),false));
	}

	public LoteInsumoEntity getLote() {
		return lote;
	}

	public void setLote(LoteInsumoEntity lote) {
		this.lote = lote;
	}

	public InsumoEntity getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoEntity insumo) {
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

	public List<OrdenProduccionEntity> getOrdenesProduccion() {
		return ordenesProduccion;
	}

	public void setOrdenesProduccion(List<OrdenProduccionEntity> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}

	public PedidoInsumo toBO(boolean setLote) {
		List<OrdenProduccion> ordenes = new ArrayList<OrdenProduccion>();
		if (this.getOrdenesProduccion() != null) {
			for (OrdenProduccionEntity o : this.getOrdenesProduccion()) {
				ordenes.add(o.toBO());
			}
		}
		Proveedor prov=null;
		if(this.getProveedor()!=null)
			prov=this.getProveedor().toBO();
		LoteInsumo lote =null;
		if(setLote){
			if(getLote()!=null){
				lote= getLote().toBO();
			}
		}
		
		PedidoInsumo pedido = new PedidoInsumo(this.getId(),this.getEstado(),this.getFechaGeneracion(),this.getFechaDespacho(),this.getFechaDespachoReal(),prov,this.getInsumo().toBO(),this.getPrecioUnidad(), this.getCantidad(),ordenes,lote);
	
		return pedido;
	}

}
