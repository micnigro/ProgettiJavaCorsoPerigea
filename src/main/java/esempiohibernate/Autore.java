package esempiohibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Autore {
	@Id
	@Column
	private int idAutore;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="eta")
	private int eta;
	@OneToMany(mappedBy="autore")
	public List<Libro> libri;

	public Autore() {}

	public Autore(int idAutore, String nome, String cognome, int eta) {
		super();
		this.idAutore=idAutore;
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
	}

	public int getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public List<Libro> getLibri() {
		return libri;
	}
	
	@Override
	public String toString() {
		return "Autore [idAutore=" + idAutore + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}







}
