package br.ufpb.projetopoo;

 import java.util.List;
import java.util.ArrayList;
 
public class GerenteDeUsuario{
	
	private List <Aluno> alunos = new ArrayList<Aluno>();
	private List<Professor> professores = new ArrayList <Professor>();
	
	public void cadastrarUsuarioAluno(String nome, TipoDeUsuario tu, String email)throws UsuarioJaExisteException{
		for(Aluno a : this.alunos){
			if(a.getNome() == nome){
				throw new UsuarioJaExisteException ("Aluno já foi cadastrado!");
			}
		}
		Aluno a = new Aluno(nome, tu, email);
		this.alunos.add(a);
	}
	
	public void cadastrarUsuarioProfessor(String nome, TipoDeUsuario tu, String email)throws UsuarioJaExisteException{
		for(Professor p : this.professores){
			if(p.getNome() == nome){
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
		 if(tu.equals(TipoDeUsuario.Aluno)){
			for(Aluno a: this.alunos){
				if(a.getEmail().equals(email)){
					alunos.remove(a);
				}
			}
			throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
		}	
		else{
			for(Professor p: this.professores){
				if(p.getEmail().equals(email)){
					professores.remove(p);
				}
			}throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
		}
	 }
	 
	 public String pesquisarUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
		 if(tu.equals(TipoDeUsuario.Aluno)){
				for(Aluno a: this.alunos){
					if(a.getEmail().equals(email)){
						return a.getNome();
					}
				}
				throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
			}	
			else{
				for(Professor p: this.professores){
					if(p.getEmail().equals(email)){
						return p.getNome();
					}
				}throw new UsuarioInexistenteException("Este usuário não foi cadastrado!");
			}
	 }

	public List <Aluno> getAluno() {
		return this.alunos;
	}
	
	public List <Professor> getProfessor(){
		return this.professores;
	}
	

}
