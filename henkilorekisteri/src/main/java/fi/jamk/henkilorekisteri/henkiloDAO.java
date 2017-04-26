package fi.jamk.henkilorekisteri;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("henkiloDao")
@Transactional(propagation = Propagation.REQUIRED)
public class henkiloDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public henkiloDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<henkilo> getAll() {
        
		List<henkilo> person = (List<henkilo>) em.createQuery("select t from henkilo t").getResultList();
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public List<henkilo> getByName(String name) {
		
		List<henkilo> person = (List<henkilo>) em.createQuery("select t from henkilo t where t.etunimi=:name")
				.setParameter("name", name).getResultList();
		
		return person;
	}

}
