package br.com.Modelo;

public class Item {
	
	private int id;
	private String nome;
	private String unidade;
	private float valor;
	
	public Item() {
		
	}
	
	public Item(String nome, String unidade, float valor) {
		this.setNome(nome);
		this.setUnidade(unidade);
		this.setValor(valor);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	@Override
    public String toString() {
        return getId() + " - " + getNome() + " - " + getUnidade() + " - R$" + getValor();
    }
}
