package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.OrdenProduccionEntity;
import entities.PedidoClienteEntity;
import entities.VariedadPrendaEntity;
import model.OrdenProduccion;
import model.PedidoCliente;
import model.VariedadPrenda;

public class OrdenProduccionDAO extends HibernateDAO {
	
	private static OrdenProduccionDAO instancia = null;

	public static OrdenProduccionDAO getInstance(){
		if(instancia == null) {
			instancia = new OrdenProduccionDAO();
		} 
		return instancia;
	}
	
	public OrdenProduccion save(OrdenProduccion orden) {
		Session session = this.openSession();
		session.beginTransaction();		
		OrdenProduccionEntity ope = new OrdenProduccionEntity(orden);
		session.saveOrUpdate(ope);		
		session.flush();
		session.getTransaction().commit();
		OrdenProduccion toReturn = ope.toBO();
		session.close();
		return toReturn;
	}
	
	//public Insumo findByCodigo(long codigo) {
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
	//	query.setParameter("codigo", codigo);
	//	InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
	//	return insumo != null? insumo.toBO() : null;
	//}
	
	@SuppressWarnings("unchecked")
	public List<OrdenProduccion> getAll() {
		List<OrdenProduccion> retorno = new ArrayList<OrdenProduccion>();
		Session session = this.openSession();
		Query query = session.createQuery("from OrdenProduccionEntity");
		List<OrdenProduccionEntity> entity =  query.list();
		for (OrdenProduccionEntity or : entity) {
			retorno.add(or.toBO());
		}
		session.close();
		return retorno;
	}

	public OrdenProduccion getByID(Long id) {
		Session session = this.openSession();
		Query query = session.createQuery("from OrdenProduccionEntity where id = :idOrden ");
		query.setParameter("idOrden", id);
		OrdenProduccionEntity orden = (OrdenProduccionEntity) query.uniqueResult();
		OrdenProduccion toReturn = orden != null? orden.toBO() : null;
		session.close();
		return toReturn;
	}

	public boolean existenOrdenesPendiente(VariedadPrenda var, PedidoCliente pedidoCliente) {
		Session session = this.openSession();
		Query query = session.createQuery("from OrdenProduccionEntity");
		List<OrdenProduccionEntity> entity =  query.list();
		boolean retorno = false;
		for (OrdenProduccionEntity or : entity) {
			for(VariedadPrendaEntity variedad : or.getVariedades()) {
				for(PedidoClienteEntity pedido : or.getPedidoCliente()) {
					if(variedad.getId()==var.getId() && pedido.getNroPedido()==pedidoCliente.getNroPedido())
						retorno = true;
				}
			}
		}
		session.close();
		return retorno;
	}


}
