package entities;

import java.util.Date;

public class LoteVariedadPrendaEntity extends LoteEntity {

	private VariedadPrendaEntity variedadPrenda;
	private OrdenProduccionEntity ordenProduccion;
	private Date fechaProduccion;
	private Float costoProduccion;
	
	public VariedadPrendaEntity getVariedadPrenda() {
		return variedadPrenda;
	}
	
	public void setVariedadPrenda(VariedadPrendaEntity variedadPrenda) {
		this.variedadPrenda = variedadPrenda;
	}
	
	public OrdenProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}
	
	public void setOrdenProduccion(OrdenProduccionEntity ordenProduccion) {
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
