package dao;

import org.hibernate.Session;

import entities.PedidoClienteEntity;
import model.PedidoCliente;

public class PedidoClienteDAO extends HibernateDAO {
	
	private static PedidoClienteDAO instancia = null;

	public static PedidoClienteDAO getInstance(){
		if(instancia == null) {
			instancia = new PedidoClienteDAO();
		} 
		return instancia;
	}

	public PedidoCliente getByNroPedido(Long nroPedido) {
		//TODO
		return null;
	}

	public PedidoCliente save(PedidoCliente pedidoCliente) {
		PedidoClienteEntity entity = null;
		Session session = null;
		try {
			session = this.openSession();
			session.beginTransaction();
		
			entity = new PedidoClienteEntity(pedidoCliente);
			session.saveOrUpdate(entity);
		
			session.flush();
			session.getTransaction().commit();
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		return entity.toBO(true);
	}


}
