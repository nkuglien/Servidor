package entities;

public class PrendaAreaProduccionEntity {

	private Long id;
	private AreaProduccionEntity area;
	private Integer tiempo;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public AreaProduccionEntity getArea() {
		return area;
	}
	
	public void setArea(AreaProduccionEntity area) {
		this.area = area;
	}
	
	public Integer getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	
}
