package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.ClienteDTO;
import DTO.PedidoClienteDTO;
import DTO.ValorConsignacionDTO;
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
	private boolean activo;

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

	public Cliente(ClienteDTO cliente, boolean copyInverseReferences) {
		this.setNroLegajo(cliente.getNroLegajo());
		this.setNombre(cliente.getNombre());
		this.setDireccion(cliente.getDireccion());
		this.setTelefono(cliente.getTelefono());
		this.setCuit(cliente.getCuit());
		this.setCc(new CuentaCorriente(cliente.getCc()));
		this.setNroCliente(cliente.getNroCliente());
		this.setId(cliente.getId());

		List<ValorConsignacion> valores = new ArrayList<ValorConsignacion>();
		for (ValorConsignacionDTO val : cliente.getValores()) {
			valores.add(new ValorConsignacion(val));
		}
		this.valores = valores;

		List<PedidoCliente> pedidos = new ArrayList<PedidoCliente>();
		if(copyInverseReferences) {
			for (PedidoClienteDTO ped : cliente.getPedidos()) {
				pedidos.add(new PedidoCliente(ped));
			}
		}
		this.pedidos = pedidos;
	}

	public void agregarValorConsignacion(String descripcion, float valor) {
		ValorConsignacion valorConsignacion = new ValorConsignacion(valor, descripcion);
		this.getValores().add(valorConsignacion);
		this.getCc().aumentarLimiteCredito(valor);
	}
	
	public void retirarValorConsignacion(long idValorConsignado) {
		ValorConsignacion valor = ClienteDAO.getInstance().findValorConsignacion(idValorConsignado);
		this.getValores().remove(valor);
		this.getCc().disminuirLimiteCredito(valor.getValor());
	}

	public void habilitarCuentaCorriente(float saldo, float limiteCredito) {
		this.getCc().setSaldo(saldo);
		this.getCc().setLimiteCredito(limiteCredito);
		this.getCc().save();
	}
	
	public Cliente save() {
		return ClienteDAO.getInstance().save(this);
	}
	
	public void baja() {
		ClienteDAO.getInstance().baja(this);
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

	public List<PedidoCliente> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoCliente> pedidos) {
		this.pedidos = pedidos;
	}

	public void addPedido(PedidoCliente pedido) {
		this.getPedidos().add(pedido);
	}

	public void addMovimiento(float importe) {
		this.getCc().agregarMovimiento(new Date(), importe);
	}

	public ClienteDTO toDTO() {
		ClienteDTO retorno = new ClienteDTO();
		retorno.setCuit(this.cuit);
		retorno.setDireccion(direccion);
		retorno.setId(id);
		retorno.setNombre(nombre);
		retorno.setNroCliente(nroCliente);
		retorno.setNroLegajo(nroLegajo);
		retorno.setTelefono(telefono);
		retorno.setCc(cc.toDTO());

		List<PedidoClienteDTO> pedidosList = new ArrayList<PedidoClienteDTO>();
		for (PedidoCliente pedido : pedidos) {
			pedidosList.add(pedido.toDTO());
		}
		retorno.setPedidos(pedidosList);

		List<ValorConsignacionDTO> valoresList = new ArrayList<ValorConsignacionDTO>();
		for (ValorConsignacion valor : valores) {
			valoresList.add(valor.toDTO());
		}
		retorno.setValores(valoresList);

		return retorno;

	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
