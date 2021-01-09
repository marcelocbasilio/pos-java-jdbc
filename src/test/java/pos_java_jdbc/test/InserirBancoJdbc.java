package pos_java_jdbc.test;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class InserirBancoJdbc {

	@Test
	public void initBanco() {

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();
		
		userPosJava.setNome("Maria da Paz Cordeiro Basilio");
		userPosJava.setEmail("mariapcb@obascol.com");
		
		userPosDAO.salvar(userPosJava);
	}
	
}
