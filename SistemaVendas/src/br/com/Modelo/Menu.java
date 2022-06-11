package br.com.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.dao.clienteDAO;
import br.com.dao.itemDAO;
import br.com.dao.vendedorDAO;

public class Menu{

	static Scanner lerString = new Scanner(System.in);
	static Scanner lerInt = new Scanner(System.in);
	static Scanner lerFloat = new Scanner(System.in);
	
	
	static int opc;
	static int opc1;
	static int opc2;
	static int opc3;
	static int opc4;
	static int opci = 2;
	static int opcpag;
	
	public static void menuPrincipal() {
		do {
			System.out.println("+------------------------+");
			System.out.println("|     MENU PRINCIPAL     |");
			System.out.println("+------------------------+");
			System.out.println("| 1- Cliente             |");
			System.out.println("| 2- Vendedor            |");
			System.out.println("| 3- Item                |");
			System.out.println("| 4- Venda               |");
			System.out.println("| 0- Sair                |");
			System.out.println("+------------------------+");
			System.out.print("\nDigite a opcao desejada: ");
			opc = lerInt.nextInt();
			
			switch(opc) {
			case 1:
				menuCliente();
				break;
			case 2:
				menuVendedor();
				break;
			case 3:
				menuItem();
				break;
			case 4:
				menuVenda();
				break;
			case 0:
				System.out.println("Programa Finalizado!!");
				break;
			default:
				System.out.println("\nOpcao Invalida");
			}
			
		}while(opc != 0);
	}
	
	public static void menuCliente() {
		System.out.println("\n+------------------------+");
		System.out.println("|      MENU CLIENTE      |");
		System.out.println("+------------------------+");
		System.out.println("| 1- Cadastrar Cliente   |");
		System.out.println("| 2- Listar Cliente      |");
		System.out.println("| 3- Editar Cliente      |");
		System.out.println("| 4- Excluir Cliente     |");
		System.out.println("| 0- Sair                |");
		System.out.println("+------------------------+");
		
		System.out.print("\nDigite a opcao desejada: ");
		opc1 = lerInt.nextInt();
		
		switch(opc1) {
		case 1:
			Clientes cliente = new Clientes();
			
			System.out.println("\n---------- CADASTRAR CLIENTE ----------");
			System.out.print("Digite o nome do cliente: ");
			cliente.setNome(lerString.nextLine());
			System.out.print("Digite o CPF do cliente: ");
			cliente.setCpf(lerString.nextLine());
			System.out.print("Digite o endereco do cliente: ");
			cliente.setEndereco(lerString.nextLine());
			
			clienteDAO.cadastrarCliente(cliente);
			System.out.println("Cliente adicionado com sucesso!!\n");
			break;
		case 2:
			System.out.println("\n---------- LISTAR CLIENTES ----------");
			clienteDAO.listarClientes();
			System.out.print("\n");
			break;
		case 3:
			System.out.println("\n---------- EDITAR CLIENTE ----------");
			System.out.println("\n---------- LISTA DE CLIENTES ----------\n");
			clienteDAO.listarClientes();
			Clientes cliente3 = new Clientes();
			System.out.print("\nDigite o id do cliente que deseja alterar: ");
			cliente3.setId(lerInt.nextInt());
			System.out.print("Digite o novo nome do cliente: ");
			cliente3.setNome(lerString.nextLine());
			System.out.print("Digite o novo cpf do cliente: ");
			cliente3.setCpf(lerString.nextLine());
			System.out.print("Digite o novo endereco do cliente: ");
			cliente3.setEndereco(lerString.nextLine());
			
			clienteDAO.editarCliente(cliente3);
			System.out.println("Cliente editado com sucesso!!\n");
			break;
		case 4:
			System.out.println("\n---------- EXCLUIR CLIENTE ----------");
			System.out.println("\n---------- LISTA DE CLIENTES ----------\n");
			clienteDAO.listarClientes();
			Clientes cliente4 = new Clientes();
			System.out.print("\nDigite o Id do cliente que deseja excluir: ");
			cliente4.setId(lerInt.nextInt());
			clienteDAO.excluirCliente(cliente4);
			System.out.println("Cliente excluido com sucesso!!\n");
			break;
		case 0:
			break;
		default:
			System.out.println("Opcao Invalida");
		}
		
		
	}
	
