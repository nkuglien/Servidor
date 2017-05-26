package entities;

public class OrdenProduccionEsperaEntity {

	private Long id;
	private OrdenProduccionEntity ordenProduccion;
	private String posicion;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public OrdenProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}
	
	public void setOrdenProduccion(OrdenProduccionEntity ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
	public String getPosicion() {
		return posicion;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
}
