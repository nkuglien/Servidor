package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import DTO.EstadoPedidoCliente;
import DTO.ItemPedidoClienteDTO;
import DTO.PedidoClienteDTO;
import DTO.ReservaVariedadPrendaDTO;
import controllers.OrdenProduccionController;
import dao.LoteDAO;
import dao.OrdenProduccionDAO;
import dao.PedidoClienteDAO;
import dao.PrendaDAO;

public class PedidoCliente {
	
	private Long nroPedido;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaProbableDespacho;
	private List<ItemPedidoCliente> items;
	private Cliente cliente;
	private Float subtotal;
	private Float impuestos;
	private Float total;
	private EstadoPedidoCliente estado;
	private String nota;
	private List<ReservaVariedadPrenda> reservas;
	
	public PedidoCliente() {
		reservas = new ArrayList<ReservaVariedadPrenda>();
	}
	
	public PedidoCliente(PedidoClienteDTO dto) {
		this.nroPedido = dto.getNroPedido();
		this.fechaGeneracion = dto.getFechaGeneracion();
		this.fechaDespacho = dto.getFechaDespacho();
		this.fechaProbableDespacho = dto.getFechaProbableDespacho();
		if(dto.getCliente()!=null)this.cliente = new Cliente(dto.getCliente(), false);
		this.subtotal = dto.getSubtotal();
		this.impuestos = dto.getImpuestos();
		this.total = dto.getTotal();
		this.estado = dto.getEstado();
		this.setNota(dto.getNota());
		if(dto.getItems()!=null) {
			List<ItemPedidoCliente> items = new ArrayList<ItemPedidoCliente>();
			for(ItemPedidoClienteDTO item : dto.getItems()) {
				items.add(new ItemPedidoCliente(item));
			};
			this.items = items;	
		}
		if(dto.getReservas()!=null) {
			List<ReservaVariedadPrenda> reservasList = new ArrayList<ReservaVariedadPrenda>();
			for(ReservaVariedadPrendaDTO r : dto.getReservas()) {
				reservasList.add(new ReservaVariedadPrenda(r));
			};
			this.reservas = reservasList;	
		}

	}

	public Long getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(Long nroPedido) {
		this.nroPedido = nroPedido;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public List<ItemPedidoCliente> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoCliente> items) {
		this.items = items;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Float impuestos) {
		this.impuestos = impuestos;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public EstadoPedidoCliente getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedidoCliente estado) {
		this.estado = estado;
	}
	
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public PedidoCliente save() {
		return PedidoClienteDAO.getInstance().save(this);		
	}

	public PedidoClienteDTO toDTO() {
		PedidoClienteDTO dto = new PedidoClienteDTO();
		if(cliente!=null)dto.setCliente(cliente.toDTO());
		dto.setEstado(estado);
		dto.setFechaDespacho(fechaDespacho);
		dto.setFechaGeneracion(fechaGeneracion);
		dto.setFechaProbableDespacho(fechaProbableDespacho);
		dto.setImpuestos(impuestos);
		dto.setNota(nota);
		dto.setNroPedido(nroPedido);
		dto.setSubtotal(subtotal);
		dto.setTotal(subtotal);
		if(this.getItems()!=null) {
			List<ItemPedidoClienteDTO> itemsDTO = new ArrayList<ItemPedidoClienteDTO>();
			for (ItemPedidoCliente item : this.items) {
				itemsDTO.add(item.toDTO());
			}
			dto.setItems(itemsDTO);
		}
		return dto;
	}

