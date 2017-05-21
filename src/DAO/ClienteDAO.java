package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Cliente;

public class ClienteDAO {

	private static ClienteDAO clienteDAO;
	
	public static ClienteDAO getInstancia(){
		if(clienteDAO == null)
			clienteDAO = new ClienteDAO();
		return clienteDAO;
	}
	
	public List<Cliente> GetClientes() {
		Session s = HibernateDAO.getInstancia().getSession();
		Transaction t = s.beginTransaction();
		List<Cliente> repuestos = s.createQuery("SELECT C FROM ClienteEntity C").list();
		t.commit();
		return repuestos;
	}
}
