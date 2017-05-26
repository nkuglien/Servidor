package entities;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AREA_PRODUCCION")
public class AreaProduccionEntity {
	
	@Id
	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Transient
	private Map<String,Boolean> lineas;
	
	@Transient
	private List<OrdenProduccionEsperaEntity> ordenesEspera;
	
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

}