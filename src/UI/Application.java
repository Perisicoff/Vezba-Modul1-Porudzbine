package UI;


import java.sql.Connection;
import java.sql.DriverManager;

import DAO.ProizvodDAO;
import DatabaseDAO.DatabaseProizvodDAO;
import Util.Meni;
import Util.Meni.FunkcionalnaStavkaMenija;
import Util.Meni.IzlaznaStavkaMenija;
import Util.Meni.StavkaMenija;



public class Application {

	
		private static void initDatabase() throws Exception {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/porudzbine?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
					"root", 
					"root");
			
			ProizvodDAO proizvodDAO = new DatabaseProizvodDAO(conn);
			
			ProizvodUI.setProizvodDAO(proizvodDAO);
			
		}
		
		static {
			try {
				initDatabase();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Greška pri povezivanju sa izvorom podataka!");
				
				System.exit(1); 
			}
		}

		public static void main(String[] args) throws Exception {
			Meni.pokreni("Porudzbine", new StavkaMenija[] {
				new IzlaznaStavkaMenija("Izlaz"),
				new FunkcionalnaStavkaMenija("Prikaz svih proizvoda") {

					@Override
					public void izvrsi() { ProizvodUI.prikazSvihProizvoda(); }
					
				}, 
				new FunkcionalnaStavkaMenija("Prikaz svih porudzbina") {

					@Override
					public void izvrsi() {  }
					
				}, 
				new FunkcionalnaStavkaMenija("Dodavanje porudzbine") {

					@Override
					public void izvrsi() {  }
					
				},
				new FunkcionalnaStavkaMenija("Izvestaj") {

					@Override
					public void izvrsi() {  }
					
				}
			});
		}


}
