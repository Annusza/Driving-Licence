package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import jdbcdemo.dao.uow.JdbcUnitOfWork;
import jdbcdemo.dao.uow.UnitOfWork;

public class JdbcCatalogFactory implements DbCatalogFactory {
	public RepositoryCatalog HsqlDbWorkDb() {
		String url = "jdbc:hsqldb:hsql://localhost/workdb";
//		String url = "jdbc:hsqldb:file:E:\\hSQL\\hsqldb-2.4.0\\hsqldb-2.4.0\\bazaPrawoJazdy";
		try {
			Connection connection = DriverManager.getConnection(url);
			UnitOfWork uow = new JdbcUnitOfWork(connection);
			return new JdbcRepositoryCatalog(connection, uow);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
