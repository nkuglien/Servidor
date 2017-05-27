package model;

import java.util.Date;

public class ValorConsignacion {

	private Long id;
	private float valor;
	private String descripcion;
	private Date fecha;
	private Boolean devuelto;
	
	public ValorConsignacion () {
	}
	
	public ValorConsignacion (float valor, String descripcion) {
		this.setValor(valor);
		this.setDescripcion(descripcion);
		this.setFecha(new Date());
		this.setDevuelto(false);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getDevuelto() {
		return devuelto;
	}

	public void setDevuelto(Boolean devuelto) {
		this.devuelto = devuelto;
	}

}
