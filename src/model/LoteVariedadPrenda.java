package model;

import java.util.Date;

import DTO.LoteVariedadPrendaDTO;
import dao.LoteDAO;

public class LoteVariedadPrenda extends Lote {

	private VariedadPrenda variedadPrenda;
	private OrdenProduccion ordenProduccion;
	private Date fechaProduccion;
	private Float costoProduccion;

	public LoteVariedadPrenda(Long id,Integer cantidad, Integer cantDisponible, Posicion posicion, VariedadPrenda variedadPrenda, OrdenProduccion ordenProduccion,
			Date fechaProduccion2, Float costoProduccion2) {
		
		this.setId(id);
		this.setCantDisponible(cantDisponible);
		this.setPosicion(posicion);
		this.setVariedadPrenda(variedadPrenda);
		this.setOrdenProduccion(ordenProduccion);
		this.setFechaProduccion(fechaProduccion2);
		this.setCostoProduccion(costoProduccion2);
		this.setCantidad(cantidad);
		
	}

	public LoteVariedadPrenda(VariedadPrenda vp, OrdenProduccion orden) {
		variedadPrenda=vp;
		ordenProduccion = orden;
		fechaProduccion= new Date();
		costoProduccion = vp.getCostoProduccionActual();
		setCantidad(vp.getCantidadProduccionFija());
		setCantDisponible(vp.getCantidadProduccionFija());
		
		
	}



	public LoteVariedadPrenda(LoteVariedadPrendaDTO dto) {
		variedadPrenda = new VariedadPrenda(dto.getVariedadPrenda());
		ordenProduccion = new OrdenProduccion(dto.getOrdenProduccion());
		fechaProduccion = dto.getFechaProduccion();
		costoProduccion = dto.getCostoProduccion();
	}

	public LoteVariedadPrenda() {
		// TODO Auto-generated constructor stub
	}

	public VariedadPrenda getVariedadPrenda() {
		return variedadPrenda;
	}

	public void setVariedadPrenda(VariedadPrenda variedadPrenda) {
		this.variedadPrenda = variedadPrenda;
	}

	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public Date getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	public Float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(Float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public LoteVariedadPrenda save() {
		LoteDAO lote = LoteDAO.getInstance();
		return (LoteVariedadPrenda) lote.save(this);
		// TODO Auto-generated method stub
		
	}

	public LoteVariedadPrendaDTO toDTO(){
		String pos ="";
		if(getPosicion()!= null) pos= getPosicion().getCodigo();
		
		
		LoteVariedadPrendaDTO dto = new LoteVariedadPrendaDTO(getId(),pos,getCantidad(),getCantDisponible(),getVariedadPrenda().toDTO(), getOrdenProduccion().toDTO(),fechaProduccion, costoProduccion);
		return dto;
	}
}
