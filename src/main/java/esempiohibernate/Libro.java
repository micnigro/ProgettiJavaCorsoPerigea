package esempiohibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	@Id
	@Column
	private int isbn;
	@Column(name="titolo")
	private String titolo;
	@Column(name="nPage")
	private int nPage;
	@ManyToOne
	@JoinColumn(name="idAutore")
	private Autore autore;

	public Libro() {}

	public Libro(int isbn, String titolo, int nPage) {
		super();
		this.isbn=isbn;
		this.titolo=titolo;
		this.nPage=nPage;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getnPage() {
		return nPage;
	}

	public void setnPage(int nPage) {
		this.nPage = nPage;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

}
