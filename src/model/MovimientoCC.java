package model;

import java.util.Date;

import DTO.MovimientoCCDTO;

public class MovimientoCC {

	private Long id;
	private Date fecha;
	private Float importe;
	
	public MovimientoCC() {
	}

	public MovimientoCC(Date fecha, Float importe) {
		this.fecha = fecha;
		this.importe = importe;
	}
	
	public MovimientoCC(MovimientoCCDTO movCCDTO) {
		this.fecha = movCCDTO.getFecha();
		this.importe = movCCDTO.getImporte();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public MovimientoCCDTO toDTO() {
		MovimientoCCDTO dto = new MovimientoCCDTO();
		dto.setFecha(fecha);
		dto.setId(id);
		dto.setImporte(importe);
		return dto;
	}

}
