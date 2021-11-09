package esempiohibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;

import esempiohibernate.Autore;

public class Manager {
	private AutoreDao autoreDao;
	private LibroDao libroDao;
//	Scanner input = new Scanner(System.in);
	public Manager (AutoreDao autoreDao, LibroDao libroDao){
		this.autoreDao = autoreDao;
		this.libroDao = libroDao;
	}

	public void creaAutore() {
		EntityTransaction t=autoreDao.getEntityManager().getTransaction();
		t.begin();
		Scanner in = new Scanner(System.in);
		System.out.println("inserisci id autore");
		int idAutore=in.nextInt();
		System.out.println("inserisci nome autore");
		String nome=in.next();
		System.out.println("inserisci cognome autore");
		String cognome=in.next();
		System.out.println("inserisci eta' autore");
		int eta=in.nextInt();
		Autore autore=new Autore();
		autore.setIdAutore(idAutore);
		autore.setNome(nome);
		autore.setCognome(cognome);
		autore.setEta(eta);
		autoreDao.save(autore);
		System.out.println("Ho inserito su database l'autore :" +autore);
		t.commit();
	}

	public void cancellaAutore() {
		EntityTransaction t1=autoreDao.getEntityManager().getTransaction();
		t1.begin();
		Scanner inp = new Scanner(System.in);
//		System.out.println("inserisci id autore da cancellare");
//		int idAutore1=inp.nextInt();
		System.out.println("inserisci nome autore da cancellare");
		String nome1=inp.next();
		System.out.println("inserisci cognome autore da cancellare");
		String cognome1=inp.next();
		Autore autore2=new Autore();
//		autore2.setIdAutore(idAutore1);
		autore2.setNome(nome1);
		autore2.setCognome(cognome1);
		autoreDao.delete(autore2);
		System.out.println("Ho cancellato l'autore");
		t1.commit();
	}

	public void ricercaAutore() {
		EntityTransaction t2=autoreDao.getEntityManager().getTransaction();
		t2.begin();
		Scanner inpu = new Scanner(System.in);
		System.out.println("inserisci cognnome autore da ricercare");
		String cognome2=inpu.next();
		List<Autore> autoriPerCognome=autoreDao.getByCognome(cognome2);
		System.out.println("Ho cercato gli autori di nome" + cognome2 +" trovato: " +autoriPerCognome);
		t2.commit();
	}

	public void ricercaTuttiGliAutori() {
		EntityTransaction t3=autoreDao.getEntityManager().getTransaction();
		t3.begin();
		List<Autore> tuttiGliAutori=autoreDao.getAll();
		System.out.println("Ho cercato tutti gli autori, ecco cosa ho trovato: " +tuttiGliAutori);
		t3.commit();
	}
}
