package br.ufpb.projetopoo;

public class Questao {
	private long numDeQuestao;
	private String pergunta;
	private String resposta;
	private TipoDeQuestoes tq;
	
	public Questao(TipoDeQuestoes tq,long numDeQuestao, String pergunta, String resposta){
		this.numDeQuestao = numDeQuestao;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.tq = tq;
		 
	}
	public void setPergunta(String pergunta){
		this.pergunta = pergunta;
	}
	
	public String  getPergunta(){
		return pergunta;
	}
	
	public void setNumDeQuestao(long numDeQuestao){
		this.numDeQuestao = numDeQuestao;
	}

	public long getNumDeQuestao() {
		return numDeQuestao;
	}
	
	public void setResposta(String resposta){
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}
	public TipoDeQuestoes getTq() {
		return tq;
	}
	public void setTq(TipoDeQuestoes tq) {
		this.tq = tq;
	}
	
}
