package br.ufpb.projetoquestoes;

import java.util.ArrayList;
import java.util.List;

public class Questao {
	private List <Questao> questoes = new ArrayList <Questao>();
	private long numDeQuestao;
	private String tipoDeQuestao;
	
	
	
	public long getNumDeQuestao() {
		return numDeQuestao;
	}
	public void setNumDeQuestao(long numDeQuestao) {
		this.numDeQuestao = numDeQuestao;
	}
	public String getTipoDeQuestao() {
		return tipoDeQuestao;
	}
	public void setTipoDeQuestao(String tipoDeQuestao) {
		this.tipoDeQuestao = tipoDeQuestao;
	}
	
	public Questao (long numDeQuestao, String tipoDeQuestao){
		this.numDeQuestao = numDeQuestao;
		this.tipoDeQuestao = tipoDeQuestao;
		
	}

	
	public void cadastrarResposta(long numDeQuestao, String tipoDeQuestao){
		//TODO
		
	}
	public void cadastrarQuestao(Questao q) {
		questoes.add(q);	
		
	}
	public Questao pesquisarQuestao(long numDeQuestao, String tipoDaQuestao) {
		for(Questao q: this.questoes){
			if(q.getNumDeQuestao() == numDeQuestao && q.getTipoDeQuestao().equals(tipoDaQuestao)){
				
				
			}
		}return q;
		
	}
	public void removerQuestao(Questao q) {
		for(Questao q1: this.questoes){
			if(q1.equals(q)){
				questoes.remove(q);
				break;
			}
		}
		
	}
	
	public List<Questao> getQuestoes(){
		return questoes;
	}
	

}
