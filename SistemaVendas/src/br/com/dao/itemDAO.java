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
import br.com.Modelo.Item;
import br.com.Modelo.Vendedor;

public class itemDAO {
	
	public static void cadastrarItem(Item Item) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			String sql = "INSERT INTO item(nome, unidade, valor) VALUES(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
					
			statement.setString(1, Item.getNome());
			statement.setString(2, Item.getUnidade());
			statement.setFloat(3, Item.getValor());
			
			statement.execute();
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void excluirItem(Item item) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "DELETE FROM item WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, item.getId());
			
			statement.execute();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void listarItens(){
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM item";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				System.out.print(resultset.getInt("id") + " - ");
				System.out.print(resultset.getString("nome") + " - ");
				System.out.print(resultset.getString("unidade") + " - ");
				System.out.print(resultset.getFloat("valor") + "\n");
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void editarItem(Item item) {
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "UPDATE item SET nome = ?, unidade = ?, valor = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, item.getNome());
			statement.setString(2, item.getUnidade());
			statement.setFloat(3, item.getValor());
			statement.setInt(4, item.getId());
			statement.execute();
			statement.close();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public static Item selecionarItem(int id){
		
		Item item = new Item(null, null, 0);
		
		try {
			Connection connection = (Connection) ConexaoMySQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM item WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				item.setId(resultset.getInt("id"));
				item.setNome(resultset.getString("nome"));
				item.setUnidade(resultset.getString("unidade"));
				item.setValor(resultset.getFloat("valor"));
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
}
