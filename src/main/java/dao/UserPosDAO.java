package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.jdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		
		try {
			String sql = "INSERT INTO public.userposjava(nome, email) VALUES (?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, userposjava.getNome());
			ps.setString(2, userposjava.getEmail());
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
	
	public List<Userposjava> listar() throws Exception {
		
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "SELECT id, nome, email FROM public.userposjava;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Userposjava userposjava = new Userposjava();
			
			userposjava.setId(rs.getLong("id"));
			userposjava.setNome(rs.getString("nome"));
			userposjava.setEmail(rs.getString("email"));
			list.add(userposjava);
		}
		
		return list;
	}
	
	public Userposjava buscar(Long id) throws Exception {
		
		Userposjava retorno = new Userposjava();
		
		String sql = "SELECT id, nome, email FROM public.userposjava WHERE id = " + id;
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
						
			retorno.setId(rs.getLong("id"));
			retorno.setNome(rs.getString("nome"));
			retorno.setEmail(rs.getString("email"));
			
		}
		
		return retorno;
	}

	public void atualizar(Userposjava userposjava) {
		
		try {
			String sql = "UPDATE public.userposjava SET nome = ?, email = ? WHERE id = " + userposjava.getId();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userposjava.getNome());
			ps.setString(2, userposjava.getEmail());
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
	
	public void deletar(Long id) {
		
		try {
			String sql = "DELETE FROM userposjava WHERE id = " + id;
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
