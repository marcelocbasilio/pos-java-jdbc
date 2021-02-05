package pos_java_jdbc.test;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class ListarBancoJdbc {

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
	
}
