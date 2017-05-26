package entities;

public class OrdenProduccionCompletaEntity extends OrdenProduccionEntity{

	private PrendaEntity prenda;

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
}
