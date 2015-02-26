package br.ufpb.projetopoo;

public class Resposta {
	
	private String respostaDoAluno;
	private long numDeQuestao;
	private String nomeDeExercicio;
	
	
	public String getRespostaDoAluno() {
		return respostaDoAluno;
	}
	
	public Resposta (String respostaDoAluno, long numDeQuestao, String nomeDeExercicio){
		this.respostaDoAluno = respostaDoAluno;
		this.numDeQuestao = numDeQuestao;
		this.nomeDeExercicio = nomeDeExercicio;
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

}
