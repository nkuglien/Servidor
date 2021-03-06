package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Prenda;
import model.PrendaAreaProduccion;
import model.VariedadPrenda;

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
	
	@OneToMany(mappedBy = "prenda")
	private List<VariedadPrendaEntity> variedades;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PRENDA_PRENDA_AREA_PRODUCCION", joinColumns = { @JoinColumn(name = "codigo") }, inverseJoinColumns = {
			@JoinColumn(name = "prenda_area_produccion_id") })
	private List<PrendaAreaProduccionEntity> areas;
	
	public PrendaEntity() {
		this.setVariedades(new ArrayList<VariedadPrendaEntity>());
		this.setAreas(new ArrayList<PrendaAreaProduccionEntity>());
	}
	
	public PrendaEntity(Prenda prenda, boolean copyInverseReferences) {
		this.setCodigo(prenda.getCodigo());
		this.setDescripcion(prenda.getDescripcion());
		this.setEnProduccion(prenda.getEnProduccion());
		if (copyInverseReferences) {
			this.setVariedadesEntity(prenda.getVariedades());
		} else {
			this.setVariedadesEntity(new ArrayList<>());
		}
		this.setAreasProduccionEntity(prenda.getAreas());
	}
	
	private void setVariedadesEntity(List<VariedadPrenda> variedades) {
		List<VariedadPrendaEntity> list = new ArrayList<VariedadPrendaEntity>();
		for(VariedadPrenda variedad : variedades) {
			list.add(new VariedadPrendaEntity(variedad, false));
		}
		this.setVariedades(list);		
	}
	
	private void setAreasProduccionEntity(List<PrendaAreaProduccion> areas) {
		List<PrendaAreaProduccionEntity> list = new ArrayList<PrendaAreaProduccionEntity>();
		for(PrendaAreaProduccion area : areas) {
			list.add(new PrendaAreaProduccionEntity(area));
		}
		this.setAreas(list);		
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

	public Prenda toBO() {
		Prenda prenda = new Prenda();
		prenda.setCodigo(this.getCodigo());
		prenda.setDescripcion(this.getDescripcion());
		prenda.setEnProduccion(this.getEnProduccion());
		prenda.setVariedades(toVariedadesBO(this.getVariedades()));
		prenda.setAreas(toAreasBO(this.getAreas()));
		return prenda;
	}
	
	private List<VariedadPrenda> toVariedadesBO(List<VariedadPrendaEntity> variedadesEntity) {
		List<VariedadPrenda> variedades = new ArrayList<VariedadPrenda>();
		for (VariedadPrendaEntity variedadEntity : variedadesEntity) {
			variedades.add(variedadEntity.toBO(false));
		}
		return variedades;
	}
	
	private List<PrendaAreaProduccion> toAreasBO(List<PrendaAreaProduccionEntity> areasEntity) {
		List<PrendaAreaProduccion> areas = new ArrayList<PrendaAreaProduccion>();
		for (PrendaAreaProduccionEntity areaEntity : areasEntity) {
			areas.add(areaEntity.toBO());
		}
		return areas;
	}
	
}
