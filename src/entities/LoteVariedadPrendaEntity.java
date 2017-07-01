package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import controllers.OrdenProduccionController;
import model.Lote;
import model.LoteInsumo;
import model.LoteVariedadPrenda;
import model.OrdenProduccion;
import model.PedidoInsumo;
import model.ReservaInsumo;
@Entity
@Table(name="LoteVariedad")
public class LoteVariedadPrendaEntity extends LoteEntity {

	@ManyToOne(cascade=CascadeType.ALL)
	private VariedadPrendaEntity variedadPrenda;
	@ManyToOne
	private OrdenProduccionEntity ordenProduccion;
	private Date fechaProduccion;
	private Float costoProduccion;
	@OneToMany
	@JoinColumn(name="idLote")
	private List<ReservaVariedadPrendaEntity> reservas;
	
	public LoteVariedadPrendaEntity(){};
	
	public LoteVariedadPrendaEntity(LoteVariedadPrenda lote) {
		if(lote.getVariedadPrenda()!=null)
			setVariedadPrenda(new VariedadPrendaEntity(lote.getVariedadPrenda(),true));
		if(lote.getOrdenProduccion()!=null)
			setOrdenProduccion(new OrdenProduccionEntity(lote.getOrdenProduccion()));
		setFechaProduccion(lote.getFechaProduccion());
		setCostoProduccion(lote.getCostoProduccion());
		setCantDisponible(lote.getCantDisponible());
		setId(lote.getId());
		if(lote.getPosicion()!=null)
			setPosicion(new PosicionEntity(lote.getPosicion()));
		setCantidad(lote.getCantidad());
	}

	public VariedadPrendaEntity getVariedadPrenda() {
		return variedadPrenda;
	}
	
	public void setVariedadPrenda(VariedadPrendaEntity variedadPrenda) {
		this.variedadPrenda = variedadPrenda;
	}
	
	public OrdenProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}
	
	public void setOrdenProduccion(OrdenProduccionEntity ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
	public Date getFechaProduccion() {
		return fechaProduccion;
	}
	
	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}
	
	public Float getCostoProduccion() {
		return costoProduccion;
	}
	
	public void setCostoProduccion(Float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	@Override
	public Lote toBO(){
		return toBO(true);
	}
	@Override
	public Lote toBO(Boolean IncluyeReserva){
		OrdenProduccion op = null;
		if(ordenProduccion!=null) op=ordenProduccion.toBO();
		LoteVariedadPrenda lote = new LoteVariedadPrenda(getId(),getCantidad() ,getCantDisponible(),getPosicion().toBO(false),variedadPrenda.toBO(false),op,fechaProduccion,costoProduccion);
		return lote;
	}
	
	
}
