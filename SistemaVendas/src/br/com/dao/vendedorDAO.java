package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import br.com.ConexaoBanco.ConexaoMySQL;
import br.com.Modelo.Clientes;
import br.com.Modelo.Vendedor;

public class vendedorDAO {

	static Scanner lerInt = new Scanner(System.in);	
	
	public static void cadastrarVendedor(Vendedor vendedor){
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			String sql = "INSERT INTO vendedor(nome, cpf, salario) VALUES(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, vendedor.getNome());
			statement.setString(2, vendedor.getCpf());
			statement.setFloat(3, vendedor.getSalario());
			
			statement.execute();
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void excluirVendedor(Vendedor vendedor) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "DELETE FROM vendedor WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, vendedor.getId());
			
			statement.execute();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void listarVendedor(){
		
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM vendedor";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				System.out.print(resultset.getInt("id") + " - ");
				System.out.print(resultset.getString("nome") + " - ");
				System.out.print(resultset.getString("cpf") + " - ");
				System.out.print(resultset.getFloat("salario") + "\n");
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void editarVendedor(Vendedor vendedor) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "UPDATE vendedor SET nome = ?, cpf = ?, salario = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, vendedor.getNome());
			statement.setString(2, vendedor.getCpf());
			statement.setFloat(3, vendedor.getSalario());
			statement.setInt(4, vendedor.getId());
			statement.execute();
			statement.close();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Vendedor selecionarVendedor(){
		
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM vendedor";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				System.out.print(resultset.getInt("id") + " - ");
				System.out.println(resultset.getString("nome"));
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Vendedor vendedor = new Vendedor(null, null, 0);
		
		while(vendedor.getNome() == null) {
			System.out.print("\nDigite o Id do Vendedor: ");
			int id1 = lerInt.nextInt();

			try {
				Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
				
				String sql = "SELECT * FROM vendedor WHERE id = ?";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setInt(1, id1);
				ResultSet resultset = statement.executeQuery();
				
				while(resultset.next()) {
					vendedor.setId(resultset.getInt("id"));
					vendedor.setNome(resultset.getString("nome"));
					vendedor.setCpf(resultset.getString("cpf"));
					vendedor.setSalario(resultset.getFloat("salario"));
					
				}
				
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(vendedor.getNome() == null) {
				System.out.println("O vendedor nao existe!");
			}
		}
		return vendedor;
	}
	
}
