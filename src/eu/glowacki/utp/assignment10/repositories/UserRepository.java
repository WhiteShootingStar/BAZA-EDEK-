package eu.glowacki.utp.assignment10.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.glowacki.utp.assignment10.dtos.UserDTO;

public class UserRepository extends Repository<UserDTO> implements IUserRepository {

	@Override
	public void add(UserDTO dto) {
		//(user_id, user_login, user_password)
		 String query = "insert into users  values (?, ?, ?)";
		try {
			PreparedStatement stat = con.prepareStatement(query);
			stat.setInt(1, dto.getId());
			stat.setString(2, dto.getLogin());
			stat.setString(3, dto.getPassword());
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(UserDTO dto) {
		final String query = "update users set user_login = ?, user_password = ? where user_id = ?  ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setString(1, dto.getLogin());
			stat.setString(2, dto.getPassword());
			stat.setInt(3, dto.getId());
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addOrUpdate(UserDTO dto) {
		if (exists(dto)) {
			update(dto);
		} else
			add(dto);

	}

	@Override
	public void delete(UserDTO dto) {
		final String query = "delete from users   where user_id = ? ";
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
	public UserDTO findById(int id) {
		UserDTO temp = null;
		final String query = "select * from users where user_id = ? ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setInt(1, id);

			ResultSet set = stat.executeQuery();
			if (set.next()) {
				temp = new UserDTO(set.getInt("user_id"), set.getString("user_login"), set.getString("user_password"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated method stub
		return temp;
	}

	@Override
	public int getCount() {
		final String query = "select count(user_id) from users";
		int a = 0;
		try {
			PreparedStatement stat = con.prepareStatement(query);

			ResultSet set = stat.executeQuery();
			if (set.next()) {
				System.out.println(a);
				a = set.getInt(1);
				System.out.println(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated method stub
		return a;
	}

	@Override
	public boolean exists(UserDTO dto) {
		// TODO Auto-generated method stub
		return findById(dto.getId()) != null ? true : false;
	}

	@Override
	public List<UserDTO> findByName(String username) {
		List<UserDTO> list = new ArrayList<>();
		final String query = "select * from users where user_login like ? ";
		try {
			PreparedStatement stat = con.prepareStatement(query);

			stat.setString(1, username);

			ResultSet set = stat.executeQuery();
			while (set.next()) {
				list.add(new UserDTO(set.getInt("user_id"), set.getString("user_login"),
						set.getString("user_password")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated method stub

		return list;
	}
}
