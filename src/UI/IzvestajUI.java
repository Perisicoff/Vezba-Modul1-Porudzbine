package UI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import DAO.PorudzbinaDAO;
import DAO.ProizvodDAO;
import Model.Porudzbina;
import Model.Proizvod;
import Model.StavkaIzvestaja;
import Util.Konzola;

public class IzvestajUI {

	private static ProizvodDAO proizvodDAO;
	private static PorudzbinaDAO porudzbinaDAO;

	public static void setProizvodDAO(ProizvodDAO proizvodDAO) {
		IzvestajUI.proizvodDAO = proizvodDAO;
	}

	public static void setPorudzbinaDAO(PorudzbinaDAO porudzbinaDAO) {
		IzvestajUI.porudzbinaDAO = porudzbinaDAO;
	}

	public static void izvestaj() {

		LocalDateTime pocetniDatum = Konzola.ocitajDateTime("Unesite pocetni datum pretrage: ");
		LocalDateTime krajnjiDatum = Konzola.ocitajDateTime("Unesite krajnji datum pretrage: ");

		try {
			List<StavkaIzvestaja> izvestaji = new ArrayList<>();
			Collection<Proizvod> proizvodi = proizvodDAO.getAll();
			Collection<Porudzbina> porudzbine = porudzbinaDAO.getAll();
			for (Proizvod proizvod : proizvodi) {
				long sifra = proizvod.getSifra();
				String naziv = proizvod.getNaziv();
				double prihod = 0;
				LocalDateTime datum = LocalDateTime.MIN;
				for (Porudzbina porudzbina : porudzbine) {
					if (porudzbina.isDatumUOpsegu(pocetniDatum, krajnjiDatum)) {

						if (porudzbina.getProizvod().getSifra() == proizvod.getSifra()) {
							if (proizvod.isBesplatnaDostava()) {
								prihod += proizvod.getCena();

							} else {
								prihod += proizvod.getCena() + 1000;
							}
							if (porudzbina.getDatumIVreme().isAfter(datum)) {
								datum = porudzbina.getDatumIVreme();
							}
						}
					}
				}

				StavkaIzvestaja stavka = new StavkaIzvestaja(sifra, naziv, prihod, datum);
				izvestaji.add(stavka);
			}
			izvestaji.sort(StavkaIzvestaja::comparePrihod);
			for (StavkaIzvestaja stavka : izvestaji) {
				System.out.println(stavka);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Došlo je do greške!");
		}

	}
}
