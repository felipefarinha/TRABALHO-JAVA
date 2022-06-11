package br.com.Modelo;

public class Vendedor extends Pessoa {
	
	private static Float salario;
	
	public Vendedor(){
	}
	
	public Vendedor(String nome, String cpf, float salario) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setSalario(salario);
	}
	
	public static Float getSalario() {
		return salario;
	}

	public static void setSalario(Float salario) {
		Vendedor.salario = salario;
	}
	
	@Override
    public String toString() {
        return getId() + " - " + getNome() + " - " + getCpf() + " - R$" + getSalario();
    }

}