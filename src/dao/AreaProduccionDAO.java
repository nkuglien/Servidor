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

	public void save(AreaProduccion area) {
		Session session = this.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new AreaProduccionEntity(area));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<AreaProduccion> getAllAreasProduccion() {
		List<AreaProduccion> areas = new ArrayList<AreaProduccion>();
		Session session = this.openSession();
		Query query = session.createQuery("from AreaProduccionEntity");
		List<AreaProduccionEntity> areasEntity = query.list();
		for (AreaProduccionEntity areaEntity : areasEntity) {
			areas.add(areaEntity.toBusinessObject());
		}
		return areas;
	}
	
}
