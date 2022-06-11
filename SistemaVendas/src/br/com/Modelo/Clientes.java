package br.com.Modelo;

public class Clientes extends Pessoa {
	
	private static String endereco;
	
	public Clientes(){
	}
	
	public Clientes(String nome, String cpf, String endereco) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
	}
	
	public static String getEndereco() {
		return endereco;
	}

	public static void setEndereco(String endereco) {
		Clientes.endereco = endereco;
	}
	
	@Override
    public String toString() {
        return getId() + " - " + getNome() + " - " + getCpf() + " - " + getEndereco();
    }
}