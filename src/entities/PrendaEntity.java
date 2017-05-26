package entities;

import java.util.List;

public class PrendaEntity {

	private Long codigo;
	private String descripcion;
	private Boolean enProduccion;
	private List<VariedadPrendaEntity> variedades;
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
