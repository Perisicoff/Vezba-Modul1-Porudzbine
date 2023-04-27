package DatabaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import DAO.PorudzbinaDAO;
import DAO.ProizvodDAO;
import Model.Porudzbina;
import Model.Proizvod;

public class DatabasePorudzbinaDAO implements PorudzbinaDAO {
	
	private final Connection conn;
	private final ProizvodDAO proizvodDAO;

	public DatabasePorudzbinaDAO(Connection conn, ProizvodDAO proizvodDAO) {
		super();
		this.conn = conn;
		this.proizvodDAO = proizvodDAO;
	}

	@Override
	public Collection<Porudzbina> getAll() throws Exception {
		Collection<Porudzbina> porudzbine = new ArrayList<>();
		
		String sql = "SELECT id, datumIVreme, ulica, broj, proizvodId FROM porudzbine";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			try(ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					LocalDateTime datum = rset.getTimestamp(++kolona).toLocalDateTime();
					String ulica = rset.getString(++kolona);
					int broj = rset.getInt(++kolona);
					long idProizvoda = rset.getLong(++kolona);
					Proizvod proizvod = proizvodDAO.get(idProizvoda);
					Porudzbina porudzbina = new Porudzbina(id, datum, ulica, broj, proizvod);
					porudzbina.setProizvod(proizvod);
					porudzbine.add(porudzbina);
				}
			}
		}
		return porudzbine;
	}

	@Override
	public void add(Porudzbina Porudzbina) throws Exception {
		
		String sql = "INSERT INTO porudzbine (datumIVreme, ulica, broj, proizvodId) VALUES (?, ?, ?, ?)";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			int kolona = 0;
			stmt.setTimestamp(++kolona, Timestamp.valueOf(Porudzbina.getDatumIVreme()));
			stmt.setString(++kolona, Porudzbina.getUlica());
			stmt.setInt(++kolona, Porudzbina.getBroj());
			stmt.setLong(++kolona, Porudzbina.getProizvod().getId());
			stmt.executeUpdate();
		}
	}

}
