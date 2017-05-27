package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Cliente;
import model.PedidoCliente;
import model.ValorConsignacion;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cliente_id")
	private long id;

	@Column(name = "nro_legajo")
	private int nroLegajo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "cuit")
	private String cuit;

	@OneToOne(cascade = CascadeType.ALL)
	private CuentaCorrienteEntity cc;

	@Column(name = "nro_cliente")
	private long nroCliente;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CLIENTE_VALOR", joinColumns = { @JoinColumn(name = "cliente_id") }, inverseJoinColumns = {
			@JoinColumn(name = "valor_id") })
	private List<ValorConsignacionEntity> valores;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<PedidoClienteEntity> pedidos;
	
	public ClienteEntity() {
	}
	
	public ClienteEntity (Cliente cliente) {
		this.setId(cliente.getId());
		this.setNroLegajo(cliente.getNroLegajo());
		this.setNombre(cliente.getNombre());
		this.setDireccion(cliente.getDireccion());
		this.setTelefono(cliente.getTelefono());
		this.setCuit(cliente.getCuit());
		this.setCc(new CuentaCorrienteEntity(cliente.getCc()));
		this.setNroCliente(cliente.getNroCliente());
		this.setValoresEntity(cliente.getValores());
		this.setPedidosEntity(cliente.getPedidos());
	}
	
	private void setValoresEntity(List<ValorConsignacion> valores) {
		List<ValorConsignacionEntity> list = new ArrayList<ValorConsignacionEntity>();
		for(ValorConsignacion valor : valores) {
			list.add(new ValorConsignacionEntity(valor));
		}
		this.setValores(list);		
	}
	
	private void setPedidosEntity(List<PedidoCliente> pedidos) {
		List<PedidoClienteEntity> list = new ArrayList<PedidoClienteEntity>();
		for(PedidoCliente pedido : pedidos) {
			list.add(new PedidoClienteEntity(pedido));
		}
		this.setPedidos(list);		
	}
	
	public Cliente toBO() {
		Cliente cliente = new Cliente();
		cliente.setId(this.getId());
		cliente.setNroLegajo(this.getNroLegajo());
		cliente.setNombre(this.getNombre());
		cliente.setDireccion(this.getDireccion());
		cliente.setTelefono(this.getTelefono());
		cliente.setCuit(this.getCuit());
		cliente.setCc(this.getCc().toBO());
		cliente.setNroCliente(this.getNroCliente());
		cliente.setValores(toValoresBO(this.getValores()));
		cliente.setPedidos(toPedidosBO(this.getPedidos()));
		return cliente;
	}

	private List<ValorConsignacion> toValoresBO(List<ValorConsignacionEntity> valoresEntity) {
		List<ValorConsignacion> valores = new ArrayList<ValorConsignacion>();
		for (ValorConsignacionEntity valorEntity : valoresEntity) {
			valores.add(valorEntity.toBO());
		}
		return valores;
	}
	
	private List<PedidoCliente> toPedidosBO(List<PedidoClienteEntity> pedidosEntity) {
		List<PedidoCliente> pedidos = new ArrayList<PedidoCliente>();
		for (PedidoClienteEntity pedidoEntity : pedidosEntity) {
			pedidos.add(pedidoEntity.toBO());
		}
		return pedidos;
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

	public List<ValorConsignacionEntity> getValores() {
		return valores;
	}

	public void setValores(List<ValorConsignacionEntity> valores) {
		this.valores = valores;
	}

	public List<PedidoClienteEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoClienteEntity> pedidos) {
		this.pedidos = pedidos;
	}

}
