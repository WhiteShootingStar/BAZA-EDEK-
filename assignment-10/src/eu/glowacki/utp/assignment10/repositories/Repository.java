package eu.glowacki.utp.assignment10.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import eu.glowacki.utp.assignment10.dtos.DTOBase;

public abstract class Repository<DTO extends DTOBase> implements IRepository<DTO> {
	final Connection conn;

	public Repository() {
		conn = getConnection();
	}

	@Override
	public Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("pudge", "s16550", "oracle12");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}

	@Override
	public void beginTransaction() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void commitTransaction() {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void rollbackTransaction() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean exists(DTOBase dto) {
		// TODO Auto-generated method stub
		return dto.hasExistingId();
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
