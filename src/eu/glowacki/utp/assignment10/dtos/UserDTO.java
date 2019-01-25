package eu.glowacki.utp.assignment10.dtos;

import java.util.LinkedList;
import java.util.List;

public class UserDTO extends DTOBase {

	private String _login;
	private String _password;
	private List<GroupDTO> _groups;

	public UserDTO() {
	}

	public UserDTO(int id, String login, String password) {
		super(id);
		_login = login;
		_password = password;
	}

	public String getLogin() {
		return _login;
	}

	public void setLogin(String login) {
		_login = login;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public List<GroupDTO> getGroups() {
		return _groups;
	}

	public void setGroups(List<GroupDTO> groups) {
		_groups = groups;
	}

	public void addGroup(GroupDTO group) {
		if (_groups == null) {
			_groups = new LinkedList<GroupDTO>();
		}
		_groups.add(group);
	}

	public void deleteGroup(GroupDTO group) {
		if (_groups != null) {
			_groups.remove(group);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((_groups == null) ? 0 : _groups.hashCode());
		result = prime * result + ((_login == null) ? 0 : _login.hashCode());
		result = prime * result + ((_password == null) ? 0 : _password.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (_groups == null) {
			if (other._groups != null)
				return false;
		} else if (!_groups.equals(other._groups))
			return false;
		if (_login == null) {
			if (other._login != null)
				return false;
		} else if (!_login.equals(other._login))
			return false;
		if (_password == null) {
			if (other._password != null)
				return false;
		} else if (!_password.equals(other._password))
			return false;
		return true;
	}
}