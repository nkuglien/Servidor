package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.InsumoEntity;
import entities.PedidoInsumoEntity;
import model.Insumo;
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
		session.saveOrUpdate(new PedidoInsumoEntity(insumo));		
		session.flush();
		session.getTransaction().commit();
		session.close();
		return insumo;
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

	public PedidoInsumo update(PedidoInsumo pedido) {
		return save(pedido);
	}

	public List<PedidoInsumo> GetPedidosPendientesInsumo(Insumo insumo) {
		// TODO Auto-generated method stub
		return null;
	}

}
