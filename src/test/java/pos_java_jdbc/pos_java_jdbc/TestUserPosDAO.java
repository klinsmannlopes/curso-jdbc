package pos_java_jdbc.pos_java_jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TestUserPosDAO {

	
	@Test
	public void insertBanco() {
		Userposjava userPosjava = new Userposjava();
		UserPosDAO UserPosDao = new UserPosDAO();
		
		userPosjava.setNome("ney");
		userPosjava.setEmail("ney@gmail.com");
		
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
	public void testeCarregarFoneUser() {
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> listUserFone = new ArrayList<BeanUserFone>();
		
		try {
			listUserFone = dao.listaUserFone(2L);
			
			for (BeanUserFone beanUserFone : listUserFone) {
				System.out.println("Nome: " + beanUserFone.getNome());
				System.out.println("Numero: " + beanUserFone.getNumero());
				System.out.println("Email: " + beanUserFone.getEmail());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
	
	@Test
	public void initInsertTelefone() {
		
		Telefone telefone = new Telefone();
		UserPosDAO userPosDao = new UserPosDAO();
		
		try {
			
			telefone.setNumero("(85)-99999-9999");
			telefone.setTipo("Fixo");
			telefone.setUsuario(2L);
			
			userPosDao.salvaTelefone(telefone);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	@Test
	public void testeDeleteFoneUser() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			dao.deleteFonesPorUser(2L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
