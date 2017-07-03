package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Factura;

@Entity
@Table(name = "FACTURA")
public class FacturaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nro_factura")
	private Integer nroFactura;
	
	@OneToOne
	private PedidoClienteEntity pedidoCliente;
	
	@Column(name = "fecha_generacion")
	private Date fechaGeneracion;
	
	public FacturaEntity() {
	}
	
	public FacturaEntity (Factura factura) {
		this.setNroFactura(factura.getNroFactura());
		this.setPedidoCliente(new PedidoClienteEntity(factura.getPedidoCliente(), true));
		this.setFechaGeneracion(factura.getFechaGeneracion());
	}
	
	public Factura toBO() {
		Factura factura = new Factura();
		factura.setNroFactura(this.getNroFactura());
		factura.setPedidoCliente(this.getPedidoCliente().toBO(true));
		factura.setFechaGeneracion(this.getFechaGeneracion());
		return factura;
	}
	
	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
	}

	public PedidoClienteEntity getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(PedidoClienteEntity pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

}
