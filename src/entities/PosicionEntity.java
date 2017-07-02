package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Lote;
import model.LoteInsumo;
import model.LoteVariedadPrenda;
import model.Posicion;

@Entity
@Table(name="Posicion")
public class PosicionEntity {

	@Id
	private String codigo;
	private Boolean libre;
	@OneToOne	
	@JoinColumn(name="lote")
	private LoteEntity lote;
	
	
	
	public PosicionEntity(Posicion posicion) {
		if(posicion.getLote()!=null){
			if(posicion.getLote() instanceof LoteInsumo)
			setLote(new LoteInsumoEntity((LoteInsumo)posicion.getLote(),true,false));
			if(posicion.getLote() instanceof LoteVariedadPrenda)
				setLote(new LoteVariedadPrendaEntity((LoteVariedadPrenda)posicion.getLote(), false));			
		}
		setCodigo(posicion.getCodigo());
		setLibre(posicion.getLibre());
	}
	
	public PosicionEntity() {

	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Boolean getLibre() {
		return libre;
	}
	
	public void setLibre(Boolean libre) {
		this.libre = libre;
	}
	
	public LoteEntity getLote() {
		return lote;
	}
	
	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}

	public Posicion toBO() {
		
		return toBO(true);
	}
	
public Posicion toBO(Boolean IncluyeLote) {
		
		if(IncluyeLote && getLote()!=null){
			Lote loteBO =getLote().toBO();
			return new Posicion(codigo,libre,loteBO);
		}
		else
		return new Posicion(codigo,libre);
	}
	
}
