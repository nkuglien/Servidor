package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CuentaCorriente {

	private Long id;

	private List<MovimientoCC> movimientos;
	private float saldo;
	private float limiteCredito;

	public CuentaCorriente() {
		this.movimientos = new ArrayList<MovimientoCC>();
	}
	
	public void agregarMovimiento(Date fecha, Float importe) {
		getMovimientos().add(new MovimientoCC(fecha, importe));
	}

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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

}
