package model;

import java.util.List;

public class Proveedor {
private long id ;
private String nombre;
private List<InsumoProveedor> insumos;


public List<InsumoProveedor> getInsumos() {
	return insumos;
}
public void setInsumos(List<InsumoProveedor> insumos) {
	this.insumos = insumos;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


}
