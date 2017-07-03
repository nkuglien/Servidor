package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.LoteVariedadPrenda;
import model.ReservaVariedadPrenda;

@Entity
@Table(name="ReservaVariedadPrenda")
public class ReservaVariedadPrendaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idPedidoCliente")
	private PedidoClienteEntity pedido;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL})
	@JoinColumn(name="idLote")
	private LoteVariedadPrendaEntity lote;
	private int cantidad;
	
	public ReservaVariedadPrendaEntity() {

	}
	
	public ReservaVariedadPrendaEntity(ReservaVariedadPrenda r) {
		id = r.getId();
		if(r.getPedido()!=null)
		pedido = new PedidoClienteEntity(r.getPedido(), false);
		if(r.getLote()!=null)
		lote = new LoteVariedadPrendaEntity(r.getLote(), false);

		cantidad = r.getCantidad();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public ReservaVariedadPrenda toBO() {
		LoteVariedadPrenda l = null;
		if(lote!=null) l  = (LoteVariedadPrenda)lote.toBO();
		ReservaVariedadPrenda r = new ReservaVariedadPrenda(pedido.toBO(false), l, cantidad);
		r.setId(id);
		return r;
	}
	
	
	
	
}
