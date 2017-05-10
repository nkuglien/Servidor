package entities;

import java.util.List;
import java.util.Map;

public class AreaProduccion {
	private int codigo;
	private String nombre;
	private Map<String,Boolean> lineas;
	private List<OrdenProduccionEspera> ordenesEspera;
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
	public List<OrdenProduccionEspera> getOrdenesEspera() {
		return ordenesEspera;
	}
	public void setOrdenesEspera(List<OrdenProduccionEspera> ordenesEspera) {
		this.ordenesEspera = ordenesEspera;
	}

}
