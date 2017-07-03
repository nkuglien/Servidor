package dao;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.FacturaEntity;
import model.Factura;

public class FacturaDAO extends HibernateDAO {
	
	private static FacturaDAO instancia = null;

	public static FacturaDAO getInstance() {
		if (instancia == null) {
			instancia = new FacturaDAO();
		}
		return instancia;
	}

	public Factura save(Factura factura) {
		FacturaEntity entity = null;
		Factura toReturn = null;
		Session session = null;
		try {
			session = this.openSession();
			session.beginTransaction();
		
			entity = new FacturaEntity(factura);
			session.saveOrUpdate(entity);
		
			session.flush();
			session.getTransaction().commit();
			toReturn = entity.toBO();
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		return toReturn;
	}

	public Factura obtenerFactura(Long nroPedido) {
		Session session = this.openSession();
		Query query = session.createQuery("from FacturaEntity where pedidoCliente.nroPedido = :nroPedido");
		query.setParameter("nroPedido", nroPedido);
		FacturaEntity entity = (FacturaEntity) query.uniqueResult();
		Factura toReturn = entity != null ? entity.toBO() : null;
		session.close();
		return toReturn;
	}

}
