package jdbcdemo.domain;

import jdbcdemo.dao.uow.IHaveId;

public class Samochod extends Encja implements IHaveId{ // KLUCZ OBCY ID_INSTRUKTOR?
	
	private String marka;
	private String model;
	private String kolor;
	private Integer rokProdukcji;
	private String nrRejestracyjny;
	
	public String getNrRejestracyjny() {
		return nrRejestracyjny;
	}
	public void setNrRejestracyjny(String nrRejestracyjny) {
		this.nrRejestracyjny = nrRejestracyjny;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getKolor() {
		return kolor;
	}
	public void setKolor(String kolor) {
		this.kolor = kolor;
	}
	public Integer getRokProdukcji() {
		return rokProdukcji;
	}
	public void setRokProdukcji(Integer rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}


}
