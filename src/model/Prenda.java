package model;

import java.util.ArrayList;
import java.util.List;

import dao.PrendaDAO;

public class Prenda {

	private Long codigo;
	private String descripcion;
	private Boolean enProduccion;
	private List<VariedadPrenda> variedades;
	private List<PrendaAreaProduccion> areas;
	
	public Prenda() {
		this.setVariedades(new ArrayList<VariedadPrenda>());
		this.setAreas(new ArrayList<PrendaAreaProduccion>());
	}
	
	public Prenda(Long codigo, String descripcion, Boolean enProduccion) {
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setEnProduccion(enProduccion);
		this.setVariedades(new ArrayList<VariedadPrenda>());
		this.setAreas(new ArrayList<PrendaAreaProduccion>());
	}
	
	public Prenda save() {
		return PrendaDAO.getInstance().save(this);
	}
	
	public void agregarVariedad(VariedadPrenda variedad) {
		this.getVariedades().add(variedad);
	}
	
	public void agregarArea(AreaProduccion area, Integer tiempo) {
		PrendaAreaProduccion prendaArea = new PrendaAreaProduccion(area, tiempo);
		this.getAreas().add(prendaArea);
	}

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
