package entities;

public class PosicionEntity {

	private String codigo;
	private Boolean libre;
	private LoteEntity lote;
	
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
	
	public LoteEntity getLote() {
		return lote;
	}
	
	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}
	
}
