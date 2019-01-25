package eu.glowacki.utp.assignment10.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import eu.glowacki.utp.assignment10.dtos.DTOBase;

public abstract class Repository<DTO extends DTOBase> implements IRepository<DTO> {
	
	protected final Connection con;

	public Repository() {
		con = getConnection();
	}

	@Override
	public Connection getConnection() {
		Connection connect = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			connect = DriverManager.getConnection("jdbc:oracle:thin:@db-oracle.pjwstk.edu.pl:1521:baza", "s16550",
//					"oracle12");
			// connect =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:homedb","homeuser",
			// "algebra1");
			 connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			 "homeuser", "algebra1");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}

	@Override
	public void beginTransaction() {
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void commitTransaction() {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void rollbackTransaction() {
		try {
			con.rollback();
			con.close();
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

	public void close() {
		try {
			con.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
