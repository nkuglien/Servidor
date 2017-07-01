package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Lote;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "LOTE")
public class LoteEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer cantidad;
	private Integer cantDisponible;
	@OneToOne(mappedBy="lote")
	private PosicionEntity posicion;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCantDisponible() {
		return cantDisponible;
	}
	
	public void setCantDisponible(Integer cantDisponible) {
		this.cantDisponible = cantDisponible;
	}

	public PosicionEntity getPosicion() {
		return posicion;
	}

	public void setPosicion(PosicionEntity posicion) {
		this.posicion = posicion;
	}
	public Lote toBO(Boolean IncluyeReserva) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Lote toBO() {
		
		return toBO(true);
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
