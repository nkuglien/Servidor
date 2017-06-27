package model;

import java.util.Date;
import java.util.List;

public class OrdenProduccion {

	private Long id;
	private Date fecha;
	private String estado;
	private List<PedidoCliente> pedidoCliente;
	private List<VariedadPrenda> variedades;
	private List<ReservaInsumo> insumos;

	public OrdenProduccion(Long id2, Date fecha2, String estado2, List<PedidoCliente> pedidosC,
			List<VariedadPrenda> variedadesPrenda, List<ReservaInsumo> insumos2) {
		// TODO Auto-generated constructor stub
	}

	public static void generarOrdenCompleta(Prenda prenda, PedidoCliente pedido){
		//llama al dao y ve que variedades hay de esa prenda y llama a generarOrdenVariedades
	}
	
	public static void generarOrdenParcial(List<VariedadPrenda> variedades, PedidoCliente pedido){
		//Se fija si ya no hay ordenes de produccion que puedan satisfacer el pedido
		//Se guarda en la base de datos en estado de espera 
		//ejecuta intentarArmar
	}
	
	public void intentarArmarPedido(){
		//Traer todos los insumos que requiere la generacion que aun no haya reservado
		//Verificar que los insumos esten
		//Reservarlos
		//si puede se pone lista para producir
		// si no puede se pone  a la espera del pedido de insumo		
		
	}
	
	public void ponerAproducir(){
		//si el pedido esta completo lo pone en estado PRODUCCION
	}
	public void finProduccion(){
		//genera el lote y lo almacena
		//da aviso a los pedidos suscriptos
	}
	
	
	public List<VariedadPrenda> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<VariedadPrenda> variedades) {
		this.variedades = variedades;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PedidoCliente> getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(List<PedidoCliente> pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public List<ReservaInsumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<ReservaInsumo> insumos) {
		this.insumos = insumos;
	}
	
	
	
	
}
