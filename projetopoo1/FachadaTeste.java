package br.ufpb.projetopoo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FachadaTeste {
	Fachada fachada = new Fachada ();

	@Test
	public void test(){
		
		try{
			
			fachada.cadastrarUsuario("Ayla", TipoDeUsuario.Professor, "ayla@dce.ufpb.br");
			fachada.cadastrarUsuario("Rafa", TipoDeUsuario.Aluno, "rafa@dce.ufpb.br");
			
		
		}catch(UsuarioJaExisteException u){
			fail("Ooops, n�o deveria mostrar esta mensagem");
			
		}
		
		System.out.println(fachada.getProfessor().size());
 		System.out.println(fachada.getAluno().size());
		
		
		try{
			Exercicio e = new Exercicio("Exerc�cio de POO");
			fachada.cadastrarExercicio(e);
			fachada.pesquisarExercicio("Exerc�cio de POO");
			
			
		}catch(ExercicioInexistenteException e){
			fail("Ooops, n�o deveria mostrar esta mensagem");
		}

		try{
			
			assertEquals("Ayla",fachada.pesquisarUsuarioPeloEmail("ayla@dce.ufpb.br", TipoDeUsuario.Professor));
		}catch(UsuarioInexistenteException u){
			fail("Ooops, n�o deveria mostrar esta mensagem: " +  u.getMessage());
			
		}
		
		try{
			fachada.cadastrarQuestaoDissertativa(TipoDeQuestoes.Dissertativa, 1, "Quanto � 1 + 1?", "2");
			assertEquals("Quanto � 1 + 1?", fachada.pesquisarQuestaoDissertativa(1));
		}catch(QuestaoInexistenteException q){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + q.getMessage());
		}
	}
}