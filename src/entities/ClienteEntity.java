package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Cliente")
public class ClienteEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private int nroLegajo;
private String nombre;
private String direccion;
private String telefono;
private String cuit;
@OneToMany
@JoinColumn(name="idCliente")
private CuentaCorrienteEntity cc;
private long nroCliente;
@Transient
private List<ValorConsignacion> valores;
@Transient
private List<PedidoCliente> pedidos;


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getNroLegajo() {
	return nroLegajo;
}
public void setNroLegajo(int nroLegajo) {
	this.nroLegajo = nroLegajo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getCuit() {
	return cuit;
}
public void setCuit(String cuit) {
	this.cuit = cuit;
}
public CuentaCorrienteEntity getCc() {
	return cc;
}
public void setCc(CuentaCorrienteEntity cc) {
	this.cc = cc;
}
public long getNroCliente() {
	return nroCliente;
}
public void setNroCliente(long nroCliente) {
	this.nroCliente = nroCliente;
}
public List<ValorConsignacion> getValores() {
	return valores;
}
public void setValores(List<ValorConsignacion> valores) {
	this.valores = valores;
}
public List<PedidoCliente> getPedidos() {
	return pedidos;
}
public void setPedidos(List<PedidoCliente> pedidos) {
	this.pedidos = pedidos;
}


}
