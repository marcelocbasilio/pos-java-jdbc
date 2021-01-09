package pos_java_jdbc.test;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class AtualizarBancoJdbc {

	@Test
	public void initAtualizar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava objetoBanco = dao.buscar(6L);
			objetoBanco.setNome("Maria da Paz Cordeiro Basílio");
			objetoBanco.setEmail("mariapcb@gmail.com");
			
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
