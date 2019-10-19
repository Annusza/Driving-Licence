package jdbcdemo.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jdbcdemo.dao.uow.IHaveId;

public class Kursant extends Encja implements IHaveId {	
	
	private String imie;
	private String nazwisko;
	private Integer telefon;	
	private String nrPesel;
	private Date dataUrodzenia;
	private Date rozpoczecieKursu;
	private Set<Egzamin> egzaminy= new HashSet<Egzamin>();
	
	public Set<Egzamin> getEgzaminy() {
		return egzaminy;
	}
	public void setEgzaminy(Set<Egzamin> egzaminy) {
		this.egzaminy = egzaminy;
	}
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
	public Integer getTelefon() {
		return telefon;
	}
	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}
	public String getNrPesel() {
		return nrPesel;
	}
	public void setNrPesel(String nrPesel) {
		this.nrPesel = nrPesel;
	}
	public Date getRozpoczecieKursu() {
		return rozpoczecieKursu;
	}
	public void setRozpoczecieKursu(Date rozpoczecieKursu) {
		this.rozpoczecieKursu = rozpoczecieKursu;
	}
	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}
	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}
	@Override
	public String toString() {
		return "Kursant [imie=" + imie + ", nazwisko=" + nazwisko + ", telefon=" + telefon + ", nrPesel=" + nrPesel
				+ ", dataUrodzenia=" + dataUrodzenia + ", rozpoczecieKursu=" + rozpoczecieKursu + ", egzaminy="
				+ egzaminy + "]";
	}
	
	


}
