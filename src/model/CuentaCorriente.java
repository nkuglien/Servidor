package model;

import java.util.List;
public class CuentaCorriente {
	private Long id;
	
	private List<MovimientoCC> movimientos;
	private Float saldo;
	private Float limiteCredito;
	private Cliente cliente;
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
