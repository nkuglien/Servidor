package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.EstadoPedidoCliente;
import DTO.ItemPedidoClienteDTO;
import DTO.PedidoClienteDTO;
import dao.PedidoClienteDAO;

public class PedidoCliente {
	
	private Long nroPedido;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaProbableDespacho;
	private List<ItemPedidoCliente> items;
	private Cliente cliente;
	private Float subtotal;
	private Float impuestos;
	private Float total;
	private EstadoPedidoCliente estado;
	private String nota;
	
	public PedidoCliente() {
	}
	
	public PedidoCliente(PedidoClienteDTO dto) {
		this.nroPedido = dto.getNroPedido();
		this.fechaGeneracion = dto.getFechaGeneracion();
		this.fechaDespacho = dto.getFechaDespacho();
		this.fechaProbableDespacho = dto.getFechaProbableDespacho();
		if(dto.getCliente()!=null)this.cliente = new Cliente(dto.getCliente(), false);
		this.subtotal = dto.getSubtotal();
		this.impuestos = dto.getImpuestos();
		this.total = dto.getTotal();
		this.estado = dto.getEstado();
		this.setNota(dto.getNota());
		if(dto.getItems()!=null) {
			List<ItemPedidoCliente> items = new ArrayList<ItemPedidoCliente>();
			for(ItemPedidoClienteDTO item : dto.getItems()) {
				items.add(new ItemPedidoCliente(item));
			};
			this.items = items;	
		}

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

	public List<ItemPedidoCliente> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoCliente> items) {
		this.items = items;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public PedidoClienteDTO toDTO(PedidoCliente pedido) {
		PedidoClienteDTO dto = new PedidoClienteDTO();
		dto.setNroPedido(this.nroPedido);
		dto.setFechaGeneracion(this.fechaGeneracion);
		dto.setFechaDespacho(this.fechaDespacho);
		dto.setFechaProbableDespacho(this.fechaProbableDespacho);
		dto.setCliente(this.cliente.toDTO());
		dto.setSubtotal(this.subtotal);
		dto.setImpuestos(this.impuestos);
		dto.setTotal(this.total);
		dto.setEstado(this.getEstado());
		List<ItemPedidoClienteDTO> items = new ArrayList<ItemPedidoClienteDTO>();
		for(ItemPedidoCliente item : pedido.getItems()) {
			items.add(item.toDTO());
		};
		dto.setItems(items);
		return dto;
	}

	public PedidoCliente save() {
		return PedidoClienteDAO.getInstance().save(this);		
	}

	public PedidoClienteDTO toDTO() {
		PedidoClienteDTO dto = new PedidoClienteDTO();
		if(cliente!=null)dto.setCliente(cliente.toDTO());
		dto.setEstado(estado);
		dto.setFechaDespacho(fechaDespacho);
		dto.setFechaGeneracion(fechaGeneracion);
		dto.setFechaProbableDespacho(fechaProbableDespacho);
		dto.setImpuestos(impuestos);
		dto.setNota(nota);
		dto.setNroPedido(nroPedido);
		dto.setSubtotal(subtotal);
		dto.setTotal(subtotal);
		if(this.getItems()!=null) {
			List<ItemPedidoClienteDTO> itemsDTO = new ArrayList<ItemPedidoClienteDTO>();
			for (ItemPedidoCliente item : this.items) {
				itemsDTO.add(item.toDTO());
			}
			dto.setItems(itemsDTO);
		}
		return dto;
	}

	public void intentarArmar() {
		// TODO Auto-generated method stub
		
	}
	
}
