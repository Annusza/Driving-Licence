package jdbcdemo.dao;

import jdbcdemo.domain.Egzamin;
import jdbcdemo.domain.Kursant;

public interface RepositoryCatalog {

	Repository<Egzamin> egzaminy();
	Repository<Kursant> kursanci();

	void saveChanges();
	
	
	

}