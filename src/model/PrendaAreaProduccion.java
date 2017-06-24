package model;

import DTO.PrendaAreaProduccionDTO;

public class PrendaAreaProduccion {

	private Long id;
	private AreaProduccion area;
	private Integer tiempo;
	
	public PrendaAreaProduccion() {
	}
	
	public PrendaAreaProduccion(AreaProduccion area, Integer tiempo) {
		this.setArea(area);
		this.setTiempo(tiempo);
	}

	public PrendaAreaProduccion(PrendaAreaProduccionDTO areaDTO) {
		this.setId(areaDTO.getId());
		this.setArea(new AreaProduccion(areaDTO.getArea()));
		this.setTiempo(areaDTO.getTiempo());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AreaProduccion getArea() {
		return area;
	}

	public void setArea(AreaProduccion area) {
		this.area = area;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public PrendaAreaProduccionDTO toDTO() {
		PrendaAreaProduccionDTO dto = new PrendaAreaProduccionDTO();
		dto.setArea(area.toDTO());
		dto.setId(id);
		dto.setTiempo(tiempo);
		return dto;
	}

}