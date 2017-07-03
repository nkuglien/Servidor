package model;

import java.util.Date;

import DTO.FacturaDTO;
import dao.FacturaDAO;

public class Factura {
	
	private Integer nroFactura;
	private PedidoCliente pedidoCliente;
	private Date fechaGeneracion;
	
	public Factura() {
	}
	
	public Factura(FacturaDTO dto) {
		this.setNroFactura(dto.getNroFactura());
		this.setPedidoCliente(new PedidoCliente(dto.getPedidoCliente()));
		this.setFechaGeneracion(dto.getFechaGeneracion());
	}
	
	public FacturaDTO toDTO() {
		FacturaDTO dto = new FacturaDTO();
		dto.setNroFactura(this.getNroFactura());
		dto.setPedidoCliente(this.getPedidoCliente().toDTO());
		dto.setFechaGeneracion(this.getFechaGeneracion());
		return dto;
	}
	
	public Factura save() {
		return FacturaDAO.getInstance().save(this);
	}

	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
	}

	public PedidoCliente getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

}
