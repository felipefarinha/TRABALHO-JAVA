package br.com.Modelo;

import java.util.Scanner;

public class ItemVenda {

	static Scanner lerInt = new Scanner(System.in);
	private Item item;
	private int quantidade;
	
	public ItemVenda(Item item, int i) {
		this.setItem(item);
		this.setQuantidade(i);
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
	
}