	public void intentarArmar() {
		
		// mapa con clave idPrenda y valor lista de VariedadPrenda a mandar a producir
		HashMap<Long, List<VariedadPrenda>> variedadesPorPrendaAPedir = new HashMap<Long, List<VariedadPrenda>>();
		
		Boolean hayStockDeTodo = true;
		
		// recorrer los items del pedido
		for(ItemPedidoCliente item : items) {

			// agrupo las que no tienen stock (para hacer ordenes produccion luego)
			if(item.getItem().getStock() < item.getCantidad()) {
				agruparVariedadPrendaAPedirPorPrenda(variedadesPorPrendaAPedir, item);	
				hayStockDeTodo = false;
			}
		}
		
		// si tengo stock de todas las variedades, recorro los lotes y genero reservas
		if(hayStockDeTodo) {
			for(ItemPedidoCliente item : items) {
				
				List<LoteVariedadPrenda> lotes = LoteDAO.getInstance().getLotesConDisponibles(item.getItem());
				Collections.sort(lotes, new Comparator<LoteVariedadPrenda>() {

					@Override
					public int compare(LoteVariedadPrenda o1, LoteVariedadPrenda o2) {
						return o2.getCantDisponible().compareTo(o1.getCantDisponible());
					}
					
				});
				Integer cantidadAReservar = item.getCantidad();
				generarReservas(lotes, cantidadAReservar);
			}
			this.setEstado(EstadoPedidoCliente.COMPLETO);
			//this.save();
		} else { // sino, genero los pedidos necesarios
			generarPedidos(variedadesPorPrendaAPedir);
		}

	}

	
	// genera pedidos a partir de las variedadPrenda
	private void generarPedidos(HashMap<Long, List<VariedadPrenda>> variedadesPorPrendaAPedir) {
		Iterator it = variedadesPorPrendaAPedir.entrySet().iterator();
		OrdenProduccionController ordenController = OrdenProduccionController.getInstance();
		while (it.hasNext()) {
			Map.Entry<Long, List<VariedadPrenda>> pair = (Map.Entry<Long, List<VariedadPrenda>>) it.next();
			
			//solo si no tengo una orden de produccion pendiente de esta misma prenda o variedad
			List<VariedadPrenda> variedades = pair.getValue();
			List<VariedadPrenda> variedadesAPedir = new ArrayList<>();
			for(VariedadPrenda var : variedades) {
				if(!OrdenProduccionDAO.getInstance().existenOrdenesPendiente(var, this))
						variedadesAPedir.add(var);
			}
			
			if (variedadesAPedir.size() >= 3) {
				Prenda p = PrendaDAO.getInstance().getPrendaByCodigo(pair.getKey());
				ordenController.generarOrdenCompleta(p, this);
			} else if (variedadesAPedir.size()>0){
				ordenController.generarOrdenParcial(variedadesAPedir, this);
			}
		}
	}

	// agrupa las variedadPrenda por codigo de Prenda
	private void agruparVariedadPrendaAPedirPorPrenda(HashMap<Long, List<VariedadPrenda>> variedadesPorPrendaAPedir,
			ItemPedidoCliente item) {
		Long idPrenda = item.getItem().getPrenda().getCodigo();
		if(variedadesPorPrendaAPedir.get(idPrenda) != null) {
			variedadesPorPrendaAPedir.get(idPrenda).add(item.getItem());
		} else {
			List<VariedadPrenda> varPrendaList = new ArrayList<VariedadPrenda>();
			varPrendaList.add(item.getItem());
			variedadesPorPrendaAPedir.put(idPrenda, varPrendaList);
		}
	}

	// genera reservas de las variedadPrenda
	private void generarReservas(List<LoteVariedadPrenda> lotes, Integer cantidadAReservar) {
		
		for (LoteVariedadPrenda lote : lotes) {
			// cantidad disponible del lote
			Integer cantLote = lote.getCantDisponible();
							
			ReservaVariedadPrenda reserva;
			
			// verifica que la cantidad a reservar exista en el lote
			if (cantLote >= cantidadAReservar) {
				// si me alcanza con un solo lote, reservo, y dejo de recorrer
				reserva = new ReservaVariedadPrenda(this, lote, cantidadAReservar);
				this.agregarReserva(reserva);
				break;
			} else {
				// si el lote no me alcanza, reservo lo que puedo y sigo recorriendo lotes
				reserva = new ReservaVariedadPrenda(this, lote, cantLote);
				this.agregarReserva(reserva);
				cantidadAReservar = cantidadAReservar - cantLote;
			}
		}
	}

	private void agregarReserva(ReservaVariedadPrenda reserva) {
		Integer cantDisp = reserva.getLote().getCantDisponible();
		reserva.getLote().setCantDisponible(cantDisp-reserva.getCantidad());
		this.reservas.add(reserva);
	}

	public List<ReservaVariedadPrenda> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaVariedadPrenda> reservas) {
		this.reservas = reservas;
	}
	
}
