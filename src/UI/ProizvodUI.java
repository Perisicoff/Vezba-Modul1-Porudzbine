package UI;

import java.util.Collection;

import DAO.ProizvodDAO;
import Model.Proizvod;

public class ProizvodUI {
	
	private static ProizvodDAO proizvodDAO;
	
	public static void setProizvodDAO(ProizvodDAO proizvodDAO) {
		ProizvodUI.proizvodDAO = proizvodDAO;
	}
	
	public static void prikazSvihProizvoda() {

		try {
			Collection<Proizvod> proizvodi = proizvodDAO.getAll();
			String Headher = String.format("%-10s %-15s %-20s %-15s %-20s", "ID", "Sifra", "Naziv", "Cena", "Besplatna dostava");
			System.out.println(Headher);
			System.out.println("========== =============== ==================== =============== ====================");
			for (Proizvod proizvod : proizvodi) {
				String foother = String.format("%-10s %-15s %-20s %-15s %-20s", proizvod.getId(), proizvod.getSifra(), proizvod.getNaziv(), proizvod.getCena(), proizvod.isBesplatnaDostava());
				System.out.println(foother);
				System.out.println("---------- --------------- -------------------- --------------- --------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Proizvod pretragaProizvoda(long id) {
		Proizvod proizvod = null;
		try {
			proizvod = proizvodDAO.get(id);
			if (proizvod == null) {
				System.out.println("Proizvod sa zadatim IDem ne postoji, pokusajte ponovo!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proizvod;
	}

}
