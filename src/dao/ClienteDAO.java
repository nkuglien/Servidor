package dao;

import org.hibernate.Session;

import entities.ClienteEntity;
import model.Cliente;

public class ClienteDAO extends HibernateDAO {
	
	private static ClienteDAO instancia = null;

	public static ClienteDAO getInstance(){
		if(instancia == null) {
			instancia = new ClienteDAO();
		} 
		return instancia;
	}
	
	public void save(Cliente cliente) {
		Session session = this.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new ClienteEntity(cliente));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
}