	public static void menuVendedor() {
		System.out.println("\n+------------------------+");
		System.out.println("|     MENU VENDEDOR      |");
		System.out.println("+------------------------+");
		System.out.println("| 1- Cadastrar Vendedor  |");
		System.out.println("| 2- Listar Vendedor     |");
		System.out.println("| 3- Editar Vendedor     |");
		System.out.println("| 4- Excluir Vendedor    |");
		System.out.println("| 0- Sair                |");
		System.out.println("+------------------------+");
		
		System.out.print("\nDigite a opcao desejada: ");
		opc2 = lerInt.nextInt();
		
		switch(opc2) {
		case 1:
			Vendedor vendedor = new Vendedor();
			
			System.out.println("\n---------- CADASTRAR VENDEDOR ----------");
			System.out.print("Digite o nome do vendedor: ");
			vendedor.setNome(lerString.nextLine());
			System.out.print("Digite o CPF do vendedor: ");
			vendedor.setCpf(lerString.nextLine());
			System.out.print("Digite o salario do vendedor: ");
			vendedor.setSalario(lerFloat.nextFloat());
			
			vendedorDAO.cadastrarVendedor(vendedor);
			System.out.println("Vendedor adicionado com sucesso!!\n");
			break;
		case 2:
			System.out.println("\n---------- LISTAR VENDEDORES ----------");
			vendedorDAO.listarVendedor();
			System.out.print("\n");
			break;
		case 3:
			System.out.println("\n---------- EDITAR VENDEDOR ----------");
			System.out.println("\n---------- LISTA DE VENDEDORES ----------\n");
			vendedorDAO.listarVendedor();
			Vendedor vendedor3 = new Vendedor();
			System.out.print("\nDigite o id do vendedor que deseja alterar: ");
			vendedor3.setId(lerInt.nextInt());
			System.out.print("Digite o novo nome do vendedor: ");
			vendedor3.setNome(lerString.nextLine());
			System.out.print("Digite o novo cpf do vendedor: ");
			vendedor3.setCpf(lerString.nextLine());
			System.out.print("Digite o novo salario do vendedor: ");
			vendedor3.setSalario(lerFloat.nextFloat());
			
			vendedorDAO.editarVendedor(vendedor3);
			System.out.println("Vendedor editado com sucesso!!\n");
			break;
		case 4:
			System.out.println("\n---------- EXCLUIR VENDEDOR ----------");
			System.out.println("\n---------- LISTA DE VENDEDORES ----------\n");
			vendedorDAO.listarVendedor();
			Vendedor vendedor4 = new Vendedor();
			System.out.print("\nDigite o Id do vendedor que deseja excluir: ");
			vendedor4.setId(lerInt.nextInt());
			vendedorDAO.excluirVendedor(vendedor4);
			System.out.println("Vendedor excluido com sucesso!!\n");
			break;
		case 0:
			break;
		default:
			System.out.println("Opcao Invalida");
		}
		
		
	}
	
	public static void menuItem() {
		System.out.println("\n+------------------------+");
		System.out.println("|       MENU ITEM        |");
		System.out.println("+------------------------+");
		System.out.println("| 1- Cadastrar Item      |");
		System.out.println("| 2- Listar Item         |");
		System.out.println("| 3- Editar Item         |");
		System.out.println("| 4- Excluir Item        |");
		System.out.println("| 0- Sair                |");
		System.out.println("+------------------------+");
		
		System.out.print("\nDigite a opcao desejada: ");
		opc3 = lerInt.nextInt();
		
		switch(opc3) {
		case 1:
			Item item = new Item();
			
			System.out.println("\n---------- CADASTRAR ITEM ----------");
			System.out.print("Digite o nome do item: ");
			item.setNome(lerString.nextLine());
			System.out.print("Digite a unidade de medida do item (UND, KG) : ");
			item.setUnidade(lerString.nextLine());
			System.out.print("Digite o valor do item: ");
			item.setValor(lerFloat.nextFloat());
			
			itemDAO.cadastrarItem(item);
			System.out.println("Item adicionado com sucesso!!\n");
			break;
		case 2:
			System.out.println("\n---------- LISTAR ITENS ----------");
			itemDAO.listarItens();
			System.out.print("\n");
			break;
		case 3:
			System.out.println("\n---------- EDITAR ITEM ----------");
			System.out.println("\n---------- LISTA DE ITENS ----------\n");
			itemDAO.listarItens();
			Item item3 = new Item();
			System.out.print("\nDigite o id do item que deseja alterar: ");
			item3.setId(lerInt.nextInt());
			System.out.print("Digite o novo nome do item: ");
			item3.setNome(lerString.nextLine());
			System.out.print("Digite a nova unidade de medida do item: ");
			item3.setUnidade(lerString.nextLine());
			System.out.print("Digite o novo valor do item: ");
			item3.setValor(lerFloat.nextFloat());
			
			itemDAO.editarItem(item3);
			System.out.println("Item editado com sucesso!!\n");
			break;
		case 4:
			System.out.println("\n---------- EXCLUIR ITEM ----------");
			System.out.println("\n---------- LISTA DE ITENS ----------\n");
			itemDAO.listarItens();
			Item item4 = new Item();
			System.out.print("\nDigite o Id do item que deseja excluir: ");
			item4.setId(lerInt.nextInt());
			itemDAO.excluirItem(item4);
			System.out.println("Item excluido com sucesso!!\n");
			break;
		case 0:
			break;
		default:
			System.out.println("Opcao Invalida");
		}
		
		
	}
	
