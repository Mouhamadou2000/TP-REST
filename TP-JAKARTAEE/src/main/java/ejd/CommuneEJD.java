package ejd;

import java.util.ArrayList;
import java.util.List;

import Models.Commune;
import Rest.CommuneRS;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

//@transitional CDI
@Stateless
public class CommuneEJD {
	@PersistenceContext(unitName="TP-JAKARTAEE")
	private EntityManager em;
	
	public long createCommune(Commune commune) {
		em.persist(commune);
		return commune.getId();
	}
	
	public Commune findCommuneById(long Id) {
		
		Commune com=em.find(Commune.class, Id, LockModeType.PESSIMISTIC_READ);
		return com;
	}
	
public Commune update(Commune commune) {
		em.merge(commune);
		return commune;
	}
	
public Boolean deleteCommuneById(long Id) {
	Commune com=findCommuneById(Id);
	if(com!=null) {
		
	    em.remove(com);
	    return true;
	}else {
		return false;
		
	}
	
}

public List<Commune> findAllCommune(){
	List<Commune> list;
	CriteriaBuilder builder = em.getCriteriaBuilder();
	CriteriaQuery<Commune> query = builder.createQuery(Commune.class);
	Root<Commune> i = query.from(Commune.class);
	query.select(i);

	list = em.createQuery(query).getResultList();
	
	return list;
	
}



	

}
