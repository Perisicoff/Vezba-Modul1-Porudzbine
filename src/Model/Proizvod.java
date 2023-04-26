package Model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Proizvod {
	
	private long id;
	private long sifra;
	private String naziv = "";
	private long cena;
	private boolean besplatnaDostava;
	
	private final Set<Porudzbina> porudzbine = new HashSet<>();

	public Proizvod() {
		super();
	}

	public Proizvod(long sifra, String naziv, long cena, boolean besplatnaDostava) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
		this.besplatnaDostava = besplatnaDostava;
	}

	public Proizvod(long id, long sifra, String naziv, long cena, boolean besplatnaDostava) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
		this.besplatnaDostava = besplatnaDostava;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvod other = (Proizvod) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Proizvod [id=" + id + ", sifra=" + sifra + ", naziv=" + naziv + ", cena=" + cena + ", besplatnaDostava="
				+ besplatnaDostava + "]";
	}

	public long getId() {
		return id;
	}

	public long getSifra() {
		return sifra;
	}

	public void setSifra(long sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public long getCena() {
		return cena;
	}

	public void setCena(long cena) {
		this.cena = cena;
	}

	public boolean isBesplatnaDostava() {
		return besplatnaDostava;
	}

	public void setBesplatnaDostava(boolean besplatnaDostava) {
		this.besplatnaDostava = besplatnaDostava;
	}

	public Collection<Porudzbina> getPorudzbine() {
		return Collections.unmodifiableCollection(porudzbine);
	}
	
	

}
