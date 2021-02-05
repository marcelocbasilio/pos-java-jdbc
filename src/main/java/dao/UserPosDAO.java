package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.jdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
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
	
	public void salvarTelefone(Telefone telefone) {
		try {
			String sql = "INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, telefone.getNumero());
			ps.setString(2, telefone.getTipo());
			ps.setLong(3, telefone.getUsuario());
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
	
	public List<BeanUserFone> listaUserFone(Long idUser) {
		
		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();
		
		String sql = "SELECT public.userposjava.nome, public.telefoneuser.numero, public.userposjava.email FROM public.userposjava\r\n"
				+ "INNER JOIN public.telefoneuser ON public.userposjava.id = public.telefoneuser.usuariopessoa\r\n"
				+ "WHERE public.userposjava.id = " + idUser +";";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BeanUserFone userFone = new BeanUserFone();
				userFone.setNome(rs.getString("nome"));
				userFone.setNumero(rs.getString("numero"));
				userFone.setEmail(rs.getString("email"));
				beanUserFones.add(userFone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return beanUserFones;
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
	
	public void deleteFonesPorUser(Long idUser) {
		
		try {
			String sqlFone = "DELETE FROM public.telefoneuser WHERE usuariopessoa = " + idUser + ";";
			String sqlUser = "DELETE FROM public.userposjava WHERE id = " + idUser + ";";
			
			PreparedStatement ps = connection.prepareStatement(sqlFone);
			ps.executeUpdate();
			connection.commit();
			
			ps = connection.prepareStatement(sqlUser);
			ps.executeUpdate();
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
