package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "VARIEDAD_PRENDA")
public class VariedadPrendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insumo_id")
	private Long id;
	
	@ManyToOne
	private PrendaEntity prenda;
	
	@Column(name = "talle")
	private String talle;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "en_produccion")
	private Boolean enProduccion;
	
	@OneToMany
	private List<ItemInsumoEntity> insumos;
	
	@Column(name = "cantidad_produccion_fija")
	private Integer cantidadProduccionFija;
	
	@Column(name = "costo_produccion_actual")
	private Float costoProduccionActual;
	
	@Column(name = "precio_venta_actual")
	private Float precioVentaActual;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PrendaEntity getPrenda() {
		return prenda;
	}
	
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
	public String getTalle() {
		return talle;
	}
	
	public void setTalle(String talle) {
		this.talle = talle;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Boolean getEnProduccion() {
		return enProduccion;
	}
	
	public void setEnProduccion(Boolean enProduccion) {
		this.enProduccion = enProduccion;
	}
	
	public List<ItemInsumoEntity> getInsumos() {
		return insumos;
	}
	
	public void setInsumos(List<ItemInsumoEntity> insumos) {
		this.insumos = insumos;
	}
	
	public Integer getCantidadProduccionFija() {
		return cantidadProduccionFija;
	}
	
	public void setCantidadProduccionFija(Integer cantidadProduccionFija) {
		this.cantidadProduccionFija = cantidadProduccionFija;
	}
	
	public Float getCostoProduccionActual() {
		return costoProduccionActual;
	}
	
	public void setCostoProduccionActual(Float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}
	
	public Float getPrecioVentaActual() {
		return precioVentaActual;
	}
	
	public void setPrecioVentaActual(Float precioVentaActual) {
		this.precioVentaActual = precioVentaActual;
	}
	
}
