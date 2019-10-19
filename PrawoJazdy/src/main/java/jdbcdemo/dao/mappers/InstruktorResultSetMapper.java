package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Instruktor;


public class InstruktorResultSetMapper implements ResultSetMapper<Instruktor>{

	public Instruktor map(ResultSet rs) throws SQLException {
		Instruktor i = new Instruktor();
		i.setId(rs.getLong("id"));
		i.setImie(rs.getString("imie"));
		i.setNazwisko(rs.getString("nazwisko"));

		return i;
	}
}