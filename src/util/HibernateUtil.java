package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.InsumoEntity;
import entities.InsumoProveedorEntity;
import entities.ItemInsumoEntity;
import entities.ItemPedidoClienteEntity;
import entities.MovimientoCCEntity;
import entities.PedidoClienteEntity;
import entities.PrendaEntity;
import entities.ProveedorEntity;
import entities.ValorConsignacionEntity;
import entities.VariedadPrendaEntity;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration();
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(CuentaCorrienteEntity.class);
			config.addAnnotatedClass(MovimientoCCEntity.class);
			config.addAnnotatedClass(ValorConsignacionEntity.class);
			config.addAnnotatedClass(PedidoClienteEntity.class);
			config.addAnnotatedClass(ItemPedidoClienteEntity.class);
			config.addAnnotatedClass(VariedadPrendaEntity.class);
			config.addAnnotatedClass(PrendaEntity.class);
			config.addAnnotatedClass(ItemInsumoEntity.class);
			config.addAnnotatedClass(InsumoEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
			config.addAnnotatedClass(InsumoProveedorEntity.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
