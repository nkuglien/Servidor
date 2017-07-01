package model;

import DTO.ItemPedidoClienteDTO;

public class ItemPedidoCliente {

	private Long id;
	private VariedadPrenda item;
	private Integer cantidad;
	private Float precioItem;
	
	public ItemPedidoCliente() {
	}
	
	public ItemPedidoCliente(ItemPedidoClienteDTO item) {
		this.setId(item.getId());
		this.setItem(new VariedadPrenda(item.getItem()));
		this.setCantidad(item.getCantidad());
		this.setPrecioItem(item.getPrecioItem());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VariedadPrenda getItem() {
		return item;
	}

	public void setItem(VariedadPrenda item) {
		this.item = item;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecioItem() {
		return precioItem;
	}

	public void setPrecioItem(Float precioItem) {
		this.precioItem = precioItem;
	}
	public ItemPedidoClienteDTO toDTO() {
		ItemPedidoClienteDTO dto = new ItemPedidoClienteDTO();
		dto.setId(id);
		dto.setCantidad(cantidad);
		dto.setPrecioItem(precioItem);		
		if(item!=null)dto.setItem(item.toDTO());
		return dto;
	}
	
}
