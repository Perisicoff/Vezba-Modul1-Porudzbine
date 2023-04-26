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
			for (Proizvod proizvod : proizvodi) {
				System.out.println(proizvod);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
