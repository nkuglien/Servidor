package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.PrendaAreaProduccion;

@Entity
@Table(name = "PRENDA_AREA_PRODUCCION")
public class PrendaAreaProduccionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prenda_area_produccion_id")
	private Long id;
	
	@ManyToOne
	private AreaProduccionEntity area;
	
	@Column(name = "tiempo")
	private Integer tiempo;
	
	public PrendaAreaProduccionEntity() {
	}
	
	public PrendaAreaProduccionEntity(PrendaAreaProduccion area) {
		this.setId(area.getId());
		this.setArea(new AreaProduccionEntity(area.getArea()));
		this.setTiempo(area.getTiempo());
	}
	
	public PrendaAreaProduccion toBO() {
		PrendaAreaProduccion prendaArea = new PrendaAreaProduccion();
		prendaArea.setId(this.getId());
		prendaArea.setArea(this.getArea().toBO());
		prendaArea.setTiempo(this.getTiempo());		
		return prendaArea;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public AreaProduccionEntity getArea() {
		return area;
	}
	
	public void setArea(AreaProduccionEntity area) {
		this.area = area;
	}
	
	public Integer getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

}
