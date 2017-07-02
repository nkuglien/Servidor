package model;

import dao.PosicionDAO;

public class Posicion {

	private String codigo;
	private Boolean libre;
	private Lote lote;

	public Posicion(String codigo2, Boolean libre2, Lote loteBO) {
		this(codigo2,libre2);
		lote=loteBO;
	}

	public Posicion(String codigo2, Boolean libre2) {
		codigo=codigo2;
		libre=libre2;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getLibre() {
		return libre;
	}

	public void setLibre(Boolean libre) {
		this.libre = libre;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.libre = false;
		this.lote = lote;
	}

	
	
	public Posicion save() {
		return PosicionDAO.getInstance().save(this);
	}

}
