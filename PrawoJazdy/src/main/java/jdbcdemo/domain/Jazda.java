package jdbcdemo.domain;

import java.util.Date;

import jdbcdemo.dao.uow.IHaveId;

public class Jazda extends Encja implements IHaveId { // KLUCZE OBCE ID_SAMOCHOD I ID_KURSANT

	private Date odKiedy;
	private Date doKiedy;

	public Date getOdKiedy() {
		return odKiedy;
	}

	public void setOdKiedy(Date odKiedy) {
		this.odKiedy = odKiedy;
	}

	public Date getDoKiedy() {
		return doKiedy;
	}

	public void setDoKiedy(Date doKiedy) {
		this.doKiedy = doKiedy;
	}

}
