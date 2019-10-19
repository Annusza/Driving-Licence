package jdbcdemo.domain;

import java.util.Date;

import jdbcdemo.dao.uow.IHaveId;

public class Egzamin extends Encja implements IHaveId { 

	private Date dataGodzina;
	private Boolean zdany;
	private Long idKursant;

	public Long getIdKursant() {
		return idKursant;
	}

	public void setIdKursant(Long idKursant) {
		this.idKursant = idKursant;
	}

	public Date getDataGodzina() {
		return dataGodzina;
	}

	public void setDataGodzina(Date dataGodzina) {
		this.dataGodzina = dataGodzina;
	}

	public Boolean getZdany() {
		return zdany;
	}

	public void setZdany(Boolean zdany) {
		this.zdany = zdany;
	}

	@Override
	public String toString() {
		return "Egzamin [id=" + id + ", dataGodzina=" + dataGodzina + ", zdany=" + zdany + "]";
	}

}
