package esempiohibernate.dao;

import java.util.List;

import javax.persistence.Query;

import esempiohibernate.Autore;

public class AutoreDao extends GenericDao{
	
	public void save(Autore autore) {
		getEntityManager().persist(autore);
	}
	
	public Autore get(int id) {
		return (Autore) getEntityManager().find(Autore.class, id);
	}
	
	public List<Autore> getAll(){
		Query query=getEntityManager().createNativeQuery("select * from autore", Autore.class);
		return query.getResultList();
	}
	
	public void update(Autore autore, String nuovoNome) {
		autore.setNome(nuovoNome);
		getEntityManager().merge(autore);
	}
	
	public void delete(Autore autore) {
		getEntityManager().remove(autore);
	}

	public List<Autore> getByCognome(String cognome) {
		Query query= getEntityManager().createNativeQuery("select * from autore where cognome=:parametroCognome ");
		query.setParameter("parametroCognome", cognome);
		
		List<Autore> autori=query.getResultList();
		return autori;
	}
}






