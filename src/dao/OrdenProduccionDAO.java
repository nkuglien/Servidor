package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DTO.OrdenProduccionDTO;
import entities.OrdenProduccionEntity;
import entities.PedidoInsumoEntity;
import model.Insumo;
import model.OrdenProduccion;
import model.PedidoInsumo;

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
		session.close();
		return ope.toBO();
	}
	
	//public Insumo findByCodigo(long codigo) {
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
	//	query.setParameter("codigo", codigo);
	//	InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
	//	return insumo != null? insumo.toBO() : null;
	//}
	
	public List<OrdenProduccion> getAll() {
		List<OrdenProduccion> retorno = new ArrayList<OrdenProduccion>();
		Session session = this.openSession();
		Query query = session.createQuery("from OrdenProduccionEntity");
		List<OrdenProduccionEntity> entity =  query.list();
		for (OrdenProduccionEntity or : entity) {
			retorno.add(or.toBO());
		}
		return retorno;
	}

	public OrdenProduccion getByID(Long id) {
			Session session = this.openSession();
			Query query = session.createQuery("from OrdenProduccionEntity where id = :idOrden ");
			query.setParameter("idOrden", id);
			OrdenProduccionEntity orden = (OrdenProduccionEntity) query.uniqueResult();
			return orden != null? orden.toBO() : null;
	}

	


}
