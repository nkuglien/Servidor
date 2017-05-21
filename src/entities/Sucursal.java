package entities;

import java.util.List;

public class Sucursal {

	private Integer numero;
	private String nombre;
	private Integer horarioApertura;
	private Integer horarioCierre;
	private String direccion;
	private List<ClienteEntity> clientes;
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(Integer horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public Integer getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(Integer horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<ClienteEntity> getClientes() {
		return clientes;
	}
	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}
	
	
}
