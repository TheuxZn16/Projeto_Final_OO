package entidades;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
	
	
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
	private List<Double> avaliacoes = new ArrayList<>();


	public Usuario(String nome, String cpf, String email, String telefone, String senha)  {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha; 
	}
	
	public String getNome()  {
		return nome; 
	}
	
	public String getCpf()   {
		return cpf;
	}
	
	public String getEmail()  {
		return email;
	}
	
	public String getTelefone()  {
		return telefone;
	}
	
	public boolean autenticar(String senha) {
		return this.senha.equals(senha);
	}
	
	public void addAvaliacoes(double avaliacao) {
		avaliacoes.add(avaliacao);
	}
	
	public double getAvaliacaoMedia() {
		if (avaliacoes.isEmpty()) return 0.0;
		double soma = 0;
		for (double n : avaliacoes) soma += n;
		return soma / avaliacoes.size();
	}
}
