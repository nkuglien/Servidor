package model;

public class Lote {

	private Long id;
	private Integer cantidad;
	private Integer cantDisponible;
	private Posicion posicion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantDisponible() {
		return cantDisponible;
	}

	public void setCantDisponible(Integer cantDisponible) {
		this.cantDisponible = cantDisponible;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
