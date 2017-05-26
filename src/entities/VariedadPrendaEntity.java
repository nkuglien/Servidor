package entities;

import java.util.List;

public class VariedadPrendaEntity {

	private Long id;
	private PrendaEntity prenda;
	private String talle;
	private String color;
	private Boolean enProduccion;
	private List<ItemInsumoEntity> insumos;
	private Integer cantidadProduccionFija;
	private Float costoProduccionActual;
	private Float precioVentaActual;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PrendaEntity getPrenda() {
		return prenda;
	}
	
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
	public String getTalle() {
		return talle;
	}
	
	public void setTalle(String talle) {
		this.talle = talle;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Boolean getEnProduccion() {
		return enProduccion;
	}
	
	public void setEnProduccion(Boolean enProduccion) {
		this.enProduccion = enProduccion;
	}
	
	public List<ItemInsumoEntity> getInsumos() {
		return insumos;
	}
	
	public void setInsumos(List<ItemInsumoEntity> insumos) {
		this.insumos = insumos;
	}
	
	public Integer getCantidadProduccionFija() {
		return cantidadProduccionFija;
	}
	
	public void setCantidadProduccionFija(Integer cantidadProduccionFija) {
		this.cantidadProduccionFija = cantidadProduccionFija;
	}
	
	public Float getCostoProduccionActual() {
		return costoProduccionActual;
	}
	
	public void setCostoProduccionActual(Float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}
	
	public Float getPrecioVentaActual() {
		return precioVentaActual;
	}
	
	public void setPrecioVentaActual(Float precioVentaActual) {
		this.precioVentaActual = precioVentaActual;
	}
	
}
