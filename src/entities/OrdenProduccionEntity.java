package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.OrdenProduccion;
import model.PedidoCliente;
import model.ReservaInsumo;
import model.VariedadPrenda;

@Entity
@Table(name = "OrdenProduccion")
public class OrdenProduccionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date fecha;
	private String estado;
	private String tipo;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PedidoClienteEntity> pedidoCliente;
	@ManyToMany
	private List<VariedadPrendaEntity> variedades;
	@OneToMany
	@JoinColumn(name = "idOrdenProduccion")
	private List<ReservaInsumoEntity> insumos;

	
	public OrdenProduccionEntity() {}
	
	public OrdenProduccionEntity(OrdenProduccion o) {
		setId(o.getId());
		setTipo(o.getTipo());
		setFecha(o.getFecha());
		setEstado(o.getEstado());
		if (o.getPedidoCliente() != null) {
			List<PedidoClienteEntity> pedidos = new ArrayList<PedidoClienteEntity>();
			for (PedidoCliente p : o.getPedidoCliente()) {
				pedidos.add(new PedidoClienteEntity(p, true));
			}
			setPedidoCliente(pedidos);
		}
		if (o.getVariedades() != null) {
			List<VariedadPrendaEntity> variedades = new ArrayList<VariedadPrendaEntity>();
			for (VariedadPrenda p : o.getVariedades()) {
				variedades.add(new VariedadPrendaEntity(p, true));
			}
			setVariedades(variedades);
		}
		if (o.getInsumos() != null) {
			List<ReservaInsumoEntity> insum = new ArrayList<ReservaInsumoEntity>();
			for (ReservaInsumo p : o.getInsumos()) {
				insum.add(new ReservaInsumoEntity(p));
			}
			setInsumos(insum);
		}
	}

	public List<VariedadPrendaEntity> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<VariedadPrendaEntity> variedades) {
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

	public List<PedidoClienteEntity> getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(List<PedidoClienteEntity> pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public List<ReservaInsumoEntity> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<ReservaInsumoEntity> insumos) {
		this.insumos = insumos;
	}

	public OrdenProduccion toBO() {
		return toBO(true);
	}

	public OrdenProduccion toBO(Boolean IncluirInsumos) {
		List<PedidoCliente> pedidosC = new ArrayList<PedidoCliente>();
		List<VariedadPrenda> variedadesPrenda = new ArrayList<VariedadPrenda>();
		List<ReservaInsumo> insumos2 = new ArrayList<ReservaInsumo>();
		if (pedidoCliente != null) {
			for (PedidoClienteEntity p : pedidoCliente) {
				pedidosC.add(p.toBO(true));
			}
		}
		if (variedades != null) {
			for (VariedadPrendaEntity v : variedades) {
				variedadesPrenda.add(v.toBO(true));
			}
		}
		if (IncluirInsumos) {
			if (insumos != null) {
				for (ReservaInsumoEntity i : insumos) {
					insumos2.add(i.toBO());
				}
			}
		}
		OrdenProduccion orden = new OrdenProduccion(id, fecha, estado, pedidosC, variedadesPrenda, insumos2,getTipo());
		return orden;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
