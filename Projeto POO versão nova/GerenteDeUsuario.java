package br.ufpb.projetopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
 
public class GerenteDeUsuario{
	
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
	 
	 public String pesquisarUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
		 if(tu.equals(TipoDeUsuario.Aluno)){
				for(Aluno a: this.alunos){
					if(a.getEmail()!= null && a.getEmail().equals(email)){
						return a.getNome();
						 
					}
				}
				throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
					
		 }
		 else{
				for(Professor p: this.professores){
					if(p.getEmail()!= null && p.getEmail().equals(email)){
						return p.getNome();	
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
	
	public void gravarAlunosEmArquivo(String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Aluno aluno: this.alunos){
				gravador.write(aluno.getNome()+"\n");
				gravador.write(aluno.getTu()+"\n");
				gravador.write(aluno.getEmail()+"\n");
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	public void lerAlunosEmArquivo(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
				leitor.readLine();
				leitor.readLine();
				leitor.readLine();
			
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}		
	}
	
	public void gravarProfessoresEmArquivo(String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Professor professor: this.professores){
				gravador.write(professor.getNome()+ "\n");
				gravador.write(professor.getTu()+ "\n");
				gravador.write(professor.getEmail()+ "\n");
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	
	public void lerProfessoresEmArquivo(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
				leitor.readLine();
				leitor.readLine();
				leitor.readLine();
			
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}		
	}

}