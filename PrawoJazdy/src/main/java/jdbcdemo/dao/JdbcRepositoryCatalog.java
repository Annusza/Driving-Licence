package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbcdemo.dao.mappers.EgzaminResultSetMapper;
import jdbcdemo.dao.mappers.KursantResultSetMapper;
import jdbcdemo.dao.mappers.ResultSetMapper;
import jdbcdemo.dao.uow.UnitOfWork;
import jdbcdemo.domain.Egzamin;
import jdbcdemo.domain.Kursant;

public class JdbcRepositoryCatalog implements RepositoryCatalog {
	Connection connection;
	UnitOfWork uow;

	public JdbcRepositoryCatalog(Connection connection, UnitOfWork uow) {
		this.connection = connection;
		this.uow = uow;
	}

	/* (non-Javadoc)
	 * @see jbcdemo.dao.RepositoryCatalog#egzaminy()
	 */
	public Repository<Egzamin> egzaminy() {
		try {
			return new EgzaminRepository(connection, new EgzaminResultSetMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see jbcdemo.dao.RepositoryCatalog#saveChanges()
	 */
	public void saveChanges() {
		uow.saveChanges();
	}

	public Repository<Kursant> kursanci() {
		try {
			return new KursantRepository(connection, new KursantResultSetMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}