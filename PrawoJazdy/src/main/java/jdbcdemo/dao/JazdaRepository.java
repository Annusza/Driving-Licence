//package jdbcdemo.dao;
//
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
////import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
////import jdbcdemo.domain.Egzamin;
////import jdbcdemo.domain.Instruktor;
//import jdbcdemo.domain.Jazda;
//
//
//public class JazdaRepository extends RepositoryBase<Jazda> { 
//
//	private String createTableSql = "CREATE TABLE jazda(id BIGINT GENERATED BY DEFAULT AS IDENTITY, odKiedy DATE, doKiedy DATE, id_kursant BIGINT, id_samochod BIGINT)"; // KLUCZE																																			// OBCE
//	private String insertSql = "INSERT INTO JAZDA (odKiedy, doKiedy) VALUES (?,?)";
//	private String updateSql = "UPDATE JAZDA SET (odKiedy, doKiedy) = (?,?) WHERE id=?";
//	private String deleteSql = "DELETE FROM JAZDA WHERE id=?";
//	private String selectAllSql = "SELECT * FROM JAZDA";
//
//	
//
//	public JazdaRepository() {
//		super();
//
//		
//	}
//
//	public List<Jazda> getAll() throws SQLException {
//		List<Jazda> result = new ArrayList<Jazda>();
//		ResultSet rs = selectAll.executeQuery();
//		while (rs.next()) {
//			Jazda j = new Jazda();
//			j.setId(rs.getLong("id"));
//			j.setOdKiedy(rs.getDate("odKiedy"));
//			j.setDoKiedy(rs.getDate("doKiedy"));
//			result.add(j);
//		}
//		
//		return result;
//	}
//
//	public void add(Jazda jazda) throws SQLException {
//		
//			insert.setDate(1, new java.sql.Date(jazda.getOdKiedy().getTime())); // CZY TO OK??? BO NIE WIEM
//			insert.setDate(2, new java.sql.Date(jazda.getDoKiedy().getTime())); // CZY TO OK??? BO NIE WIEM
//			insert.executeUpdate();
//		
//	}
//
//	public void update(Jazda jazda) {
//
//		try {
//			update.setDate(1, new java.sql.Date(jazda.getOdKiedy().getTime()));	// CZY TO OK???
//			update.setDate(2, new java.sql.Date(jazda.getDoKiedy().getTime()));	//CZY TO OK???
//			update.setLong(3, jazda.getId());
//			update.executeUpdate();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	public void delete(Jazda jazda) throws SQLException {
//
//			delete.setLong(1, jazda.getId());
//			delete.executeUpdate();
//		
//	}
//
//	public void createTable() {
//		try {
//
//			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
//			boolean tableExists = false;
//			while (rs.next()) {
//				if (rs.getString("TABLE_NAME").equalsIgnoreCase("jazda")) {
//					tableExists = true;
//					break;
//				}
//			}
//			if (!tableExists)
//				createTable.executeUpdate(createTableSql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	protected String deleteSql() {
//		return deleteSql;
//	}
//
//	@Override
//	protected String updateSql() {
//		return updateSql;
//	}
//
//	@Override
//	protected String insertSql() {
//		return insertSql;
//	}
//
//	@Override
//	protected String selectAllSql() {
//		return selectAllSql;
//	}
//
//}