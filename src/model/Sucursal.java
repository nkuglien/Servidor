package model;

import java.util.ArrayList;
import java.util.List;

import DTO.SucursalDTO;
import dao.SucursalDAO;

public class Sucursal {

	private Integer numero;
	private String nombre;
	private Integer horarioApertura;
	private Integer horarioCierre;
	private String direccion;
	private List<Cliente> clientes;
	private boolean activo;
	
	public Sucursal () {
		this.clientes = new ArrayList<Cliente>();
	}
	
	public Sucursal(SucursalDTO sucursal) {
		this.setNumero(sucursal.getNumero());
		this.setNombre(sucursal.getNombre());
		this.setHorarioApertura(sucursal.getHorarioApertura());
		this.setHorarioCierre(sucursal.getHorarioCierre());
		this.setDireccion(sucursal.getDireccion());
		this.setClientes(new ArrayList<Cliente>());
	}

	public Sucursal save() {
		return SucursalDAO.getInstance().save(this);
	}
	
	public void altaCliente(Cliente cliente) {
		this.getClientes().add(cliente);
	}
	
	public void baja() {
		SucursalDAO.getInstance().baja(this.getNumero());
	}

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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public SucursalDTO toDTO() {
		return new SucursalDTO(this.numero,this.nombre,this.horarioApertura,this.horarioCierre,this.direccion);
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
