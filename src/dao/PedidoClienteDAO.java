package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
		Session session = this.openSession();
		Query query = session.createQuery("from PedidoClienteEntity where nroPedido = :nroPedido");
		query.setParameter("nroPedido", nroPedido);
		PedidoClienteEntity pedidoClienteEntity = (PedidoClienteEntity) query.uniqueResult();
		PedidoCliente toReturn = pedidoClienteEntity != null ? pedidoClienteEntity.toBO(true) : null;
		session.close();//SESSIONCLOSE
		return toReturn;
	}

	public PedidoCliente save(PedidoCliente pedidoCliente) {
		PedidoClienteEntity entity = null;
		PedidoCliente toReturn = null;
		Session session = null;
		try {
			session = this.openSession();
			session.beginTransaction();
		
			entity = new PedidoClienteEntity(pedidoCliente, true);
			session.saveOrUpdate(entity);
		
			session.flush();
			session.getTransaction().commit();
			toReturn = entity.toBO(true);
		} catch (RuntimeException re) {
			re.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
		return toReturn;
	}

	public List<PedidoCliente> getAllPedidos() {
		List<PedidoCliente> pedidos = new ArrayList<PedidoCliente>();
		Session session = this.openSession();
		Query query = session.createQuery("from PedidoClienteEntity");
		List<PedidoClienteEntity> pedidosEntity = query.list();
		for (PedidoClienteEntity pedidoEntity : pedidosEntity) {
			pedidos.add(pedidoEntity.toBO(true));
		}
		session.close();//SESSIONCLOSE
		return pedidos;
	}

	public List<PedidoCliente> getPedidosByCliente(String cuit) {
		List<PedidoCliente> pedidos = new ArrayList<PedidoCliente>();
		Session session = this.openSession();
		Query query = session.createQuery("from PedidoClienteEntity p where p.cliente.cuit = :cuit");
		query.setParameter("cuit", cuit);
		List<PedidoClienteEntity> pedidosEntity = query.list();
		for (PedidoClienteEntity pedidoEntity : pedidosEntity) {
			pedidos.add(pedidoEntity.toBO(true));
		}
		session.close();//SESSIONCLOSE
		return pedidos;
	}


}
