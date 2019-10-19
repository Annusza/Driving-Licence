package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Egzamin;



public class EgzaminResultSetMapper implements ResultSetMapper<Egzamin>{

	public Egzamin map(ResultSet rs) throws SQLException {
		Egzamin e = new Egzamin();
		e.setId(rs.getLong("id"));
		e.setDataGodzina(rs.getDate("dataGodzina"));
		e.setZdany(rs.getBoolean("zdany"));
		e.setIdKursant(rs.getLong("idKursant"));

		return e;
	}
}
