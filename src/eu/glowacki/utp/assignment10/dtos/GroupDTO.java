package eu.glowacki.utp.assignment10.dtos;

import java.util.LinkedList;
import java.util.List;

public class GroupDTO extends DTOBase {

	private String _name;
	private String _description;
	private List<UserDTO> _users;

	public GroupDTO() {
	}

	public GroupDTO(int id, String name, String description) {
		super(id);
		_name = name;
		_description = description;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public List<UserDTO> getUsers() {
		return _users;
	}

	public void setUsers(List<UserDTO> users) {
		_users = users;
	}

	public void addUser(UserDTO user) {
		if (_users == null) {
			_users = new LinkedList<UserDTO>();
		}
		_users.add(user);
	}

	public void deleteUser(UserDTO user) {
		if (_users != null) {
			_users.remove(user);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((_description == null) ? 0 : _description.hashCode());
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result + ((_users == null) ? 0 : _users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupDTO other = (GroupDTO) obj;
		if (_description == null) {
			if (other._description != null)
				return false;
		} else if (!_description.equals(other._description))
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_users == null) {
			if (other._users != null)
				return false;
		} else if (!_users.equals(other._users))
			return false;
		return true;
	}
}