package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.ItemInsumo;
import model.VariedadPrenda;

@Entity
@Table(name = "VARIEDAD_PRENDA")
public class VariedadPrendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "variedad_id")
	private Long id;

	@ManyToOne
	@JoinTable(name = "PRENDA_VARIEDAD_PRENDA", joinColumns = {
			@JoinColumn(name = "variedad_id") }, inverseJoinColumns = { @JoinColumn(name = "codigo") })
	private PrendaEntity prenda;

	@Column(name = "talle")
	private String talle;

	@Column(name = "color")
	private String color;

	@Column(name = "en_produccion")
	private Boolean enProduccion;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemInsumoEntity> insumos;

	@Column(name = "cantidad_produccion_fija")
	private Integer cantidadProduccionFija;

	@Column(name = "costo_produccion_actual")
	private Float costoProduccionActual;

	@Column(name = "precio_venta_actual")
	private Float precioVentaActual;

	public VariedadPrendaEntity() {
	}

	public VariedadPrendaEntity(VariedadPrenda variedad, boolean copyInverseReferences) {
		this.setId(variedad.getId());
		if (copyInverseReferences && variedad.getPrenda() != null) {
			this.setPrenda(new PrendaEntity(variedad.getPrenda(), false));
		}
		this.setTalle(variedad.getTalle());
		this.setColor(variedad.getColor());
		this.setEnProduccion(variedad.getEnProduccion());
		this.setItemsInsumoEntity(variedad.getInsumos());
		this.setCantidadProduccionFija(variedad.getCantidadProduccionFija());
		this.setCostoProduccionActual(variedad.getCostoProduccionActual());
		this.setPrecioVentaActual(variedad.getPrecioVentaActual());
	}

	private void setItemsInsumoEntity(List<ItemInsumo> itemsInsumo) {
		List<ItemInsumoEntity> list = new ArrayList<ItemInsumoEntity>();
		for (ItemInsumo itemInsumo : itemsInsumo) {
			list.add(new ItemInsumoEntity(itemInsumo));
		}
		this.setInsumos(list);
	}

	public VariedadPrenda toBO(boolean copyInverseReferences) {
		VariedadPrenda variedad = new VariedadPrenda();
		variedad.setId(this.getId());
		if (copyInverseReferences) {
			variedad.setPrenda(this.getPrenda().toBO());
			variedad.setInsumos(toInsumosBO(this.getInsumos()));
		}
		variedad.setTalle(this.getTalle());
		variedad.setColor(this.getColor());
		variedad.setEnProduccion(this.getEnProduccion());
		variedad.setCantidadProduccionFija(this.getCantidadProduccionFija());
		variedad.setCostoProduccionActual(this.getCostoProduccionActual());
		variedad.setPrecioVentaActual(this.getPrecioVentaActual());
		return variedad;
	}

	private List<ItemInsumo> toInsumosBO(List<ItemInsumoEntity> itemsInsumo) {
		List<ItemInsumo> insumos = new ArrayList<ItemInsumo>();
		for (ItemInsumoEntity insumoEntity : itemsInsumo) {
			insumos.add(insumoEntity.toBO());
		}
		return insumos;
	}

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
