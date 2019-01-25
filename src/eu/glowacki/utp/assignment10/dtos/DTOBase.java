package eu.glowacki.utp.assignment10.dtos;

public abstract class DTOBase {

	private int _id;

	protected DTOBase() {}

	protected DTOBase(int id) {
		_id = id;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public boolean hasExistingId() {
		return getId() > 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOBase other = (DTOBase) obj;
		if (_id != other._id)
			return false;
		return true;
	}
}