package br.ufpb.projetopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
 
public class GerenteDeUsuario implements Serializable{
	
	private List <Aluno> alunos = new ArrayList<Aluno>();
	private List<Professor> professores = new ArrayList <Professor>();
	
	public void cadastrarUsuarioAluno(String nome, TipoDeUsuario tu, String email)throws UsuarioJaExisteException{
		for(Aluno a : this.alunos){
			if(a.getEmail()!= null && a.getEmail().equals(email)){
				throw new UsuarioJaExisteException ("Aluno já foi cadastrado!");
			}
		}
		Aluno a = new Aluno(nome, tu, email);
		this.alunos.add(a);
	}
	
	public Aluno obterAlunoPeloNome(String nome){
		for(Aluno a: this.alunos){
			if(a.getNome().equals(nome)){
				return a;
			}
		}return null;
		
	}
	
	public void cadastrarUsuarioProfessor(String nome, TipoDeUsuario tu, String email)throws UsuarioJaExisteException{
		for(Professor p : this.professores){
			if(p.getEmail()!= null && p.getEmail().equals(email)){
				throw new UsuarioJaExisteException ("Professor já foi cadastrado!");
			}
		}
		
		Professor p = new Professor(nome, tu, email);
		this.professores.add(p);
	}
	
	public void cadastrarUsuario(String nome, TipoDeUsuario tu, String email) throws UsuarioJaExisteException{
		if(tu.equals(TipoDeUsuario.Aluno)){
			cadastrarUsuarioAluno(nome, tu, email);
		}else{
			cadastrarUsuarioProfessor(nome, tu, email);
		}
	}

	 public void removerUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
		 boolean removeu = false;
		 if(tu.equals(TipoDeUsuario.Aluno)){
			for(Aluno a: this.alunos){
				if(a.getEmail()!= null && a.getEmail().equals(email)){	
					alunos.remove(a);
					removeu = true;
					break;
				}
			}
			if(!removeu){
				throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
			}
		}	
		else{
			for(Professor p: this.professores){
				if(p.getEmail()!= null && p.getEmail().equals(email)){
					professores.remove(p);
					removeu = true;
					break;
				}
			}
			if(!removeu){
				throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
			}
		}
	 }
	 
	 public boolean validarUsuario(String email, TipoDeUsuario tu){
		try{
			this.pesquisarUsuarioPeloEmail(email, tu);		
			return true;
		}
		catch (UsuarioInexistenteException e ){
			return false;
		}
	 }
	 public String pegarNomeDeUsuario(String email, TipoDeUsuario tu){
		try{
			return this.pesquisarUsuarioPeloEmail(email, tu).getNome();
		}
		catch(UsuarioInexistenteException e){
			return " ";
		}
	 }
	 
	 
	 public Usuario pesquisarUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
		 if(tu.equals(TipoDeUsuario.Aluno)){
				for(Aluno a: this.alunos){
					if(a.getEmail()!= null && a.getEmail().equals(email)){
						return a;
						 
					}
				}
				throw new UsuarioInexistenteException("Usuário não encontrado!");
					
		 }
		 else{
				for(Professor p: this.professores){
					if(p.getEmail()!= null && p.getEmail().equals(email)){
						return p;	
					}
				}
				throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
			}	
	 }

	public List <Aluno> getAluno() {
		return this.alunos;
	}
	
	public List <Professor> getProfessor(){
		return this.professores;
	}
	

}