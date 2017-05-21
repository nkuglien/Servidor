package model;

public class OrdenProduccionEspera {

	private Long id;
	private OrdenProduccion ordenProduccion;
	private String posicion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
}
