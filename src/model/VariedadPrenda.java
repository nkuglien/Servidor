package model;

import java.util.ArrayList;
import java.util.List;

import DTO.ItemInsumoDTO;
import DTO.VariedadPrendaDTO;
import dao.LoteDAO;
import dao.PrendaDAO;

public class VariedadPrenda {

	private Long id;
	private Prenda prenda;
	private String talle;
	private String color;
	private Boolean enProduccion;
	private List<ItemInsumo> insumos;
	private Integer cantidadProduccionFija;
	private Float costoProduccionActual;
	private Float precioVentaActual;

	public VariedadPrenda() {
		this.setInsumos(new ArrayList<ItemInsumo>());
	}

	public VariedadPrenda(Prenda prenda, String talle, String color, boolean enProduccion, int cantidadProduccionFija,
			float costoProduccionActual, float precioVentaActual) {
		this.setPrenda(prenda);
		this.setTalle(talle);
		this.setColor(color);
		this.setEnProduccion(enProduccion);
		this.setInsumos(new ArrayList<ItemInsumo>());
		this.setCantidadProduccionFija(cantidadProduccionFija);
		this.setCostoProduccionActual(costoProduccionActual);
		this.setPrecioVentaActual(precioVentaActual);
	}

	public VariedadPrenda save() {
		return PrendaDAO.getInstance().saveVarieadad(this);
	}
	
	public void baja() {
		PrendaDAO.getInstance().baja(this);
	}

	public void agregarInusmo(Insumo insumo, float desperdicio, int cantidad) {
		ItemInsumo itemInsumo = new ItemInsumo(insumo, desperdicio, cantidad);
		this.getInsumos().add(itemInsumo);
	}

	public VariedadPrenda(VariedadPrendaDTO variedadDTO) {
		this.id = variedadDTO.getId();
		if(variedadDTO.getPrenda()!=null) this.prenda = new Prenda(variedadDTO.getPrenda());
		this.talle = variedadDTO.getTalle();
		this.color = variedadDTO.getColor();
		this.enProduccion = variedadDTO.getEnProduccion();
		this.cantidadProduccionFija = variedadDTO.getCantidadProduccionFija();
		this.costoProduccionActual = variedadDTO.getCostoProduccionActual();
		this.precioVentaActual = variedadDTO.getPrecioVentaActual();

		List<ItemInsumo> insumosList = new ArrayList<ItemInsumo>();
		for (ItemInsumoDTO insumoDTO : variedadDTO.getInsumos()) {
			insumosList.add(new ItemInsumo(insumoDTO));
		}
		this.insumos = insumosList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
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

	public List<ItemInsumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<ItemInsumo> insumos) {
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

	public boolean hayStock() {
		return true;
	}


	public VariedadPrendaDTO toDTO() {
		VariedadPrendaDTO dto = new VariedadPrendaDTO();
		dto.setId(id);
		if(prenda!=null) dto.setPrenda(prenda.toDTO());
		dto.setTalle(talle);
		dto.setColor(color);
		dto.setEnProduccion(enProduccion);
		dto.setCantidadProduccionFija(cantidadProduccionFija);
		dto.setPrecioVentaActual(precioVentaActual);
		dto.setCostoProduccionActual(costoProduccionActual);
		dto.setStock(LoteDAO.getInstance().getStock(this));		
		List<ItemInsumoDTO> insumosList = new ArrayList<ItemInsumoDTO>();
		for (ItemInsumo insumo : insumos) {
			insumosList.add(insumo.toDTO());
		}
		dto.setInsumos(insumosList);
		
		return dto;
	}

	public void recalcularPrecio() {
		Float total =(float) 0;
		for(ItemInsumo in : this.getInsumos() ){
			total=total+ in.getInsumo().getPrecio()*in.getCantidad();
		}
		this.setPrecioVentaActual(total);
		
	}	

}
