package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.MovimientoCC;

@Entity
@Table (name = "MOVIMIENTO")
public class MovimientoCCEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "movimiento_id")
	private Long id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "importe")
	private Float importe;
	
	public MovimientoCCEntity() {
		
	}		
	
	public MovimientoCCEntity(MovimientoCC movimiento) {
		this.setId(movimiento.getId());
		this.setFecha(movimiento.getFecha());
		this.setImporte(movimiento.getImporte());
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

	public MovimientoCC toBO() {
		MovimientoCC movimiento = new MovimientoCC();
		movimiento.setId(this.getId());
		movimiento.setFecha(this.getFecha());
		movimiento.setImporte(this.getImporte());
		return movimiento;
	}
	
}
