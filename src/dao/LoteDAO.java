package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.LoteEntity;
import entities.LoteInsumoEntity;
import entities.LoteVariedadPrendaEntity;
import model.Insumo;
import model.Lote;
import model.LoteInsumo;
import model.LoteVariedadPrenda;
import model.VariedadPrenda;

public class LoteDAO extends HibernateDAO {

	private static LoteDAO instancia = null;

	public static LoteDAO getInstance(){
		if(instancia == null) {
			instancia = new LoteDAO();
		} 
		return instancia;
	}
	
	public Lote save(Lote lote) {
		Session session = this.openSession();
		session.beginTransaction();	
		LoteEntity le = null;
		if(lote instanceof LoteInsumo){
			le = new LoteInsumoEntity((LoteInsumo)lote,true);
			session.saveOrUpdate(le);		
		}
		if(lote instanceof LoteVariedadPrenda)  {
			le = new LoteVariedadPrendaEntity((LoteVariedadPrenda)lote, true);
			session.saveOrUpdate(le);	
		}
			
		session.flush();
		session.getTransaction().commit();
		Lote toReturn = le.toBO();
		session.close();
		return toReturn;
	}

	public List<LoteInsumo> getLotesConDisponibles(Insumo insumo) {
		Session session = this.openSession();
		Query query = session.createQuery("select li from LoteInsumoEntity li join li.insumo i where i.id = :idInsumo and li.cantDisponible>0 ");
		query.setParameter("idInsumo", insumo.getId());
		List<LoteInsumoEntity> lotes = (List<LoteInsumoEntity>) query.list();			
		List<LoteInsumo> retorno = new ArrayList<LoteInsumo>();
		for(LoteInsumoEntity lo : lotes){
			retorno.add(lo.toBO());
		}
		session.close();
		return retorno;
	}
	
	public List<LoteVariedadPrenda> getLotesConDisponibles(VariedadPrenda vp) {
		Session session = this.openSession();
		Query query = session.createQuery("select lvp from LoteVariedadPrendaEntity lvp join lvp.variedadPrenda vpe where lvp.cantDisponible > 0 and vpe.id= :idVariedad");
		query.setParameter("idVariedad", vp.getId());
		List<LoteVariedadPrendaEntity> lotes = (List<LoteVariedadPrendaEntity>) query.list();			
		List<LoteVariedadPrenda> lotesBO = new ArrayList<LoteVariedadPrenda>();	
		for(LoteVariedadPrendaEntity lo : lotes){
			lotesBO.add((LoteVariedadPrenda) lo.toBO());
		}
		session.close();
		return lotesBO;
	}
	
	
	public int getStock(VariedadPrenda variedad) {
		Session session = this.openSession();
		Query query = session.createQuery("select lvp from LoteVariedadPrendaEntity lvp join lvp.variedadPrenda vpe where lvp.cantDisponible > 0 and vpe.id= :idVariedad");
		query.setParameter("idVariedad", variedad.getId());
		List<LoteVariedadPrendaEntity> lotes = (List<LoteVariedadPrendaEntity>) query.list();			
		int cantidad =0;
		for(LoteVariedadPrendaEntity lo : lotes){
			cantidad=cantidad + lo.getCantDisponible();
		}
		session.close();
		return cantidad;
	}

	public Integer getStock(Insumo insumo) {
		Session session = this.openSession();
		Query query = session.createQuery("select li from LoteInsumoEntity li join li.insumo ins where li.cantDisponible > 0 and ins.id= :idInsumo");
		query.setParameter("idInsumo", insumo.getId());
		List<LoteInsumoEntity> lotes = (List<LoteInsumoEntity>) query.list();			
		int cantidad =0;
		for(LoteInsumoEntity lo : lotes){
			cantidad=cantidad + lo.getCantDisponible();
		}
		session.close();
		return cantidad;
	}

	public List<LoteVariedadPrenda> getLotesFromOrden(Long idOrdenProduccion) {
		Session session = this.openSession();
		Query query = session.createQuery("from LoteVariedadPrendaEntity lvp  where lvp.ordenProduccion.id = :idOrden");
		query.setParameter("idOrden", idOrdenProduccion);
		List<LoteVariedadPrendaEntity> lotes = (List<LoteVariedadPrendaEntity>) query.list();			
		List<LoteVariedadPrenda> lotesBO = new ArrayList<LoteVariedadPrenda>();	
		for(LoteVariedadPrendaEntity lo : lotes){
			lotesBO.add((LoteVariedadPrenda) lo.toBO());
		}
		session.close();
		return lotesBO;
	}
	
	//public Insumo findByCodigo(long codigo) {
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
	//	query.setParameter("codigo", codigo);
	//	InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
	//	return insumo != null? insumo.toBO() : null;
	//}
	
	

}
