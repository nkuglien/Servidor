package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import model.Cliente;
import model.CuentaCorriente;

public class ClienteDAO extends HibernateDAO {
	
	private static ClienteDAO instancia = null;

	public static ClienteDAO getInstance(){
		if(instancia == null) {
			instancia = new ClienteDAO();
		} 
		return instancia;
	}
	
	public Cliente save(Cliente cliente) {
		Session session = this.openSession();
		session.beginTransaction();
		
		ClienteEntity entity = new ClienteEntity(cliente);
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
	
	public Cliente findClienteByNroCliente(long nroCliente) {
		Session session = this.openSession();
		Query query = session.createQuery("from ClienteEntity where nroCliente = :nroCliente");
		query.setParameter("nroCliente", nroCliente);
		ClienteEntity clienteEntity = (ClienteEntity) query.uniqueResult();
		return clienteEntity != null? clienteEntity.toBO() : null;
	}

	public Cliente findClienteByCuit(String cuit) {
		Session session = this.openSession();
		Query query = session.createQuery("from ClienteEntity where cuit = :cuit");
		query.setParameter("cuit", cuit);
		ClienteEntity clienteEntity = (ClienteEntity) query.uniqueResult();
		return clienteEntity != null? clienteEntity.toBO() : null;
	}

	public CuentaCorriente save(CuentaCorriente cuentaCorriente) {
		Session session = this.openSession();
		session.beginTransaction();
		
		CuentaCorrienteEntity entity = new CuentaCorrienteEntity(cuentaCorriente);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		return entity.toBO();		
	}
	
}
