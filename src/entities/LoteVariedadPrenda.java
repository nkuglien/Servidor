package entities;

import java.util.Date;

public class LoteVariedadPrenda extends Lote {

	private VariedadPrenda variedadPrenda;
	private OrdenProduccion ordenProduccion;
	private Date fechaProduccion;
	private Float costoProduccion;
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
	
	
}
