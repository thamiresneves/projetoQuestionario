package br.ufpb.projetopoo;

public class Usuario {
	private String nome;
	private TipoDeUsuario tu;
	private String email;
	
	public Usuario(String nome,TipoDeUsuario tu, String email){
		this.nome = nome;
		this.tu = tu;
		this.email = email;
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

	public TipoDeUsuario getTu() {
		return tu;
	}

	public void setTu(TipoDeUsuario tu) {
		this.tu = tu;
	}
	
	
}