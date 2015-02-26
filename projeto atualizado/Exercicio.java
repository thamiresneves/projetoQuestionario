package br.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;

public class Exercicio {
	
	private String nomeDeExercicio;
	private List <Questao> questoes;
	
	
	public Exercicio(String nomeDeExercicio){
		this.nomeDeExercicio = nomeDeExercicio;
		this.questoes = new ArrayList <Questao>();
	}

	public String getNomeDeExercicio() {
		return nomeDeExercicio;
	}

	public void setNomeDeExercicio(String nomeDeExercicio) {
		this.nomeDeExercicio = nomeDeExercicio;
	}

	public List <Questao> getQuestoes() {
		return questoes;
	}
	
	public void cadastrarQuestaoDissertativaNoExercicio(QuestaoDissertativa qd){
		this.questoes.add(qd);
		
	}
	
	public void cadastrarQuestaoObjetivaNoExercicio(QuestaoObjetiva qo){
		this.questoes.add(qo);
	}
	
	public void cadastrarQuestaoVouFNoExercicio(QuestaoVouF qvf){
		this.questoes.add(qvf);
	}

	
	
}
