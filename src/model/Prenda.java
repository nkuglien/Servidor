package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DTO.PrendaAreaProduccionDTO;
import DTO.PrendaDTO;
import DTO.VariedadPrendaDTO;
import dao.PrendaDAO;

public class Prenda {

	private Long codigo;
	private String descripcion;
	private Boolean enProduccion;
	private List<VariedadPrenda> variedades;
	private List<PrendaAreaProduccion> areas;
	
	public Prenda() {
		this.setVariedades(new ArrayList<VariedadPrenda>());
		this.setAreas(new ArrayList<PrendaAreaProduccion>());
	}
	
	public Prenda(long codigo, String descripcion, Boolean enProduccion) {
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setEnProduccion(enProduccion);
		this.setVariedades(new ArrayList<VariedadPrenda>());
		this.setAreas(new ArrayList<PrendaAreaProduccion>());
	}
	
	public Prenda(PrendaDTO prenda) {
		this.setCodigo(prenda.getCodigo());
		this.setDescripcion(prenda.getDescripcion());
		this.setEnProduccion(prenda.getEnProduccion());
		
		List<VariedadPrenda> vaiedades = new ArrayList<VariedadPrenda>();
		for(VariedadPrendaDTO variedadDTO : prenda.getVariedades()) {
			vaiedades.add(new VariedadPrenda(variedadDTO));
		}
		this.setVariedades(vaiedades);
		
		List<PrendaAreaProduccion> areas = new ArrayList<PrendaAreaProduccion>();
		for(PrendaAreaProduccionDTO areaDTO : prenda.getAreas()) {
			areas.add(new PrendaAreaProduccion(areaDTO));
		}
		this.setAreas(areas);
		
	}
	
	public void baja() {
		PrendaDAO.getInstance().baja(this);
	}

	public Prenda save() {
		return PrendaDAO.getInstance().save(this);
	}
	
	public void agregarVariedad(VariedadPrenda variedad) {
		this.getVariedades().add(variedad);
	}
	
	public void agregarArea(AreaProduccion area, Integer tiempo) {
		PrendaAreaProduccion prendaArea = new PrendaAreaProduccion(area, tiempo);
		this.getAreas().add(prendaArea);
	}
	
	public void removerArea(long prendaAreaProduccionId) {
		Iterator<PrendaAreaProduccion> it = this.getAreas().iterator();
		while (it.hasNext()) {
			PrendaAreaProduccion prendaArea = it.next();
			if (prendaArea.getId() == prendaAreaProduccionId) {
				it.remove();
				return;
			}
		}
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

	public Boolean getEnProduccion() {
		return enProduccion;
	}

	public void setEnProduccion(Boolean enProduccion) {
		this.enProduccion = enProduccion;
	}

	public List<VariedadPrenda> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<VariedadPrenda> variedades) {
		this.variedades = variedades;
	}

	public List<PrendaAreaProduccion> getAreas() {
		return areas;
	}

	public void setAreas(List<PrendaAreaProduccion> areas) {
		this.areas = areas;
	}

	public PrendaDTO toDTO() {
		PrendaDTO dto = new PrendaDTO();
		dto.setCodigo(this.getCodigo());
		dto.setDescripcion(this.getDescripcion());
		System.out.println(dto.getDescripcion());
		dto.setEnProduccion(this.getEnProduccion());
		
		List<VariedadPrendaDTO> vaiedadesDTO = new ArrayList<VariedadPrendaDTO>();
		for(VariedadPrenda variedad : this.getVariedades()) {
			vaiedadesDTO.add(variedad.toDTO());
		}
		dto.setVariedades(vaiedadesDTO);
		
		List<PrendaAreaProduccionDTO> areasDTO = new ArrayList<PrendaAreaProduccionDTO>();
		for(PrendaAreaProduccion area : this.getAreas()) {
			areasDTO.add(area.toDTO());
		}
		dto.setAreas(areasDTO);
		return dto;
	}

}
