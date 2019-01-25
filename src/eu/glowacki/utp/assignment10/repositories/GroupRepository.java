package eu.glowacki.utp.assignment10.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eu.glowacki.utp.assignment10.dtos.GroupDTO;

public class GroupRepository extends Repository<GroupDTO> implements IGroupRepository {

	@Override
	public void add(GroupDTO dto) {
		final String query = "insert into groups values (?,?,?)";
		try {
			PreparedStatement stat = con.prepareStatement(query);
			stat.setInt(1, dto.getId());
			stat.setString(2, dto.getName());
			stat.setString(3, dto.getDescription());
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(GroupDTO dto) {
		final String query = "update groups  set group_name = ?, group_description = ? where group_id = ?  ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setString(1, dto.getName());
			stat.setString(2, dto.getDescription());
			stat.setInt(3, dto.getId());
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addOrUpdate(GroupDTO dto) {
		if (exists(dto)) {
			update(dto);
		} else
			add(dto);


	}

	@Override
	public void delete(GroupDTO dto) {
		final String query = "delete from groups  where group_id = ? ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setInt(1, dto.getId());

			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public GroupDTO findById(int id) {
		GroupDTO temp = null;
		final String query = "select * from groups where group_id = ? ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setInt(1, id);

			ResultSet set = stat.executeQuery();
			if (set.next()) {
				temp = new GroupDTO(set.getInt(1), set.getString(2), set.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated method stub
		return temp;

	}

	@Override
	public int getCount() {
		final String query = "select count(group_id) from groups";
		int a = 0;
		try {
			PreparedStatement stat = con.prepareStatement(query);

			ResultSet set = stat.executeQuery();
			if (set.next()) {
				a = set.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated method stub
		return a;
	}

	@Override
	public boolean exists(GroupDTO dto) {
		// TODO Auto-generated method stub
		return findById(dto.getId()) != null ? true : false;
	}

	@Override
	public List<GroupDTO> findByName(String name) {
		List<GroupDTO> list = new ArrayList<>();
		final String query = "select * from groups where group_name like ? ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setString(1, name);

			ResultSet set = stat.executeQuery();
			while (set.next()) {
				list.add(new GroupDTO(set.getInt(1), set.getString(2), set.getString(3)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated method stub

		return list;
	}

}
