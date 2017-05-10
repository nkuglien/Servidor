package entities;

public class Insumo {

	private Long codigo;
	private String descripcion;
	private String nombre;
	private Integer stockMinimo;
	private Integer cantCompra;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public Integer getCantCompra() {
		return cantCompra;
	}
	public void setCantCompra(Integer cantCompra) {
		this.cantCompra = cantCompra;
	}
	
}
