package pos_java_jdbc.test;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();
		
		userPosJava.setId(3L);
		userPosJava.setNome("Anna Clara de Carvalho Basilio");
		userPosJava.setEmail("annaclaradecarvalhobasilio@gmail.com");
		
		userPosDAO.salvar(userPosJava);
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("------------------------------------------");
			}
		
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	@Test
	public void initBuscar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(2L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava objetoBanco = dao.buscar(3L);
			objetoBanco.setNome("Anna Clara de Carvalho Bas�lio");
			
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
