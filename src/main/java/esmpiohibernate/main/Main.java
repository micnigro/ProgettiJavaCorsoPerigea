package esmpiohibernate.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;

import esempiohibernate.Autore;
import esempiohibernate.Libro;
import esempiohibernate.dao.AutoreDao;
import esempiohibernate.dao.LibroDao;
import esempiohibernate.dao.Manager;

public class Main {
	public static void main(String[] args) {
		try {
			AutoreDao autoreDao=new AutoreDao();
			LibroDao libroDao=new LibroDao();
			Manager manager= new Manager(autoreDao, libroDao);
			Scanner input = new Scanner(System.in);
			int scelta;
			while (true) {
				System.out.println("premi 0 per uscire");
				System.out.println("premi 1 per creare un autore");
				System.out.println("premi 2 per cancellare un autore");
				System.out.println("premi 3 per cercare un autore");
				System.out.println("premi 4 per cercare tutti gli autori");
				scelta=input.nextInt();
				
				switch(scelta) {
				case 0:
					System.out.println("programma terminato");
					input.close();
					return;
					
				case 1:
					manager.creaAutore();
					break;
					
				case 2:
					manager.cancellaAutore();
					break;
				
				case 3:
					manager.ricercaAutore();
					break;
					
				case 4:
					manager.ricercaTuttiGliAutori();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRORE! "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Completato");
	}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			/* APRIAMO LA TRANSAZIONE */ 
//			EntityTransaction  t=autoreDao.getEntityManager().getTransaction();
//			t.begin();
//
//			//creo un oggetto Autore e lo salvo su database
//			Autore autore=new Autore();
//			autore.setNome("Alessandro");
//			autore.setCognome("Manzoni");
//			autoreDao.save(autore);
//			System.out.println("Ho inserito su database l'autore :" +autore);
//			
//			//creo un oggetto Autore2 e lo salvo su database
//			Autore autore2=new Autore();
//			autore2.setNome("Dante");
//			autore2.setCognome("Alighieri");
//			autoreDao.save(autore2);
//			System.out.println("Ho inserito su database l'autore :" +autore2);
//			
//			autore2.setNome("pippo"); //vedete cosa fa
//			
//			//cerco su database l'oggetto Autore appena inserito
//			Autore autore3=autoreDao.get(7);
//			System.out.println("Ho cercato l'autore su database, trovato :" +autore3);
//			
//
//			//cerco su database l'oggetto Autore per nome
//			List<Autore> autoriPerNome=autoreDao.getByName("pippo");
//			System.out.println("Ho cercato gli autori di nome pippo, trovato: " +autoriPerNome);
//			
//
//			//cerco su database tutti gli autori
//			List<Autore> tuttiGliAutori=autoreDao.getAll();
//			System.out.println("Ho cercato tutti gli autori, trovato: " +tuttiGliAutori);
//			
//			//cancellare un autore
//			autoreDao.delete(autore2);
//			System.out.println("Ho cancellato l'autore 2 ");
//			tuttiGliAutori=autoreDao.getAll();
//			System.out.println("Ho cercato tutti gli autori, trovato: " +tuttiGliAutori);
//			
//			//creare libro
//			Libro libro= new Libro();
//			libro.setTitolo("divina commedia");
//			libro.setAutore(autore);
//			libroDao.save(libro);
//			System.out.println("Ho salvato un libro: " +libro);
//			
//			// COMMIT DELLA TRANSAZIONE (=salvataggio su db)
//			t.commit();
//			
//			
//			
////		} catch (Exception e) {
////			System.out.println("ERRORE! "+e.getMessage());
////			e.printStackTrace();
////		}
////
////		System.out.println("Completato");
//
//
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//	//	public static void main(String[] args) {
//	//		Dao<Autore> autoreDao= new AutoreDao();
//	//
//	//		for(int i = 1; i <= 5; i++) {
//	//			Autore autore = new Autore();
//	//			autore.setNome("nome"+i);
//	//			autore.setCognome("cognome"+i);
//	//			autoreDao.openCurrentSessionwithTransaction();
//	//			autoreDao.save(autore);
//	//			autoreDao.closeCurrentSessionwithTransaction();
//	//		}
//	//
//	//	}
//}