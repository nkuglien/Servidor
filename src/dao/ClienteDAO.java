package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DTO.ClienteDTO;
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
		return clienteEntity.toBO();
	}

	public ClienteDTO findClienteByCuit(String cuit) {
		return null;
	}

	public ClienteDTO update(ClienteDTO cliente) {
		return null;
	}
	
}
