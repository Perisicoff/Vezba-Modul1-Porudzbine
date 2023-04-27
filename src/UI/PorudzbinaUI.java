package UI;

import java.time.LocalDateTime;
import java.util.Collection;

import DAO.PorudzbinaDAO;
import Model.Porudzbina;
import Model.Proizvod;
import Util.Konzola;

public class PorudzbinaUI {
	
	private static PorudzbinaDAO porudzbinaDAO;

	public static void setPorudzbinaDAO(PorudzbinaDAO porudzbinaDAO) {
		PorudzbinaUI.porudzbinaDAO = porudzbinaDAO;
	}

	public static void prikazSvihPorudzbina() {

		try {
			Collection<Porudzbina> porudzbine = porudzbinaDAO.getAll();
			String Headher = String.format("%-10s %-20s %-20s %-15s %-20s", "ID", "Datum i Vreme", "Ulica", "Broj", "Proizvod");
			System.out.println(Headher);
			System.out.println("========== ==================== ==================== =============== ====================");
			for (Porudzbina porudzbina : porudzbine) {
				String foother = String.format("%-10s %-20s %-20s %-15s %-20s", porudzbina.getId(), porudzbina.getDatumIVreme(), porudzbina.getUlica(), porudzbina.getBroj(), porudzbina.getProizvod().getNaziv());
				System.out.println(foother);
				System.out.println("---------- -------------------- -------------------- --------------- --------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public static void novaPorudzbina() {
		ProizvodUI.prikazSvihProizvoda();
		long id = Konzola.ocitajLong("Unesite id proizvoda: ");
		Proizvod proizvod = ProizvodUI.pretragaProizvoda(id);
		if (proizvod == null) {
			return;
		}
		String ulica = "";
		while (ulica.equals("")) {
			ulica = Konzola.ocitajString("Unesite naziv ulice: ");
		}
		int broj = Konzola.ocitajInt("Unesite broj: ");
		LocalDateTime datum = LocalDateTime.now();
		Porudzbina porudzbina = new Porudzbina(datum, ulica, broj, proizvod);
		try {
			porudzbinaDAO.add(porudzbina);
			System.out.println("Uspesno ste dodali novu porudzbinu!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
