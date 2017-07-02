package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.ValorConsignacionEntity;
import model.Cliente;
import model.CuentaCorriente;
import model.ValorConsignacion;

public class ClienteDAO extends HibernateDAO {

	private static ClienteDAO instancia = null;

	public static ClienteDAO getInstance() {
		if (instancia == null) {
			instancia = new ClienteDAO();
		}
		return instancia;
	}

	public Cliente save(Cliente cliente) {
		ClienteEntity entity = null;
		Cliente clienteToReturn = null;
		Session session = null;
		try {
			session = this.openSession();
			session.beginTransaction();
		
			entity = new ClienteEntity(cliente);
			session.saveOrUpdate(entity);
		
			session.flush();
			session.getTransaction().commit();
			clienteToReturn = entity.toBO();
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		return clienteToReturn;
	}

	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = this.openSession();
		Query query = session.createQuery("from ClienteEntity");
		List<ClienteEntity> clientesEntity = query.list();
		for (ClienteEntity clienteEntity : clientesEntity) {
			clientes.add(clienteEntity.toBO());
		}
		session.close();//SESSIONCLOSE
		return clientes;
	}

	public Cliente findClienteByNroCliente(long nroCliente) {
		Session session = this.openSession();
		Query query = session.createQuery("from ClienteEntity where nroCliente = :nroCliente");
		query.setParameter("nroCliente", nroCliente);
		ClienteEntity clienteEntity = (ClienteEntity) query.uniqueResult();
		Cliente clienteToReturn = clienteEntity != null ? clienteEntity.toBO() : null;
		session.close();//SESSIONCLOSE
		return clienteToReturn;
	}

	public Cliente findClienteByCuit(String cuit) {
		Session session = this.openSession();
		Query query = session.createQuery("from ClienteEntity where cuit = :cuit");
		query.setParameter("cuit", cuit);
		ClienteEntity clienteEntity = (ClienteEntity) query.uniqueResult();
		Cliente clienteToReturn = clienteEntity != null ? clienteEntity.toBO() : null;
		session.close();//SESSIONCLOSE
		return clienteToReturn;
	}

	public CuentaCorriente save(CuentaCorriente cuentaCorriente) {
		Session session = this.openSession();
		session.beginTransaction();

		CuentaCorrienteEntity entity = new CuentaCorrienteEntity(cuentaCorriente);
		session.saveOrUpdate(entity);

		session.flush();
		session.getTransaction().commit();
		
		CuentaCorriente ccToReturn = entity.toBO();
		session.close();
		return ccToReturn;
	}

	public Cliente update(Cliente cliente) {
		return save(cliente);
	}

	public void baja(Cliente cliente) {
		Session session = this.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update ClienteEntity set activo = false where id = :id");
		query.setParameter("id", cliente.getId());
		query.executeUpdate();
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public ValorConsignacion findValorConsignacion(long idValorConsignado) {
		Session session = this.openSession();
		Query query = session.createQuery("from ValorConsignacionEntity where id = :idValorConsignado");
		query.setParameter("id", idValorConsignado);
		ValorConsignacionEntity valorConsignacionEntity = (ValorConsignacionEntity) query.uniqueResult();
		ValorConsignacion vaToReturn = valorConsignacionEntity != null ? valorConsignacionEntity.toBO() : null;
		session.close();//SESSIONCLOSE
		return vaToReturn;
	}

}
