package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.CuentaCorriente;
import model.MovimientoCC;

@Entity
@Table (name = "CUENTA_CORRIENTE")
public class CuentaCorrienteEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "cuenta_id")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUENTA_MOVIMIENTO", joinColumns = { @JoinColumn(name = "cuenta_id") }, inverseJoinColumns = {
			@JoinColumn(name = "movimiento_id") })
	private List<MovimientoCCEntity> movimientos;
	
	@Column(name = "saldo")
	private Float saldo;
	
	@Column(name = "limite_credito")
	private Float limiteCredito;
	
	public CuentaCorrienteEntity() {		
	}
	
	public CuentaCorrienteEntity(CuentaCorriente cc) {
		this.setId(cc.getId());
		this.setMovimientosEntity(cc.getMovimientos());
		this.setSaldo(cc.getSaldo());
		this.setLimiteCredito(cc.getLimiteCredito());
	}
	
	public void setMovimientosEntity(List<MovimientoCC> movimientos) {
		List<MovimientoCCEntity> list = new ArrayList<MovimientoCCEntity>();
		for(MovimientoCC movimiento : movimientos) {
			list.add(new MovimientoCCEntity(movimiento));
		}
		this.setMovimientos(list);
	}
	
	public CuentaCorriente toBO() {
		CuentaCorriente cc = new CuentaCorriente();
		cc.setId(this.getId());
		cc.setMovimientos(toMovimientosBO(this.getMovimientos()));
		cc.setSaldo(this.getSaldo());
		cc.setLimiteCredito(this.getLimiteCredito());
		return cc;
	}

	private List<MovimientoCC> toMovimientosBO(List<MovimientoCCEntity> movimientosEntity) {
		List<MovimientoCC> movimientos = new ArrayList<MovimientoCC>();
		for (MovimientoCCEntity movimientoEntity : movimientosEntity) {
			movimientos.add(movimientoEntity.toBO());
		}
		return movimientos;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<MovimientoCCEntity> getMovimientos() {
		return movimientos;
	}
	
	public void setMovimientos(List<MovimientoCCEntity> movimientos) {
		this.movimientos = movimientos;
	}
	
	public Float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	
	public Float getLimiteCredito() {
		return limiteCredito;
	}
	
	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
}
