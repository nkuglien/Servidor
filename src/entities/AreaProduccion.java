package entities;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="AreaProduccion")
public class AreaProduccion {
	
	
	@Id
	@Column
	private Integer idAreaProduccion;
	@Column
	private Integer codigo;
	private String nombre;
	@Transient
	private Map<String,Boolean> lineas;
	@Transient
	private List<OrdenProduccionEspera> ordenesEspera;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
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
	public List<OrdenProduccionEspera> getOrdenesEspera() {
		return ordenesEspera;
	}
	public void setOrdenesEspera(List<OrdenProduccionEspera> ordenesEspera) {
		this.ordenesEspera = ordenesEspera;
	}

}
