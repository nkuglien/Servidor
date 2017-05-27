package entities;

import java.util.List;

public class OrdenProduccionParcialEntity extends OrdenProduccionEntity {

	private List<VariedadPrendaEntity> variedades;

	public List<VariedadPrendaEntity> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<VariedadPrendaEntity> variedades) {
		this.variedades = variedades;
	}
	
}
