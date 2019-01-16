package eu.glowacki.utp.assignment10.repositories;

import java.sql.Connection;
import java.util.List;

import eu.glowacki.utp.assignment10.dtos.UserDTO;

public class UserRepository extends Repository<UserDTO> implements IUserRepository{
final Connection con;
	public UserRepository() {
		con =getConnection();
	}
	@Override
	public void add(UserDTO dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addOrUpdate(UserDTO dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(UserDTO dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public UserDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean exists(UserDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<UserDTO> findByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
