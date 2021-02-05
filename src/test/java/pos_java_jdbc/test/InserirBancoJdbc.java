package pos_java_jdbc.test;

import org.junit.Test;

import dao.UserPosDAO;
import model.Telefone;
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
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("+55 (85) 99970-0202");
		telefone.setTipo("Celular");
		telefone.setUsuario(3L);
		
		UserPosDAO userPosDAO = new UserPosDAO();
		userPosDAO.salvarTelefone(telefone);
	}
	
}
