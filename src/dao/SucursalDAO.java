package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.SucursalEntity;
import model.Sucursal;

public class SucursalDAO extends HibernateDAO {
	
	private static SucursalDAO instancia = null;

	public static SucursalDAO getInstance(){
		if(instancia == null) {
			instancia = new SucursalDAO();
		} 
		return instancia;
	}
	
	public Sucursal save(Sucursal sucursal) {
		Session session = this.openSession();
		session.beginTransaction();
		
		SucursalEntity entity = new SucursalEntity(sucursal);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return entity.toBO();
	}

	public List<Sucursal> getAllSucursales() {
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		Session session = this.openSession();
		Query query = session.createQuery("from SucursalEntity");
		List<SucursalEntity> sucursalesEntity = query.list();
		for (SucursalEntity sucursalEntity : sucursalesEntity) {
			sucursales.add(sucursalEntity.toBO());
		}
		return sucursales;
	}
	
	public Sucursal findSucursalByNumero(int numero) {
		Session session = this.openSession();
		Query query = session.createQuery("from SucursalEntity where numero = :numero");
		query.setParameter("numero", numero);
		SucursalEntity sucursalEntity = (SucursalEntity) query.uniqueResult();
		return sucursalEntity != null? sucursalEntity.toBO() : null;
	}

	
	public void BajaSucursal(int numero) {
		Session session = this.openSession();
		Query query = session.createQuery("from SucursalEntity where numero = :numero");
		query.setParameter("numero", numero);
		SucursalEntity sucursalEntity = (SucursalEntity) query.uniqueResult();
		sucursalEntity.setActivo(false);
		session.saveOrUpdate(sucursalEntity);		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public boolean ExisteSucursal(int numero) {
		Session session = this.openSession();
		Query query = session.createQuery("from SucursalEntity where numero = :numero");
		query.setParameter("numero", numero);
		SucursalEntity sucursalEntity = (SucursalEntity) query.uniqueResult();
		return sucursalEntity !=null;
	}
}
