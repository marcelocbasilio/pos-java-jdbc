package pos_java_jdbc.test;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class BuscarBancoJdbc {

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
	
}
