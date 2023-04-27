package Model;

import java.time.LocalDateTime;

public class StavkaIzvestaja {

	private long sifraProizvoda;
	private String nazivProizvoda = "";
	private double prihod;
	private LocalDateTime datumPoslednjeProdaje;

	public StavkaIzvestaja(long sifraProizvoda, String nazivProizvoda, double prihod,
			LocalDateTime datumPoslednjeProdaje) {
		super();
		this.sifraProizvoda = sifraProizvoda;
		this.nazivProizvoda = nazivProizvoda;
		this.prihod = prihod;
		this.datumPoslednjeProdaje = datumPoslednjeProdaje;
	}

	@Override
	public String toString() {
		return "Izvestaj:   Sifra: " + sifraProizvoda + "   Naziv: " + nazivProizvoda + "   Prihod: " + prihod
				+ "   Datum poslednje prodaje: " + datumPoslednjeProdaje;
	}

	public static int comparePrihod(StavkaIzvestaja stavka1, StavkaIzvestaja stavka2) {
		return -Double.compare(stavka1.prihod, stavka2.prihod);
	}

}
