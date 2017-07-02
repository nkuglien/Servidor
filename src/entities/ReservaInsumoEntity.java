package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.ReservaInsumo;

@Entity
@Table(name="ReservaInsumo")
public class ReservaInsumoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="idOrdenProduccion")
	private OrdenProduccionEntity orden;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL})
	@JoinColumn(name="idLote")
	private LoteInsumoEntity loteInsumo;
	
	private int cantidad;
	
	public ReservaInsumoEntity(){}
	
	public ReservaInsumoEntity(ReservaInsumo p) {
		if(p.getOrden()!=null)
			setOrden(new OrdenProduccionEntity(p.getOrden()));
		if(p.getLoteInsumo()!=null)
			setLoteInsumo(new LoteInsumoEntity(p.getLoteInsumo(),true));
		setCantidad(p.getCantidad());
		setId(p.getId());
	}
	public OrdenProduccionEntity getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccionEntity orden) {
		this.orden = orden;
	}
	public LoteInsumoEntity getLoteInsumo() {
		return loteInsumo;
	}
	public void setLoteInsumo(LoteInsumoEntity loteInsumo) {
		this.loteInsumo = loteInsumo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ReservaInsumo toBO() {	
		
		ReservaInsumo re = new ReservaInsumo(id,orden.toBO(false), loteInsumo.toBO(false), cantidad);
		return re;
	}
	
	
	
}
