package entities;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.AreaProduccion;

@Entity
@Table(name = "AREA_PRODUCCION")
public class AreaProduccionEntity {
	
	@Id
	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ElementCollection
    @MapKeyColumn(name = "linea_id")
    @Column(name = "disponible")
    @CollectionTable(name = "areas_produccion_lineas", joinColumns = { @JoinColumn(name = "codigo") })
	private Map<String, Boolean> lineas;
	
	@Transient
	private List<OrdenProduccionEsperaEntity> ordenesEspera;
	
	public AreaProduccionEntity() {
	}
	
	public AreaProduccionEntity(AreaProduccion area) {
		this.setCodigo(area.getCodigo());
		this.setNombre(area.getNombre());
		this.setLineas(area.getLineas());
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Map<String, Boolean> getLineas() {
		return lineas;
	}
	
	public void setLineas(Map<String, Boolean> lineas) {
		this.lineas = lineas;
	}
	
	public List<OrdenProduccionEsperaEntity> getOrdenesEspera() {
		return ordenesEspera;
	}
	
	public void setOrdenesEspera(List<OrdenProduccionEsperaEntity> ordenesEspera) {
		this.ordenesEspera = ordenesEspera;
	}

	public AreaProduccion toBO() {
		AreaProduccion area = new AreaProduccion();
		area.setCodigo(this.getCodigo());
		area.setNombre(this.getNombre());
		area.setLineas(this.getLineas());
		return area;
	}

}
