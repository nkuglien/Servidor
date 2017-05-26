package model;

public class Posicion {

	private String codigo;
	private Boolean libre;
	private Lote lote;

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
		this.lote = lote;
	}

}
