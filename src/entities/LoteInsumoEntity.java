package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.LoteInsumo;
import model.PedidoInsumo;
import model.Posicion;
import model.ReservaInsumo;

@Entity
@Table(name="LoteInsumo")
public class LoteInsumoEntity extends LoteEntity{
	
	@ManyToOne(cascade=CascadeType.ALL)
	private InsumoEntity insumo;
	@OneToOne(mappedBy="lote", cascade= CascadeType.ALL)	
	private PedidoInsumoEntity pedidoInsumo;	
	private Float precioCompra;
	@OneToMany
	@JoinColumn(name="idLote")
	private List<ReservaInsumoEntity> reservas;
	
	public LoteInsumoEntity(LoteInsumo loteInsumo, boolean setPedido) {
		
		if(loteInsumo.getInsumo()!=null)
			setInsumo(new InsumoEntity(loteInsumo.getInsumo()));
		setPrecioCompra(loteInsumo.getPrecioCompra());
		setId(loteInsumo.getId());
		if(loteInsumo.getPosicion()!=null)
		setPosicion(new PosicionEntity(loteInsumo.getPosicion()));
		if(loteInsumo.getReservas()!=null){
			List<ReservaInsumoEntity> re = new ArrayList<ReservaInsumoEntity>();
			for(ReservaInsumo ri : loteInsumo.getReservas()){
				re.add(new ReservaInsumoEntity(ri));
			}
			setReservas(re);
		}
		setCantDisponible(loteInsumo.getCantDisponible());
		setCantidad(loteInsumo.getCantidad());
		if(setPedido && loteInsumo.getPedidoInsumo()!=null)
		setPedidoInsumo(new PedidoInsumoEntity( loteInsumo.getPedidoInsumo(),false));
	}

	public LoteInsumoEntity() {}
	
	
	public InsumoEntity getInsumo() {
		return insumo;
	}
	
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	
	public PedidoInsumoEntity getPedidoInsumo() {
		return pedidoInsumo;
	}
	
	public void setPedidoInsumo(PedidoInsumoEntity pedidoInsumo) {
		this.pedidoInsumo = pedidoInsumo;
	}
	
	public Float getPrecioCompra() {
		return precioCompra;
	}
	
	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public List<ReservaInsumoEntity> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaInsumoEntity> reservas) {
		this.reservas = reservas;
	}
	@Override
	public LoteInsumo toBO(){ return toBO(true);}
	
	@Override
	public LoteInsumo toBO(Boolean IncluyeReserva) {
		 List<ReservaInsumo> reservasBO = new ArrayList<ReservaInsumo>();
		 if(IncluyeReserva){
			 if(reservas!=null){
				 for(ReservaInsumoEntity re : reservas){
					 reservasBO.add(re.toBO());
				 }
			 }
		 }
		
		PedidoInsumo pi = null;
		Posicion pos =null;
		if(pedidoInsumo!=null) pi=pedidoInsumo.toBO(false);
		if(getPosicion()!=null) pos= getPosicion().toBO(false);
		LoteInsumo lote = new LoteInsumo(getId(),getCantidad(), getCantDisponible(),pos,insumo.toBO(),pi,precioCompra,reservasBO);
		return lote;
	}
	
}
