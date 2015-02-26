package br.ufpb.projetopoo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FachadaTeste {
	Fachada fachada = new Fachada ();

	@Test
	public void test(){
		
		try{
			
			fachada.cadastrarUsuario("Ayla", TipoDeUsuario.Professor, "ayla@dce.ufpb.br");
			fachada.cadastrarUsuario("Rafa", TipoDeUsuario.Aluno, "rafa@dce.ufpb.br");
		
		}catch(UsuarioJaExisteException u){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + u.getMessage());
			
		}
		
		try{
			fachada.removerUsuarioPeloEmail("rafa@dce.ufpb.br", TipoDeUsuario.Aluno);
		
		}catch(UsuarioInexistenteException u){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + u.getMessage());
		
		}
		
		try{
			Exercicio e = new Exercicio("Exerc�cio de POO");
			fachada.cadastrarExercicio(e);
			assertEquals("Exerc�cio de POO",fachada.pesquisarExercicio("Exerc�cio de POO"));
			
			
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
			String a = "1";
			String b = "0";
			String c = "5";
			String d = "2";
			List <String> alternativas = new ArrayList <String> ();
			alternativas.add(a);
			alternativas.add(b);
			alternativas.add(c);
			alternativas.add(d);
			fachada.cadastrarQuestaoObjetiva(TipoDeQuestoes.Objetiva, 1,  "Quanto � 1 + 1?", "d", alternativas );
			assertEquals("Quanto � 1 + 1?", fachada.pesquisarQuestaoObjetiva(1));
			fachada.cadastrarQuestaoVouF(TipoDeQuestoes.VouF, 1, "A uva � verde.", "V");
			assertEquals("A uva � verde.", fachada.pesquisarQuestaoVouF(1));
	
			
		}catch(QuestaoInexistenteException q){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + q.getMessage());
		}
	}
}