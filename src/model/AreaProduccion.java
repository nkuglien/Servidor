package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DTO.AreaProduccionDTO;
import dao.AreaProduccionDAO;

public class AreaProduccion {

	private Integer codigo;
	private String nombre;
	private Map<String, Boolean> lineas;
	//private List<OrdenProduccionEspera> ordenesEspera;
	
	public AreaProduccion() {
		this.setLineas(new HashMap<String, Boolean>());
	}
	
	public AreaProduccion(Integer codigo, String nombre) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setLineas(new HashMap<String, Boolean>());
	}
	
	public AreaProduccion(AreaProduccionDTO area) {
		this.setCodigo(area.getCodigo());
		this.setNombre(area.getNombre());
		this.setLineas(new HashMap<String, Boolean>());
	}

	public void agregarLinea(String codigoLinea, boolean isDisponible) {
		lineas.put(codigoLinea, isDisponible);
	}
	
	public void eliminarLinea(String codigoLinea) {
		lineas.remove(codigoLinea);
	}
	
	public void cambiarEstadoLinea(String codigoLinea, boolean isDisponible) {
		lineas.put(codigoLinea, isDisponible);
	}
	
	public AreaProduccion save() {
		return AreaProduccionDAO.getInstance().save(this);
	}

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

	

	public AreaProduccionDTO toDTO() {
		AreaProduccionDTO dto = new AreaProduccionDTO();
		dto.setCodigo(getCodigo());
		dto.setNombre(getNombre());
		return dto;
	}

	public AreaProduccionDTO toDTO() {
		AreaProduccionDTO dto = new AreaProduccionDTO();
		dto.setCodigo(getCodigo());
		dto.setNombre(getNombre());
		return dto;
	}

	public AreaProduccionDTO toDTO() {
		AreaProduccionDTO dto = new AreaProduccionDTO();
		dto.setCodigo(getCodigo());
		dto.setNombre(getNombre());
		return dto;
	}

	public AreaProduccionDTO toDTO() {
		AreaProduccionDTO dto = new AreaProduccionDTO();
		dto.setCodigo(getCodigo());
		dto.setNombre(getNombre());
		return dto;
	}

}
