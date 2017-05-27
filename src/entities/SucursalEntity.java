package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany
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
