package pos_java_jdbc.test;

import org.junit.Test;

import dao.UserPosDAO;

public class DeletarBancoJdbc {

	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(6L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
