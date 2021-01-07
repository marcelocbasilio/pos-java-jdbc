package pos_java_jdbc.test;

import org.junit.Test;

import conexao.jdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		//SingleConnection.getConnection();
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();
		
		userPosJava.setId(3L);
		userPosJava.setNome("Anna Clara de Carvalho Basilio");
		userPosJava.setEmail("annaclaradecarvalhobasilio@gmail.com");
		
		userPosDAO.salvar(userPosJava);
	}
}
