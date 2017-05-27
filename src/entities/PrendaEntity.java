package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRENDA")
public class PrendaEntity {

	@Id
	@Column(name = "codigo")
	private Long codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "enProduccion")
	private Boolean enProduccion;
	
	@OneToMany
	private List<VariedadPrendaEntity> variedades;
	
	@OneToMany
	private List<PrendaAreaProduccionEntity> areas;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Boolean getEnProduccion() {
		return enProduccion;
	}
	
	public void setEnProduccion(Boolean enProduccion) {
		this.enProduccion = enProduccion;
	}
	
	public List<VariedadPrendaEntity> getVariedades() {
		return variedades;
	}
	
	public void setVariedades(List<VariedadPrendaEntity> variedades) {
		this.variedades = variedades;
	}
	
	public List<PrendaAreaProduccionEntity> getAreas() {
		return areas;
	}
	
	public void setAreas(List<PrendaAreaProduccionEntity> areas) {
		this.areas = areas;
	}
	
}
