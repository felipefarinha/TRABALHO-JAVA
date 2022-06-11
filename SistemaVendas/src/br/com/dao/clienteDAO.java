package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import br.com.ConexaoBanco.ConexaoMySQL;
import br.com.Modelo.Clientes;
import br.com.Modelo.Vendedor;

public class clienteDAO {

	static Scanner lerInt = new Scanner(System.in);
	
	public static void cadastrarCliente(Clientes cliente) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			String sql = "INSERT INTO cliente(nome, cpf, endereco) VALUES(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getEndereco());
			
			statement.execute();
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void excluirCliente(Clientes cliente) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "DELETE FROM cliente WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, cliente.getId());
			
			statement.execute();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void listarClientes(){
		
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM cliente";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				System.out.print(resultset.getInt("id") + " - ");
				System.out.print(resultset.getString("nome") + " - ");
				System.out.print(resultset.getString("cpf") + " - ");
				System.out.print(resultset.getString("endereco") + "\n");
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void editarCliente(Clientes cliente) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "UPDATE cliente SET nome = ?, cpf = ?, endereco = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getEndereco());
			statement.setInt(4, cliente.getId());
			statement.execute();
			statement.close();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Clientes selecionarCliente(){
		
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM cliente";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				System.out.print(resultset.getInt("id") + " - ");
				System.out.print(resultset.getString("nome") + " - ");
				System.out.println(resultset.getString("cpf"));
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Clientes cliente = new Clientes(null, null, null);
		
		while(cliente.getNome() ==  null) {
			System.out.print("\nDigite o Id do Cliente: ");
			int id1 = lerInt.nextInt();
			
			try {
				Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
				
				String sql = "SELECT * FROM cliente WHERE id = ?";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setInt(1, id1);
				ResultSet resultset = statement.executeQuery();
				
				while(resultset.next()) {
					cliente.setId(resultset.getInt("id"));
					cliente.setNome(resultset.getString("nome"));
					cliente.setCpf(resultset.getString("cpf"));
					cliente.setEndereco(resultset.getString("endereco"));
					
				}
				
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(cliente.getNome() == null) {
				System.out.println("O cliente nao existe!");
			}
		}
		return cliente;
	}
	
}
