package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.ValorConsignacion;

@Entity
@Table(name = "VALOR_CONSIGNACION")
public class ValorConsignacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "valor_id")
	private Long id;
	
	@Column(name = "valor")
	private Float valor;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "devuelto")
	private Boolean devuelto;
	
	public ValorConsignacionEntity() {
	}
	
	public ValorConsignacionEntity(ValorConsignacion valor) {
		this.setId(valor.getId());
		this.setValor(valor.getValor());
		this.setDescripcion(valor.getDescripcion());
		this.setFecha(valor.getFecha());
		this.setDevuelto(valor.getDevuelto());
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Float getValor() {
		return valor;
	}
	
	public void setValor(Float valor) {
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
