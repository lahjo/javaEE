package fi.jamk.henkilorekisteri;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
		List<henkilo> person = (List<henkilo>) em.createQuery("select t from henkilo t where CONCAT(t.etunimi, ' ' , t.sukunimi) LIKE :name" )
				.setParameter("name", "%" + name + "%").getResultList();
		
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public List<henkilo> getBySnn(String snn) {
		List<henkilo> person = (List<henkilo>) em.createQuery("select t from henkilo t where t.henkilotunnus=:snn")
				.setParameter("snn", snn).getResultList();
		
		return person;
	}
	
	
	public henkilo inserNewPerson(henkilo person) {
		em.persist(person);
		return person;
	}
	
	public void update (String sukunimi, String henkilotunnus, String puhelinnumero, String sahkoposti,
  			String tyosuhdealkanut, String tilinumero, String veronumero) {
		
		Query query = em.createQuery("UPDATE henkilo t set t.sukunimi=:sukunimi, t.puhelinnumero=:puhelinnumero, t.sahkoposti=:sahkoposti, t.tyosuhdealkanut=:tyosuhdealkanut, t.tilinumero=:tilinumero, t.veronumero=:veronumero WHERE t.henkilotunnus=:henkilotunnus")
					  .setParameter("sukunimi", sukunimi)
					  .setParameter("puhelinnumero", puhelinnumero)
					  .setParameter("sahkoposti", sahkoposti)
					  .setParameter("tyosuhdealkanut", tyosuhdealkanut)
					  .setParameter("tilinumero", tilinumero)
					  .setParameter("veronumero", veronumero)
					  .setParameter("henkilotunnus", henkilotunnus);
		
		query.executeUpdate();

		}
	
	public void delete (String ssn) {
		Query query = em.createQuery("DELETE FROM henkilo t WHERE t.henkilotunnus=:henkilotunnus")
				  .setParameter("henkilotunnus", ssn);
	
		query.executeUpdate();
	}

}
