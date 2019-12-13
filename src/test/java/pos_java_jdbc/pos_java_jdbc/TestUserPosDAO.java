package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class TestUserPosDAO {

	
	@Test
	public void insertBanco() {
		Userposjava userPosjava = new Userposjava();
		UserPosDAO UserPosDao = new UserPosDAO();
		
		userPosjava.setNome("matheus");
		userPosjava.setEmail("matheus@gmail.com");
		
		UserPosDao.salvar(userPosjava);
	
		
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> daoLista = dao.listar();
			
			for (Userposjava userposjava : daoLista) {
				System.out.println(userposjava.getNome() + "--" + userposjava.getEmail());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscarId() {
		UserPosDAO userDAO = new UserPosDAO();
		Userposjava user = new Userposjava();
		
		try {
			
			//user = userDAO.busacarId(2);
			
			//System.out.println(user.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		UserPosDAO userDao = new UserPosDAO();
		UserPosDAO dao = new UserPosDAO();
		
		try {
			
			//Userposjava userBanco = dao.busacarId(4L);
			
			//userBanco.setNome("mosca");
			//userBanco.setEmail("mosca@gmail.com");
			
			//userDao.atualizar(userBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDelete() {
		UserPosDAO userDao = new UserPosDAO();
		
		try {
			userDao.delete(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	
}
