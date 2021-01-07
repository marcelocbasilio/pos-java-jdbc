package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.jdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		
		try {
			String sql = "INSERT INTO public.userposjava(id, nome, email) VALUES (?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, userposjava.getId());
			ps.setString(2, userposjava.getNome());
			ps.setString(3, userposjava.getEmail());
			ps.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
