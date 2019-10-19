package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcdemo.dao.mappers.ResultSetMapper;
import jdbcdemo.dao.uow.Entity;
import jdbcdemo.dao.uow.IHaveId;
import jdbcdemo.dao.uow.UnitOfWork;
//import java.util.ArrayList;
//import java.util.List;
import jdbcdemo.dao.uow.UnitOfWorkRepository;

//import jdbcdemo.domain.Egzamin;
//import jdbcdemo.domain.Instruktor;
//import jdbcdemo.domain.Jazda;
//import jdbcdemo.domain.Kursant;
//import jdbcdemo.domain.Samochod;

public abstract class RepositoryBase<TEntity extends IHaveId> implements Repository<TEntity>, UnitOfWorkRepository {

	protected Connection connection;
	protected Statement createTable;
	protected PreparedStatement insert;
	protected PreparedStatement selectAll;
	protected PreparedStatement update;
	protected PreparedStatement delete;

	ResultSetMapper<TEntity> mapper;
	UnitOfWork uow;

	protected RepositoryBase(Connection connection, ResultSetMapper<TEntity> mapper, UnitOfWork uow)
			throws SQLException {
		this.mapper = mapper;
		this.connection = connection;
		this.uow = uow;
		createTable = connection.createStatement();
		createTable();
		insert = connection.prepareStatement(insertSql());
		update = connection.prepareStatement(updateSql());
		delete = connection.prepareStatement(deleteSql());
		selectAll = connection.prepareStatement(selectAllSql());
	}



	protected abstract String selectAllSql();

	protected abstract String deleteSql();

	protected abstract String updateSql();

	protected abstract String insertSql();

	protected abstract void setupUpdate(TEntity entity) throws SQLException; 

	protected abstract void setupInsert(TEntity entity) throws SQLException;

	// protected abstract void add(TEntity entity) throws SQLException;

	public abstract void createTable() throws SQLException; 
																				

	public void persistAdd(Entity entity) {		// add do bazy danych
		try {
			setupInsert((TEntity) entity.getEntity());
			insert.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void add(TEntity entity) {	// add w pamięci do uow
		Entity ent = new Entity();
		ent.setRepository(this);
		ent.setEntity(entity);
		uow.markAsNew(ent);
	}

	public void delete(TEntity entity) {
		Entity ent = new Entity();
		ent.setRepository(this);
		ent.setEntity(entity);
		uow.markAsDeleted(ent);
	}

	public void update(TEntity entity) {
		Entity ent = new Entity();
		ent.setRepository(this);
		ent.setEntity(entity);
		uow.markAsChanged(ent);
	}

	//////
	public void persistDelete(Entity entity) {
		try {
			setupDelete((TEntity) entity.getEntity());
			delete.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	public void setupDelete(TEntity entity) throws SQLException {
		delete.setLong(1, entity.getId());

	}

	public void persistUpdate(Entity entity) {
		try {
			setupUpdate((TEntity) entity.getEntity());
			update.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}
}
