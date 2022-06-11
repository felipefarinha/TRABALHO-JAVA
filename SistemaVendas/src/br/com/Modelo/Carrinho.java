package br.com.Modelo;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.dao.itemDAO;

public class Carrinho {
	
	public static ItemVenda adicionarItem() {
		Scanner lerInt = new Scanner(System.in);
		ItemVenda itemVenda = new ItemVenda(null, 0);
		int opci;
		
		do {

			do {
				System.out.print("\nDigite o Id do item: ");
				int id = lerInt.nextInt();
				itemVenda.setItem(itemDAO.selecionarItem(id));
				if(itemVenda.getItem().getNome() == null) {
					System.out.println("O item nao existe!");
				}
			}while (itemVenda.getItem().getNome() == null);		
		
			System.out.print("Digite a quantidade do item: ");
			itemVenda.setQuantidade(lerInt.nextInt());
			
		}while(itemVenda.getItem().getNome() == null);
		
		return itemVenda;
	}
	
}
