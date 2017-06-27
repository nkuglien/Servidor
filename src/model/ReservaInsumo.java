package model;

public class ReservaInsumo {

	private int id;
	private OrdenProduccion orden;
	private LoteInsumo loteInsumo;
	private int cantidad;
	
	
	public ReservaInsumo(int id2, OrdenProduccion orden2, LoteInsumo lote2, int cantidad2) {
		id=id2;
		orden=orden2;
		loteInsumo=lote2;
		cantidad=cantidad2;
	}
	public OrdenProduccion getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccion orden) {
		this.orden = orden;
	}
	public LoteInsumo getLoteInsumo() {
		return loteInsumo;
	}
	public void setLoteInsumo(LoteInsumo loteInsumo) {
		this.loteInsumo = loteInsumo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
}
