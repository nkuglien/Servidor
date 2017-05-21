package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CuentaCorriente")
public class CuentaCorrienteEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<MovimientoCC> movimientos;
	private Float saldo;
	private Float limiteCredito;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<MovimientoCC> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<MovimientoCC> movimientos) {
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
