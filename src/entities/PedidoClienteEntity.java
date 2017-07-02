package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import DTO.EstadoPedidoCliente;
import model.Cliente;
import model.CuentaCorriente;
import model.ItemPedidoCliente;
import model.PedidoCliente;
import model.ReservaVariedadPrenda;
import model.ValorConsignacion;

@Entity
@Table(name = "PEDIDO_CLIENTE")
public class PedidoClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_pedido")
	private Long nroPedido;

	@Column(name = "fecha_generacion")
	private Date fechaGeneracion;

	@Column(name = "fecha_despacho")
	private Date fechaDespacho;

	@Column(name = "fecha_probable_despacho")
	private Date fechaProbableDespacho;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemPedidoClienteEntity> items;

	@ManyToOne
    @JoinColumn(name = "cliente_id")
	private ClienteEntity cliente;

	@Column(name = "subtotal")
	private Float subtotal;

	@Column(name = "impuestos")
	private Float impuestos;

	@Column(name = "total")
	private Float total;
	
	@Column(name="estado") 
	@Enumerated(EnumType.STRING) 
	private EstadoPedidoCliente estado;
	
	@Column(name = "nota")
	private String nota;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idPedidoCliente")
	private List<ReservaVariedadPrendaEntity> reservas;
	
	
	
	
	public PedidoClienteEntity() {
		reservas = new ArrayList<>();
	}
	
	public PedidoClienteEntity(PedidoCliente pedido, boolean copyInverseReferences) {
		this.setNroPedido(pedido.getNroPedido());
		this.setFechaGeneracion(pedido.getFechaGeneracion());
		this.setFechaDespacho(pedido.getFechaDespacho());
		this.setFechaProbableDespacho(pedido.getFechaProbableDespacho());
		
		if(copyInverseReferences) {
			Cliente cliente = pedido.getCliente();
			if(cliente!=null){
				cliente.setCc(new CuentaCorriente());
				cliente.setValores(new ArrayList<ValorConsignacion>());
				cliente.setPedidos(new ArrayList<PedidoCliente>());
				this.setCliente(new ClienteEntity(cliente));
			}
			
			List<ReservaVariedadPrendaEntity> reservasE = new ArrayList<ReservaVariedadPrendaEntity>();
			for(ReservaVariedadPrenda r : pedido.getReservas()) {
				reservasE.add(new ReservaVariedadPrendaEntity(r));
			}
			this.setReservas(reservasE);
		}

		
		if(pedido.getItems()!=null) this.setItemsEntity(pedido.getItems());
		this.setSubtotal(pedido.getSubtotal());
		this.setImpuestos(pedido.getImpuestos());
		this.setTotal(pedido.getTotal());
		this.setEstado(pedido.getEstado());
		this.setNota(pedido.getNota());
	}
	
	public PedidoCliente toBO(boolean copyInverseReferences) {
		PedidoCliente pedidoCliente = new PedidoCliente();
		pedidoCliente.setNroPedido(this.getNroPedido());
		pedidoCliente.setFechaGeneracion(this.getFechaGeneracion());
		pedidoCliente.setFechaDespacho(this.getFechaDespacho());
		pedidoCliente.setFechaProbableDespacho(this.getFechaProbableDespacho());
		if(this.getItems()!=null)pedidoCliente.setItems(toItemsBO(this.getItems(), copyInverseReferences));
		if(copyInverseReferences && this.getCliente()!=null) {
			pedidoCliente.setCliente(this.getCliente().toBO());
		}
		if(copyInverseReferences) {
			List<ReservaVariedadPrenda> reservas = new ArrayList<ReservaVariedadPrenda>();
			for(ReservaVariedadPrendaEntity r : this.getReservas()) {
				reservas.add(r.toBO());
			}
			pedidoCliente.setReservas(reservas);
		}
		pedidoCliente.setSubtotal(this.getSubtotal());
		pedidoCliente.setImpuestos(this.getImpuestos());
		pedidoCliente.setTotal(this.getTotal());
		pedidoCliente.setEstado(this.getEstado());
		pedidoCliente.setNota(this.getNota());

		return pedidoCliente;
	}
	
	private void setItemsEntity(List<ItemPedidoCliente> items) {
		List<ItemPedidoClienteEntity> list = new ArrayList<>();
		for(ItemPedidoCliente item : items) {
			list.add(new ItemPedidoClienteEntity(item));
		}
		this.setItems(list);		
	}
	
	private List<ItemPedidoCliente> toItemsBO(List<ItemPedidoClienteEntity> items, boolean copyInverseReferences) {
		List<ItemPedidoCliente> itemsPedido = new ArrayList<>();
		for (ItemPedidoClienteEntity item : items) {
			itemsPedido.add(item.toBO(copyInverseReferences));
		}
		return itemsPedido;
	}

	public Long getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(Long nroPedido) {
		this.nroPedido = nroPedido;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public List<ItemPedidoClienteEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoClienteEntity> items) {
		this.items = items;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Float impuestos) {
		this.impuestos = impuestos;
	}

	public Float getTotal() {

		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	public EstadoPedidoCliente getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedidoCliente estado) {
		this.estado = estado;
	}
	
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public List<ReservaVariedadPrendaEntity> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaVariedadPrendaEntity> reservas) {
		this.reservas = reservas;
	}

}
