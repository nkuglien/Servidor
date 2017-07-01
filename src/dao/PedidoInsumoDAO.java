package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.InsumoEntity;
import entities.PedidoInsumoEntity;
import model.Insumo;
import model.OrdenProduccion;
import model.PedidoInsumo;

public class PedidoInsumoDAO extends HibernateDAO {
	
	private static PedidoInsumoDAO instancia = null;

	public static PedidoInsumoDAO getInstance(){
		if(instancia == null) {
			instancia = new PedidoInsumoDAO();
		} 
		return instancia;
	}
	
	public PedidoInsumo save(PedidoInsumo insumo) {
		Session session = this.openSession();
		session.beginTransaction();		
		PedidoInsumoEntity pedidoInsumoEntity = new PedidoInsumoEntity(insumo);
		session.saveOrUpdate(pedidoInsumoEntity);		
		session.flush();
		session.getTransaction().commit();
		session.close();
		return pedidoInsumoEntity.toBO();
	}
	
	//public Insumo findByCodigo(long codigo) {
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
	//	query.setParameter("codigo", codigo);
	//	InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
	//	return insumo != null? insumo.toBO() : null;
	//}
	
	public List<PedidoInsumo> getAllInsumos() {
		List<PedidoInsumo> insumos = new ArrayList<PedidoInsumo>();
		Session session = this.openSession();
		Query query = session.createQuery("from PedidoInsumoEntity");
		List<PedidoInsumoEntity> pedidoInsumoEntity =  query.list();
		for (PedidoInsumoEntity Ped : pedidoInsumoEntity) {
			insumos.add(Ped.toBO());
		}
		return insumos;
	}
	
	public PedidoInsumo getPedido(Long id) {		
		Session session = this.openSession();
		Query query = session.createQuery("from PedidoInsumoEntity where id = :idPedido");
		query.setParameter("idPedido", id);
		PedidoInsumoEntity pedidoInsumoEntity = (PedidoInsumoEntity) query.uniqueResult();
		
		return pedidoInsumoEntity.toBO();
	}
	

	public PedidoInsumo update(PedidoInsumo pedido) {
		return save(pedido);
	}

	public List<PedidoInsumo> GetPedidosPendientesInsumo(Insumo insumo) {
		List<PedidoInsumo> retorno = new ArrayList<PedidoInsumo>();
		Session session = this.openSession();
		Query query = session.createQuery("from PedidoInsumoEntity pie where  pie.estado != 'TERMINADO' and pie.insumo.id = :idInsumo");
		query.setParameter("idInsumo", insumo.getId());
		List<PedidoInsumoEntity> ped = (List<PedidoInsumoEntity>) query.list();
		for(PedidoInsumoEntity pe : ped){
			retorno.add(pe.toBO());
		}
		return retorno;
	}

	public boolean hayPedidoPendiente(Insumo insumo, OrdenProduccion ordenProduccion) {
		Session session = this.openSession();
		Query query = session.createQuery("select pie from PedidoInsumoEntity pie join pie.ordenesProduccion ope where"
				+ " pie.estado != 'TERMINADO' and pie.insumo.id = :idInsumo and ope.id =:idOrden");
		query.setParameter("idInsumo", insumo.getId());
		query.setParameter("idOrden", ordenProduccion.getId());
		List<PedidoInsumoEntity> ped = (List<PedidoInsumoEntity>) query.list();	
		return !ped.isEmpty();
	}

}
