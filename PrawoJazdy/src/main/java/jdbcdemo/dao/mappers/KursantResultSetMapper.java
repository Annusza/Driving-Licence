package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Kursant;

public class KursantResultSetMapper implements ResultSetMapper<Kursant>{

	public Kursant map(ResultSet rs) throws SQLException {
		Kursant k = new Kursant();
		k.setId(rs.getLong("id"));
		k.setImie(rs.getString("imie"));
		k.setNazwisko(rs.getString("nazwisko"));
		
		k.setTelefon(rs.getInt("telefon"));
		k.setNrPesel(rs.getString("nrPesel"));
		k.setDataUrodzenia(rs.getDate("dataUrodzenia"));
		k.setRozpoczecieKursu(rs.getDate("rozpoczecieKursu"));

		return k;
	}
}
