package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ReservaVariedadPrenda")
public class ReservaVariedadPrendaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="idPedidoCliente")
	private PedidoClienteEntity pedido;
	@ManyToOne
	@JoinColumn(name="idLote")
	private LoteVariedadPrendaEntity lote;
	private int cantidad;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PedidoClienteEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoClienteEntity pedido) {
		this.pedido = pedido;
	}
	public LoteVariedadPrendaEntity getLote() {
		return lote;
	}
	public void setLote(LoteVariedadPrendaEntity lote) {
		this.lote = lote;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
