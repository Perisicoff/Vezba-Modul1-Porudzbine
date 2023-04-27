package DatabaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import DAO.ProizvodDAO;
import Model.Proizvod;

public class DatabaseProizvodDAO implements ProizvodDAO {
	
	private final Connection conn;

	public DatabaseProizvodDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Proizvod get(long id) throws Exception {
		Proizvod proizvod = null;

		String sql = "SELECT sifra, naziv, cena, besplatnaDostava FROM proizvodi WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			int param = 0;
			stmt.setLong(++param, id);
			try (ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					long sifra = rset.getLong(++kolona);
					String naziv = rset.getString(++kolona);
					double cena = rset.getDouble(++kolona);
					boolean besplatnaDostava = rset.getBoolean(++kolona);
					proizvod = new Proizvod(id, sifra, naziv, cena, besplatnaDostava);
					
				}
			}
		}

		return proizvod;
	}

	@Override
	public Collection<Proizvod> getAll() throws Exception {
		Collection<Proizvod> proizvodi = new ArrayList<>();
		
		String sql = "SELECT id, sifra, naziv, cena, besplatnaDostava FROM proizvodi";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			try(ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					long sifra = rset.getLong(++kolona);
					String naziv = rset.getString(++kolona);
					long cena = rset.getLong(++kolona);
					boolean besplatnaDostava = rset.getBoolean(++kolona);
					Proizvod proizvod = new Proizvod(id, sifra, naziv, cena, besplatnaDostava);
					proizvodi.add(proizvod);
				}
			}
		}
		return proizvodi;
	}



}
