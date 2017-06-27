package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.ItemPedidoCliente;

@Entity
@Table(name = "ITEM_PEDIDO_CLIENTE")
public class ItemPedidoClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_pedido_id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "variedad_id")
	private VariedadPrendaEntity item;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "precio_item")
	private Float precioItem;
	
	public ItemPedidoClienteEntity() {
	}
	
	public ItemPedidoClienteEntity(ItemPedidoCliente item) {
		this.setId(item.getId());
		if(item.getItem()!=null)this.setItem(new VariedadPrendaEntity(item.getItem(), true));
		this.setCantidad(item.getCantidad());
		this.setPrecioItem(item.getPrecioItem());
	}

	public ItemPedidoCliente toBO(boolean copyInverseReferences) {
		ItemPedidoCliente itemPedido = new ItemPedidoCliente();
		itemPedido.setId(this.getId());
		if(this.getItem()!=null)itemPedido.setItem(this.getItem().toBO(copyInverseReferences));
		itemPedido.setCantidad(this.getCantidad());
		itemPedido.setPrecioItem(this.getPrecioItem());
		return itemPedido;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public VariedadPrendaEntity getItem() {
		return item;
	}
	
	public void setItem(VariedadPrendaEntity item) {
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
	
}
