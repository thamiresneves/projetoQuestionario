package br.ufpb.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class QuestaoObjetiva extends Questao implements Serializable {
	private List <String> alternativas;
	
	
	public QuestaoObjetiva(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta, List <String> alternativas) {
		super(tq, numDeQuestao, pergunta, resposta);
		this.alternativas = alternativas;
		
	}
	public List <String> getAlternativas() {
		return alternativas;
	}

	

}