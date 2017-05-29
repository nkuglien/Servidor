package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.AreaProduccionEntity;
import model.AreaProduccion;

public class AreaProduccionDAO extends HibernateDAO {
	
	private static AreaProduccionDAO instancia = null;

	public static AreaProduccionDAO getInstance(){
		if(instancia == null) {
			instancia = new AreaProduccionDAO();
		} 
		return instancia;
	}

	public AreaProduccion save(AreaProduccion area) {
		Session session = this.openSession();
		session.beginTransaction();
		
		AreaProduccionEntity entity = new AreaProduccionEntity(area);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return entity.toBO();
	}

	public List<AreaProduccion> getAllAreasProduccion() {
		List<AreaProduccion> areas = new ArrayList<AreaProduccion>();
		Session session = this.openSession();
		Query query = session.createQuery("from AreaProduccionEntity");
		List<AreaProduccionEntity> areasEntity = query.list();
		for (AreaProduccionEntity areaEntity : areasEntity) {
			areas.add(areaEntity.toBO());
		}
		return areas;
	}
	
	public AreaProduccion findAreaByCodigo(int codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from AreaProduccionEntity where codigo = :codigo ");
		query.setParameter("codigo", codigo);
		AreaProduccionEntity areaEntity = (AreaProduccionEntity) query.uniqueResult();
		return areaEntity != null? areaEntity.toBO() : null;
	}
	
}
