package jdbcdemo.domain;

import jdbcdemo.dao.uow.IHaveId;

public class Instruktor extends Encja implements IHaveId {
	

	private String imie;
	private String nazwisko;
	

	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


}
