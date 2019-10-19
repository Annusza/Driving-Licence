package jdbcdemo.system;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbcdemo.dao.EgzaminRepository;
import jdbcdemo.dao.JdbcCatalogFactory;
import jdbcdemo.dao.KursantRepository;
import jdbcdemo.dao.Repository;
import jdbcdemo.dao.RepositoryCatalog;
import jdbcdemo.dao.mappers.ResultSetMapper;
import jdbcdemo.dao.uow.JdbcUnitOfWork;
import jdbcdemo.dao.uow.UnitOfWork;
import jdbcdemo.domain.Egzamin;
import jdbcdemo.domain.Kursant;

public class PrawoJazdySystem {

	Repository<Egzamin> repoEgzamin;
//	KursantRepository repoKursant = new KursantRepository;
	Repository<Kursant> repoKursant;
	
	RepositoryCatalog workdb;

	public PrawoJazdySystem() {
		workdb = new JdbcCatalogFactory().HsqlDbWorkDb();
		repoEgzamin = workdb.egzaminy();
		repoKursant = workdb.kursanci();

	}

	public void addEgzamin(Egzamin egzamin) throws SQLException {

		repoEgzamin.add(egzamin);
		workdb.saveChanges();
	}
	
	public void addKursant(Kursant kursant) throws SQLException {

		repoKursant.add(kursant);
		workdb.saveChanges();
	}

	public List<Egzamin> getAllEgzamin() throws SQLException {

		return repoEgzamin.getAll();

	}

	public List<Kursant> getAllKursant() throws SQLException {

//		return null;
		 return repoKursant.getAll();
	}

	public List<Kursant> getAllKursantWithForeginEntities() throws SQLException {

		Long numerKursanta;

		Map<Long, Kursant> mapaKursantow = new HashMap<Long, Kursant>();
		List<Egzamin> egzaminy = getAllEgzamin();
		List<Kursant> kursanci = getAllKursant();
		for (Kursant k : kursanci) {
			mapaKursantow.put(k.getId(), k);
		}
		for (Egzamin e : egzaminy) {

			numerKursanta = e.getIdKursant();
			Kursant kursant = mapaKursantow.get(numerKursanta);
			if (kursant != null) {
				kursant.getEgzaminy().add(e);

			}
		}
		return kursanci;

	}

	public void updateEgzamin(Egzamin e) {
		repoEgzamin.update(e);
		// unit of work
		// wielokrotnie w pętli update a savechanges tylko 1 raz

	}


	public void zapiszUOW() {
		workdb.saveChanges();

	}

}
