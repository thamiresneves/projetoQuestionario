package br.ufpb.projetopoo;

import java.io.Serializable;


public class QuestaoVouF extends Questao implements Serializable{
	
	public QuestaoVouF(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta) {
		super(tq, numDeQuestao, pergunta, resposta);
		
	}
	
}
