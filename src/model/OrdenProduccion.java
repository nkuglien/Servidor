package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DTO.OrdenProduccionDTO;
import DTO.VariedadPrendaDTO;
import dao.LoteDAO;
import dao.OrdenProduccionDAO;
import dao.PedidoInsumoDAO;
import dao.PosicionDAO;
import dao.PrendaDAO;

public class OrdenProduccion {

	private Long id;
	private Date fecha;
	private String estado;
	private String tipo;
	private List<PedidoCliente> pedidoCliente;
	private List<VariedadPrenda> variedades;
	private List<ReservaInsumo> insumos;

	public OrdenProduccion(Long id2, Date fecha2, String estado2, List<PedidoCliente> pedidosC,
			List<VariedadPrenda> variedadesPrenda, List<ReservaInsumo> insumos2, String tipo2) {
		id = id2;
		fecha = fecha2;
		estado = estado2;
		pedidoCliente = pedidosC;
		variedades = variedadesPrenda;
		insumos = insumos2;
		tipo=tipo2;
	}

	public OrdenProduccion(List<VariedadPrenda> variedadesPrenda, PedidoCliente pedido, String tipo2) {
		fecha = new Date();
		estado = "INICIAL";
		pedidoCliente = new ArrayList<PedidoCliente>();
		pedidoCliente.add(pedido);
		variedades = variedadesPrenda;
		tipo=tipo2;
		
	}
	
	public OrdenProduccion(OrdenProduccionDTO dto) {
		id = dto.getId();
		fecha = dto.getFecha();
		estado = dto.getEstado();
		tipo = dto.getTipo();
	}

	public void intentarCompletar() {
		// Traer todos los insumos que requiere la generacion que aun no haya reservado
		// Verifico los insumos que necesito
		// Verificar que los insumos esten
		// Reservarlos
		// si puede se pone lista para producir
		// si no puede se pone a la espera del pedido de insumo
		Boolean aLaEsperaDeInsumo = false;
		List<ItemInsumo> faltantes = this.getInsumosFaltantes();
		LoteDAO loteDAO = LoteDAO.getInstance();
		for (ItemInsumo item : faltantes) {
			if (!PedidoInsumoDAO.getInstance().hayPedidoPendiente(item.getInsumo(), this)) {
				List<LoteInsumo> lotesInsumo = loteDAO.getLotesConDisponibles(item.getInsumo());
				for (LoteInsumo lote : lotesInsumo) {
					if (lote.getCantDisponible() >= item.getCantidad()) {
						ReservaInsumo reserva= new ReservaInsumo(this, lote, item.getCantidad());
						reserva.save();
						
						lote.setCantDisponible(lote.getCantDisponible() - item.getCantidad());
						item.setCantidad(0);
						lote.save();
						
						break;
					} else {
						ReservaInsumo reserva=new ReservaInsumo(this, lote, lote.getCantDisponible());
						reserva.save();
						
						item.setCantidad(item.getCantidad() - lote.getCantDisponible());
						lote.setCantDisponible(0);
						lote.save();
						
					}
				}
				if (item.getCantidad() > 0) {
					aLaEsperaDeInsumo = true;
					PedidoInsumo.generarPedidoInsumo(item.getInsumo(), this);

				}
			} else {
				aLaEsperaDeInsumo = true;
			}
		}
		if (aLaEsperaDeInsumo) {
			this.setEstado("ESPERA");
		} else {
			this.setEstado("COMPLETO");
		}

		this.save();

	}

	public void ponerAproducir() {
		// si el pedido esta completo lo pone en estado PRODUCCION
		if (this.getEstado().equals("COMPLETO")) {
			this.setEstado("PRODUCCION");
			this.save();
		}
	}

	public void finProduccion() {
		// genera el lote y lo almacena
		// da aviso a los pedidos suscriptos
		for (VariedadPrenda vp : this.getVariedades()) {
			vp.recalcularPrecio();
			vp = vp.save();
			LoteVariedadPrenda lote = new LoteVariedadPrenda(vp, this);	
			Posicion pos = PosicionDAO.getInstance().getPosicionPrendaVacia();
			pos.setLote(lote.save());
			pos.save();
		}
		this.setEstado("TERMINADO");
		this.save();
		for (PedidoCliente pedido : getPedidoCliente()) {
			pedido.intentarArmar();
			pedido.save();
		}
	}

	public List<ItemInsumo> getInsumosFaltantes() {
		List<ItemInsumo> necesarios = this.getInsumosNecesarios();
		List<ItemInsumo> retorno = new ArrayList<ItemInsumo>();
		if (this.getInsumos() != null) {
			for (ReservaInsumo ri : this.getInsumos()) {
				for (ItemInsumo item : necesarios) {
					if (ri.getLoteInsumo().getInsumo().getId() == item.getInsumo().getId()) {
						item.setCantidad(item.getCantidad() - ri.getCantidad());
					}
				}
			}
			
		}
		for (ItemInsumo item : necesarios) {
			if (item.getCantidad() > 0)
				retorno.add(item);
		}
		return retorno;
	}

	public List<ItemInsumo> getInsumosNecesarios() {
		List<ItemInsumo> InsumosQueNecesito = new ArrayList<ItemInsumo>();
		List<ItemInsumo> InsumosNoRepetidos = new ArrayList<ItemInsumo>();
		for (VariedadPrenda vp : this.getVariedades()) {
			for(ItemInsumo i : vp.getInsumos()){
				i.setCantidad(i.getCantidad()*vp.getCantidadProduccionFija());
			}
			
			InsumosQueNecesito.addAll(vp.getInsumos());
		}
		for (ItemInsumo item : InsumosQueNecesito) {
			boolean loAgrego = true;
			for (ItemInsumo item2 : InsumosNoRepetidos) {
				if (item.getInsumo().getId() == item2.getInsumo().getId()) {
					item2.setCantidad(item2.getCantidad() + item.getCantidad());
					loAgrego = false;
				}
			}
			if (loAgrego) {
				InsumosNoRepetidos.add(item);
			}
		}
		return InsumosNoRepetidos;
	}

	public OrdenProduccion save() {
		OrdenProduccionDAO dao = OrdenProduccionDAO.getInstance();
		return dao.save(this);
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

	public OrdenProduccionDTO toDTO() {
		List<VariedadPrendaDTO> dtoPrenda = new ArrayList<VariedadPrendaDTO>();
		for (VariedadPrenda v : variedades) {
			dtoPrenda.add(v.toDTO());
		}
		
		
		OrdenProduccionDTO dto = new OrdenProduccionDTO(id, fecha, estado,variedades.get(0).getPrenda().getDescripcion(), dtoPrenda,getTipo());
		return dto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
