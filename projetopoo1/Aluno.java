package br.ufpb.projetopoo;

public class Aluno extends Usuario{

	private String nome;
	private String email;
	
	public Aluno(String nome, TipoDeUsuario tu, String email) {
		super(nome, tu, email);
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}


