package br.ufpb.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements Serializable{
	List<Exercicio> exerciciosResolvidosDoAluno = new ArrayList<Exercicio>();
	List<Resposta> respostas = new ArrayList<Resposta>();
	

	public Aluno(String nome, TipoDeUsuario tu, String email) {
		super(nome, tu, email);	
	}

	public void adicionarResposta(String respostaDoAluno,String pergunta, long numDeQuestao, String nomeDeExercicio){
		this.respostas.add(new Resposta(pergunta, super.nome, super.tu, super.email, respostaDoAluno, numDeQuestao, nomeDeExercicio));
	}
	
	public List<Resposta> getRespostas(){
		return this.respostas;
	}
	
	public void cadastrarExerciciosResolvidosDoAluno(Exercicio e){
		this.exerciciosResolvidosDoAluno.add(e);
	}
	
	public List<Exercicio> getExerciciosResolvidosDoAluno(){
		return this.exerciciosResolvidosDoAluno;
	}
	
	public Resposta pesquisaRespostaDoAluno(Exercicio e, long numDeQuestao) throws QuestaoInexistenteException{
		Resposta respostaInicial = null;
		for(Resposta r: this.respostas){
			if(r.getNomeDeExercicio().equals(e.getNomeDeExercicio()) && (r.getNumDeQuestao() == numDeQuestao)){
				respostaInicial = r;
				return respostaInicial;
			}
		}throw new QuestaoInexistenteException("Questão: "+numDeQuestao+" não cadastrada!");
		
	}
	
	public boolean AlunoRespondeuExercicio(Exercicio e){
		for(Exercicio e1: this.exerciciosResolvidosDoAluno){
			if(e1.equals(e)){
				return true;
			}
		}return false;
	}
	
	
	
	

	
	
	
}

