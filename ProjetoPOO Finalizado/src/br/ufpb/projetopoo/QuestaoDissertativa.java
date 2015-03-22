package br.ufpb.projetopoo;

import java.io.Serializable;

public class QuestaoDissertativa extends Questao implements Serializable{

	public QuestaoDissertativa(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta) {
		super(tq, numDeQuestao, pergunta, resposta);
		
	}

	
}