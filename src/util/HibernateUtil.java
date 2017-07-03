package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.AreaProduccionEntity;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.FacturaEntity;
import entities.InsumoEntity;
import entities.InsumoProveedorEntity;
import entities.ItemInsumoEntity;
import entities.ItemPedidoClienteEntity;
import entities.LoteEntity;
import entities.LoteInsumoEntity;
import entities.LoteVariedadPrendaEntity;
import entities.MovimientoCCEntity;
import entities.OrdenProduccionEntity;
import entities.PedidoClienteEntity;
import entities.PedidoInsumoEntity;
import entities.PosicionEntity;
import entities.PrendaAreaProduccionEntity;
import entities.PrendaEntity;
import entities.ProveedorEntity;
import entities.ReservaInsumoEntity;
import entities.ReservaVariedadPrendaEntity;
import entities.SucursalEntity;
import entities.ValorConsignacionEntity;
import entities.VariedadPrendaEntity;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration();
			config.addAnnotatedClass(AreaProduccionEntity.class);
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(CuentaCorrienteEntity.class);
			config.addAnnotatedClass(InsumoEntity.class);
			config.addAnnotatedClass(InsumoProveedorEntity.class);
			config.addAnnotatedClass(ItemInsumoEntity.class);
			config.addAnnotatedClass(ItemPedidoClienteEntity.class);
			config.addAnnotatedClass(MovimientoCCEntity.class);
			config.addAnnotatedClass(PedidoClienteEntity.class);
			config.addAnnotatedClass(PrendaAreaProduccionEntity.class);
			config.addAnnotatedClass(PrendaEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(ValorConsignacionEntity.class);
			config.addAnnotatedClass(VariedadPrendaEntity.class);
			config.addAnnotatedClass(OrdenProduccionEntity.class);
			config.addAnnotatedClass(PosicionEntity.class);
			config.addAnnotatedClass(ReservaInsumoEntity.class);
			config.addAnnotatedClass(LoteEntity.class);
			config.addAnnotatedClass(LoteInsumoEntity.class);
			config.addAnnotatedClass(LoteVariedadPrendaEntity.class);
			config.addAnnotatedClass(PedidoInsumoEntity.class);
			config.addAnnotatedClass(ReservaVariedadPrendaEntity.class);
			config.addAnnotatedClass(FacturaEntity.class);
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
