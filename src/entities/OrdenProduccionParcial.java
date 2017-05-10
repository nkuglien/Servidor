package entities;

import java.util.List;

public class OrdenProduccionParcial extends OrdenProduccion {

	private List<VariedadPrenda> variedades;

	public List<VariedadPrenda> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<VariedadPrenda> variedades) {
		this.variedades = variedades;
	}
	
	
}
