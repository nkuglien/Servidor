package dao;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.InsumoEntity;
import model.Insumo;

public class InsumoDAO extends HibernateDAO {
	
	private static InsumoDAO instancia = null;

	public static InsumoDAO getInstance(){
		if(instancia == null) {
			instancia = new InsumoDAO();
		} 
		return instancia;
	}
	
	public void save(Insumo insumo) {
		Session session = this.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new InsumoEntity(insumo));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Insumo findByCodigo(Long codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
		query.setParameter("codigo", codigo);
		InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
		return insumo.toBusinessObject();
	}

}
