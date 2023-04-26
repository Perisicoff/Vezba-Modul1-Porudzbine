package UI;


import java.sql.Connection;
import java.sql.DriverManager;

import Util.Meni;
import Util.Meni.FunkcionalnaStavkaMenija;
import Util.Meni.IzlaznaStavkaMenija;
import Util.Meni.StavkaMenija;



public class Application {

	
		private static void initDatabase() throws Exception {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/porudzbine?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
					"root", 
					"root");
			
			
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
			Meni.pokreni("", new StavkaMenija[] {
				new IzlaznaStavkaMenija("Izlaz"),
				new FunkcionalnaStavkaMenija("") {

					@Override
					public void izvrsi() {  }
					
				}, 
				new FunkcionalnaStavkaMenija("") {

					@Override
					public void izvrsi() {  }
					
				}, 
				new FunkcionalnaStavkaMenija("") {

					@Override
					public void izvrsi() {  }
					
				},
				new FunkcionalnaStavkaMenija("") {

					@Override
					public void izvrsi() {  }
					
				}
			});
		}


}