	public static void menuVenda() {
		System.out.println("\n+------------------------+");
		System.out.println("|       MENU VENDA       |");
		System.out.println("+------------------------+");
		System.out.println("| 1- Nova Venda          |");
		System.out.println("| 0- Sair                |");
		System.out.println("+------------------------+");
		
		System.out.print("\nDigite a opcao desejada: ");
		opc4 = lerInt.nextInt();
		
		switch(opc4) {
		case 1:
			
			Venda venda = new Venda();
			Vendedor vendedor = new Vendedor();
			Clientes cliente = new Clientes();
			
			System.out.println("\n---------- NOVA VENDA ----------\n");
			
			System.out.println("Data da venda: " + venda.getDataDaVenda());
			
			System.out.println("\n---------- SELECIONAR VENDEDOR ----------\n");
			vendedor = vendedorDAO.selecionarVendedor();
			System.out.println("\nVendedor: " + vendedor.getNome());
			
			System.out.println("\n---------- SELECIONAR CLIENTE ----------\n");
			cliente = clienteDAO.selecionarCliente();
			System.out.println("\nCliente: " + cliente.getNome());
			
			venda.setVendedor(vendedor);
			venda.setCliente(cliente);
			
			System.out.println("\n---------- SELECIONAR ITENS ----------\n");
			itemDAO.listarItens();
			ArrayList<ItemVenda> carrinho = new ArrayList<ItemVenda>();
			do {
							
				carrinho.add(Carrinho.adicionarItem());
				opci = 2;
				while((opci != -1) && (opci != 0)) {
					System.out.println("\nDeseja adicionar mais produtos? ");
					System.out.println(" 0 para SIM");
					System.out.println("-1 para NAO");
					System.out.print("Digite a opcao desejada: ");
					opci = lerInt.nextInt();
					if((opci != -1) && (opci != 0)) {
						System.out.println("\nOpcao invalida!");
					}
				}
			}while(opci != -1);
			
			venda.setCarrinho(carrinho);
			System.out.println("");
			
			System.out.println("\n------------- PRODUTOS -------------");
			for(ItemVenda item : venda.getCarrinho()) {
				System.out.print("Produto: " + item.getItem().getNome() + " | ");
				System.out.print("Quantidade: " + item.getQuantidade() + " | ");
				System.out.println("Valor: " + item.getItem().getValor());
			}
			System.out.println("------------------------------------");
			System.out.println("Valor Total: " + venda.getValorTotal());
			
			System.out.println("\n1 - DINHEIRO");
			System.out.println("2 - PIX");
			System.out.println("3 - CARTAO");
			System.out.print("Selecione a forma de pagamento: ");
			opcpag = lerInt.nextInt();
			switch(opcpag) {
			case 1:
				venda.setFormaPagamento("DINHEIRO");
				System.out.println("\nForma de pagamento escolhida: " + venda.getFormaPagamento());
				venda.PagarDinheiro();
				break;
			case 2:
				venda.setFormaPagamento("PIX");
				System.out.println("\nForma de pagamento escolhida: " + venda.getFormaPagamento());
				venda.PagarPix();
				break;
			case 3:
				venda.setFormaPagamento("CARTAO");
				System.out.println("\nForma de pagamento escolhida: " + venda.getFormaPagamento());
				venda.PagarCartao();
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			
			System.out.println("\n-----------------------------------------------------------------------------");
			System.out.println("\nData da Venda: " + venda.getDataDaVenda());
			System.out.println("Vendedor: " + venda.getVendedor().getNome());
			System.out.println("Cliente: " + venda.getCliente().getNome());
			System.out.println("Endereco de Entrega: " + venda.getEnderecoEntrega());
			System.out.println("\n------------- PRODUTOS -------------");
			for(ItemVenda item : carrinho) {
				System.out.print("Produto: " + item.getItem().getNome() + " | ");
				System.out.print("Quantidade: " + item.getQuantidade() + " | ");
				System.out.println("Valor: " + item.getItem().getValor());
			}
			System.out.println("------------------------------------");
			System.out.println("Valor Total: " + venda.getValorTotal());
			System.out.println("Quantidade de itens: " + venda.getQuantidadeItens());
			System.out.println("Forma de pagamento: " + venda.getFormaPagamento());
			System.out.println("\nObrigado por comprar conosco!!!\n");
			System.out.println("\nDigite um numero para voltar ao menu principal\n");
			lerInt.nextInt();
		case 0:
			break;
		default:
			System.out.println("Opcao Invalida");
		}
		
		
	}

}