package jdbcdemo.dao;

import java.sql.SQLException;
import java.util.List;

import jdbcdemo.dao.uow.IHaveId;


public interface Repository<TEntity extends IHaveId> {

	public void delete(TEntity entity);

	public List<TEntity> getAll() throws SQLException;
	
	public void add(TEntity person);
	
	public void update(TEntity person);
	
	public void createTable() throws SQLException;

}