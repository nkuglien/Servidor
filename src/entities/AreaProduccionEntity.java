package entities;

import java.util.List;
import java.util.Map;

public class AreaProduccionEntity {
	
	private int codigo;
	private String nombre;
	private Map<String,Boolean> lineas;
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
