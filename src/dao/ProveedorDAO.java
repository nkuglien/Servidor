package dao;

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

}
