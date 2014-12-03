package br.ufpb.projetoquestoes;

public interface InterfaceSistemaDeQuestoes {
	
	public void cadastrarQuestao(Questao q);
	public Questao pesquisarQuestao(long numDeQuestao, String tipoDeQuestao);
	public void removerQuestao(Questao q);
	

}
