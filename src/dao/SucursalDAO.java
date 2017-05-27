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
	
	public void save(Sucursal sucursal) {
		Session session = this.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new SucursalEntity(sucursal));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
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
		return sucursalEntity.toBO();
	}

}
