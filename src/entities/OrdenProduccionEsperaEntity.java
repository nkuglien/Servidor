package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDEN_PRODUCCION_ESPERA")
public class OrdenProduccionEsperaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orden_produccion_espera_id")
	private Long id;
	
	private OrdenProduccionEntity ordenProduccion;
	
	@Column(name = "posicion")
	private String posicion;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public OrdenProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}
	
	public void setOrdenProduccion(OrdenProduccionEntity ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
	public String getPosicion() {
		return posicion;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
}
