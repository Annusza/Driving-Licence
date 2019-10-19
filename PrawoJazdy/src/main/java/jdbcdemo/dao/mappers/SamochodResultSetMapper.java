// do UZUPEŁNIENIA
package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Samochod;

public class SamochodResultSetMapper implements ResultSetMapper<Samochod>{

	public Samochod map(ResultSet rs) throws SQLException {
		Samochod s = new Samochod();
		

		return s;
	}
}
