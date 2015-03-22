package br.ufpb.projetopoo;

import java.io.Serializable;

public class Resposta extends Aluno implements Serializable{
	
	private String pergunta;
	private String respostaDoAluno;
	private long numDeQuestao;
	private String nomeDeExercicio;
	
	
	public Resposta(String pergunta, String nome, TipoDeUsuario tu, String email, String respostaDoAluno, long numDeQuestao, String nomeDeExercicio) {
		super(nome, tu, email);
		this.pergunta = pergunta;
		this.respostaDoAluno = respostaDoAluno;
		this.numDeQuestao = numDeQuestao;
		this.nomeDeExercicio = nomeDeExercicio;
	}
	
	public String getRespostaDoAluno() {
		return respostaDoAluno;
	}
	
	
	public long getNumDeQuestao() {
		return numDeQuestao;
	}

	public void setNumDeQuestao(long numDeQuestao) {
		this.numDeQuestao = numDeQuestao;
	}

	public String getNomeDeExercicio() {
		return nomeDeExercicio;
	}

	public void setNomeDeExercicio(String nomeDeExercicio) {
		this.nomeDeExercicio = nomeDeExercicio;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

}
