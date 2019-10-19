package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Jazda;

public class JazdaResultSetMapper implements ResultSetMapper<Jazda>{

	public Jazda map(ResultSet rs) throws SQLException {
		Jazda j = new Jazda();
		j.setId(rs.getLong("id"));
		j.setOdKiedy(rs.getDate("odKiedy"));
		j.setDoKiedy(rs.getDate("doKiedy"));

		return j;
	}
}
