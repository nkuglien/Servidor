package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.ProveedorEntity;
import model.Proveedor;

public class ProveedorDAO extends HibernateDAO {
	
	private static ProveedorDAO instancia = null;

	public static ProveedorDAO getInstance(){
		if(instancia == null) {
			instancia = new ProveedorDAO();
		} 
		return instancia;
	}

	public void save(Proveedor proveedor) {
		Session session = this.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new ProveedorEntity(proveedor));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Proveedor> getAllProveedores() {
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		Session session = this.openSession();
		Query query = session.createQuery("from ProveedorEntity");
		List<ProveedorEntity> proveedoresEntity = query.list();
		for (ProveedorEntity proveedorEntity : proveedoresEntity) {
			proveedores.add(proveedorEntity.toBO());
		}
		return proveedores;
	}
	
	public Proveedor findProveedorById(long id) {
		Session session = this.openSession();
		Query query = session.createQuery("from ProveedorEntity where id = :id");
		query.setParameter("id", id);
		ProveedorEntity proveedorEntity = (ProveedorEntity) query.uniqueResult();
		return proveedorEntity != null? proveedorEntity.toBO() : null;
	}

}
