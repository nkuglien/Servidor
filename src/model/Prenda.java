package model;

import java.util.List;

public class Prenda {

	private Long codigo;
	private String descripcion;
	private Boolean enProduccion;
	private List<VariedadPrenda> variedades;
	private List<PrendaAreaProduccion> areas;

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

	public List<VariedadPrenda> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<VariedadPrenda> variedades) {
		this.variedades = variedades;
	}

	public List<PrendaAreaProduccion> getAreas() {
		return areas;
	}

	public void setAreas(List<PrendaAreaProduccion> areas) {
		this.areas = areas;
	}

}
