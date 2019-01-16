package eu.glowacki.utp.assignment10.repositories;

import java.sql.Connection;
import java.util.List;

import eu.glowacki.utp.assignment10.dtos.DTOBase;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;

public class GroupRepository extends Repository<GroupDTO> implements IGroupRepository {
	final Connection con;

	public GroupRepository() {
		con = getConnection();
	}

	@Override
	public void add(GroupDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GroupDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addOrUpdate(GroupDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(GroupDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public GroupDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(GroupDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GroupDTO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
