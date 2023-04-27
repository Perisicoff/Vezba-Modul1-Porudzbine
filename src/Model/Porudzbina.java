package Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Porudzbina {

	private long id;
	private LocalDateTime datumIVreme = LocalDateTime.now();
	private String ulica = "";
	private int broj;

	private Proizvod proizvod;
	
	public boolean isDatumUOpsegu(LocalDateTime pocetni, LocalDateTime krajnji) {
		return datumIVreme.compareTo(pocetni) >= 0 && datumIVreme.compareTo(krajnji) <= 0;
		
	}

	public Porudzbina() {
		super();
	}

	public Porudzbina(LocalDateTime datumIVreme, String ulica, int broj, Proizvod proizvod) {
		super();
		this.datumIVreme = datumIVreme;
		this.ulica = ulica;
		this.broj = broj;
		this.proizvod = proizvod;
	}

	public Porudzbina(long id, LocalDateTime datumIVreme, String ulica, int broj, Proizvod proizvod) {
		super();
		this.id = id;
		this.datumIVreme = datumIVreme;
		this.ulica = ulica;
		this.broj = broj;
		this.proizvod = proizvod;
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
		Porudzbina other = (Porudzbina) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Porudzbina [id=" + id + ", datumIVreme=" + datumIVreme + ", ulica=" + ulica + ", broj=" + broj
				+ ", proizvod=" + proizvod.getNaziv() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(LocalDateTime datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}
