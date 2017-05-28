package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.CuentaCorrienteDTO;
import DTO.MovimientoCCDTO;
import dao.ClienteDAO;

public class CuentaCorriente {

	private Long id;

	private List<MovimientoCC> movimientos;
	private float saldo;
	private float limiteCredito;

	public CuentaCorriente() {
		this.movimientos = new ArrayList<MovimientoCC>();
	}
	
	public CuentaCorriente(CuentaCorrienteDTO cc) {
		this.saldo = cc.getSaldo();
		this.limiteCredito = cc.getLimiteCredito();
		List<MovimientoCC> movCC = new ArrayList<MovimientoCC>();
		for(MovimientoCCDTO mov : cc.getMovimientos()) movCC.add(new MovimientoCC(mov));
		this.movimientos = movCC;
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
	
	public CuentaCorrienteDTO toDTO() {
		List<MovimientoCCDTO> movsDTO = new ArrayList<MovimientoCCDTO>();
		for(MovimientoCC mov : this.movimientos) {
			movsDTO.add(mov.toDTO());
		}
		CuentaCorrienteDTO dto = new CuentaCorrienteDTO(this.saldo, this.limiteCredito, movsDTO);
		dto.setId(id);
		return dto;
	}

	public void save() {
		ClienteDAO.getInstance().save(this);	
	}

}
