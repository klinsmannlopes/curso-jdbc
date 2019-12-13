package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.jna.platform.win32.Netapi32Util.User;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	
	public void salvar (Userposjava userposjava) {
		
		try {
		String sql = "insert into userposjava (nome, email) values (?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		
		insert.setString(1, userposjava.getNome());
		insert.setString(2, userposjava.getEmail());
		
		insert.execute();
		connection.commit();
		
		System.out.println("Deu certo inserir");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Userposjava> listar() throws Exception {
		
		List<Userposjava> list = new ArrayList<Userposjava>();
		String sql = "select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			list.add(userposjava);
			
			
		}
		
		
		return list;
	}
	
	public Userposjava busacarId(long id) throws Exception {
		
		Userposjava user = new Userposjava();
		String sql = "select * from userposjava where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		
		
		while (resultado.next()) {
			user.setId(resultado.getLong("id"));
			user.setNome(resultado.getString("nome"));
			user.setEmail(resultado.getString("email"));
		}
		
		return user;
	}
	
	public void atualizar(Userposjava userAtualizado) {
		
		//Userposjava user = new Userposjava();
		
		String sql = "update userposjava set nome = ?, email = ?  where id = ?";
		
		
		try {
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, userAtualizado.getNome());
			update.setString(2, userAtualizado.getEmail());
			update.setLong(3, userAtualizado.getId());
			update.execute();
			connection.commit();
			System.out.println("Linha foi atualizada");
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public void delete(Long idUser) {
		
		String sql = "delete from userposjava where id = ?";
		
		try {
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.setLong(1, idUser);
			delete.execute();
			connection.commit();
			System.out.println("Linha " + idUser + " deletada");
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
}
