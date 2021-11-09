package esempiohibernate.dao;

import java.util.List;

import javax.persistence.Query;

import esempiohibernate.Autore;
import esempiohibernate.Libro;

public class LibroDao extends GenericDao {

	public void save(Libro libro) {
		getEntityManager().persist(libro);
	}
	
	public Libro get(int id) {
		return getEntityManager().find(Libro.class, id);
	}
	
	public List<Libro> getAll(){
		Query query=getEntityManager().createNativeQuery("select * from libro", Libro.class);
		return query.getResultList();
	}
	
	public void update(Libro libro, String nuovoTitolo) {
		libro.setTitolo(nuovoTitolo);
		getEntityManager().merge(libro);
	}
	
	public void delete(Libro libro) {
		getEntityManager().remove(libro);
	}
	
	public List<Libro> getByTitolo(String titolo) {
		Query query= getEntityManager().createNativeQuery("select * from titolo where titolo=:parametroTitolo ");
		query.setParameter("parametroTitolo", titolo);
		
		List<Libro> libri=query.getResultList();
		return  libri;
	}
}
