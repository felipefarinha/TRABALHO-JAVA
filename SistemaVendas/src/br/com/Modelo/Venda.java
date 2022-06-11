package br.com.Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.Modelo.Venda;

public class Venda implements MetodoPagamento{
		
	Locale localeBR = new Locale("pt","BR");
	Scanner ler = new Scanner(System.in);
	Scanner lerFloat = new Scanner(System.in);
	
	private static Vendedor vendedor;
	private static Clientes cliente;
	private static Date data = new Date();
	private static String dataDaVenda = new SimpleDateFormat("dd'/'MM'/'yyyy").format(data);
	private static String formaPagamento;
	private static ArrayList<ItemVenda> carrinho = new ArrayList<ItemVenda>();
	
	public static Vendedor getVendedor() {
		return vendedor;
	}

	public static void setVendedor(Vendedor vendedor) {
		Venda.vendedor = vendedor;
	}

	public static Clientes getCliente() {
		return cliente;
	}

	public static void setCliente(Clientes cliente) {
		Venda.cliente = cliente;
	}

	public static Date getData() {
		return data;
	}

	public static void setData(Date data) {
		Venda.data = data;
	}

	public static String getDataDaVenda() {
		return dataDaVenda;
	}

	public List<ItemVenda> getCarrinho() {
		return this.carrinho;
	}
	
	public static String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setCarrinho(ArrayList<ItemVenda> carrinho) {
		this.carrinho = carrinho;
	}	
		
	public Float getValorTotal() {
		Float valorTotal = 0f;
		for(ItemVenda itemvenda : this.carrinho) {
			valorTotal = valorTotal + ((itemvenda.getQuantidade() * itemvenda.getItem().getValor()));
		}
		return valorTotal;
	}
	
	public String getEnderecoEntrega() {
		return this.getCliente().getEndereco();
	}
	
	public int getQuantidadeItens() {
		int qtdItens = 0;
		for(ItemVenda itemvenda : this.carrinho) {
			qtdItens = qtdItens + itemvenda.getQuantidade();;
		}
		return qtdItens;
	}

	@Override
	public String PagarDinheiro() {
		System.out.println("O valor a ser pago em dinheiro é R$"+ this.getValorTotal());
		System.out.print("Digite o valor pago em dinheiro: R$");
		float valorPago = ler.nextFloat();
		float troco = valorPago - this.getValorTotal();
		System.out.printf("Troco: R$%.2f\n", troco);
		return null;
	}

	@Override
	public String PagarPix() {
		float valorpag;
		System.out.println("O valor a ser pago em PIX é R$"+ this.getValorTotal());
		System.out.print("Digite o valor pago em PIX: R$");
		valorpag = lerFloat.nextFloat();
		System.out.println("Valor recebido com sucesso!");
		return null;
	}

	@Override
	public String PagarCartao() {
		System.out.println("O valor a ser pago em Cartão é R$"+ this.getValorTotal());
		System.out.print("Numero de parcelas: ");
		int nparcelas = ler.nextInt();
		float parcelas = this.getValorTotal()/nparcelas;
		System.out.println(nparcelas +"x de R$" + parcelas);
		System.out.print("Digite 1 para confirmar o pagamento: ");
		int confirmacao = ler.nextInt();
		System.out.println("Valor recebido com sucesso!");
		return null;
	}

}

	

