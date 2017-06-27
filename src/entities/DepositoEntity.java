package entities;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;


@Entity
@Table(name = "DEPOSITO")
public class DepositoEntity {
	
	@Id
	@Column(name = "deposito_id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;

	@ElementCollection
    @MapKeyColumn(name = "codigo_posicion")
    @Column(name = "disponible")
    @CollectionTable(name = "deposito_posiciones", joinColumns = { @JoinColumn(name = "deposito_id") })
	private Map<String, PosicionEntity> posiciones;

	public Map<String, PosicionEntity> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Map<String, PosicionEntity> posiciones) {
		this.posiciones = posiciones;
	}
	
}
