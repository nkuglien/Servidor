package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.ClienteEntity;
import entities.PrendaEntity;
import model.Cliente;
import model.Prenda;

public class PrendaDAO extends HibernateDAO {
	
	private static PrendaDAO instancia = null;

	public static PrendaDAO getInstance(){
		if(instancia == null) {
			instancia = new PrendaDAO();
		} 
		return instancia;
	}
	
	public Prenda save(Prenda cliente) {
		Session session = this.openSession();
		session.beginTransaction();
		
		PrendaEntity entity = new PrendaEntity(cliente);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return entity.toBO();
	}

	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = this.openSession();
		Query query = session.createQuery("from ClienteEntity");
		List<ClienteEntity> clientesEntity = query.list();
		for (ClienteEntity clienteEntity : clientesEntity) {
			clientes.add(clienteEntity.toBO());
		}
		return clientes;
	}

}
