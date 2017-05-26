package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ClienteDAO;

public class Cliente {
	
	private long id;
	private int nroLegajo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String cuit;
	private CuentaCorriente cc;
	private long nroCliente;
	private List<ValorConsignacion> valores;
	private List<PedidoCliente> pedidos;
	
	public Cliente() {
		this.setCc(new CuentaCorriente());
		this.setValores(new ArrayList<ValorConsignacion>());
		this.setPedidos(new ArrayList<PedidoCliente>());
	}
	
	public Cliente(int nroLegajo, String nombre, String direccion, String telefono, String cuit, long nroCliente) {
		this.setNroLegajo(nroLegajo);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setCuit(cuit);
		this.setCc(new CuentaCorriente());
		this.setNroCliente(nroCliente);
		this.setValores(new ArrayList<ValorConsignacion>());
		this.setPedidos(new ArrayList<PedidoCliente>());
	}

	public void save() {
		ClienteDAO.getInstance().save(this);
	}

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

	public CuentaCorriente getCc() {
		return cc;
	}

	public void setCc(CuentaCorriente cc) {
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

	public void addValor(float valor, String descripcion) {
		this.getValores().add(new ValorConsignacion(valor, descripcion));
	}
	
	public List<PedidoCliente> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoCliente> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(PedidoCliente pedido) {
		this.getPedidos().add(pedido);
	}
	
	public void addMovimiento(Date fecha, float importe) {
		this.getCc().agregarMovimiento(fecha, importe);
	}
}
