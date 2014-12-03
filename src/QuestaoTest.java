package br.ufpb.projetoquestoes;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestaoTest {

	@Test
	public void test() {
		Questao q = new Questao(1,"Dissertativa");
		q.cadastrarQuestao(q);
		assertEquals(1,q.getQuestoes().size());
		q.removerQuestao(q);
		assertFalse(q.getQuestoes().size()== 1);
	}

}
