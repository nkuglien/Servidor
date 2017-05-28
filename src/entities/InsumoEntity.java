package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.Insumo;

@Entity
@Table(name = "INSUMO")
public class InsumoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insumo_id")
	private long id;

	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "stock_minimo")
	private Integer stockMinimo;

	@Column(name = "cantidad_compra")
	private Integer cantCompra;

	public InsumoEntity() {
	}

	public InsumoEntity(Insumo insumo) {
		this.setId(insumo.getId());
		this.setCodigo(insumo.getCodigo());
		this.setDescripcion(insumo.getDescripcion());
		this.setNombre(insumo.getNombre());
		this.setStockMinimo(insumo.getStockMinimo());
		this.setCantCompra(insumo.getCantCompra());
	}

	public Insumo toBO() {
		Insumo insumo = new Insumo();
		insumo.setId(this.getId());
		insumo.setCodigo(this.getCodigo());
		insumo.setDescripcion(this.getDescripcion());
		insumo.setNombre(this.getNombre());
		insumo.setStockMinimo(this.getStockMinimo());
		insumo.setCantCompra(this.getCantCompra());
		return insumo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
