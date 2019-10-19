package jdbcdemo.domain;

import jdbcdemo.dao.uow.IHaveId;

public abstract class Encja implements IHaveId {
	
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
