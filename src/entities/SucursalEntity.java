package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Cliente;
import model.Sucursal;

@Entity
@Table(name = "SUCURSAL")
public class SucursalEntity {

	@Id
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "horario_apertura")
	private Integer horarioApertura;
	
	@Column(name = "horario_cierre")
	private Integer horarioCierre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "activo")
	private boolean activo;
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany
	private List<ClienteEntity> clientes;
	
	public SucursalEntity() {
	}
	
	public SucursalEntity(Sucursal sucursal) {
		this.setNumero(sucursal.getNumero());
		this.setNombre(sucursal.getNombre());
		this.setHorarioApertura(sucursal.getHorarioApertura());
		this.setHorarioCierre(sucursal.getHorarioCierre());
		this.setDireccion(sucursal.getDireccion());
		this.setClientesEntity(sucursal.getClientes());
		this.setActivo(true);
	}
	
	public Sucursal toBO() {
		Sucursal sucursal = new Sucursal();
		sucursal.setNumero(this.getNumero());
		sucursal.setNombre(this.getNombre());
		sucursal.setHorarioApertura(this.getHorarioApertura());
		sucursal.setHorarioCierre(this.getHorarioCierre());
		sucursal.setDireccion(this.getDireccion());
		if(this.clientes!=null)
		sucursal.setClientes(toClientesBO(this.getClientes()));
		else
			sucursal.setClientes(new ArrayList<Cliente>());
		return sucursal;
	}
	
	private List<Cliente> toClientesBO(List<ClienteEntity> clientesEntity) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		for (ClienteEntity clienteEntity : clientesEntity) {
			clientes.add(clienteEntity.toBO());
		}
		return clientes;
	}

	private void setClientesEntity(List<Cliente> clientes) {
		List<ClienteEntity> list = new ArrayList<ClienteEntity>();
		for(Cliente cliente : clientes) {
			list.add(new ClienteEntity(cliente));
		}
		this.setClientes(list);		
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
	
	public List<ClienteEntity> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}

}
