package br.ufpb.projetopoo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FachadaTeste {
	Fachada fachada = new Fachada ();
	GerenteDeQuestoes gQ = new GerenteDeQuestoes();
	GerenteDeExercicios gE = new GerenteDeExercicios();

	@Test
	public void test(){
		
		try{
			//cadastro de professores
			
			fachada.cadastrarUsuario("Ayla", TipoDeUsuario.Professor, "ayla@dce.ufpb.br");
			fachada.cadastrarUsuario("Rafael",TipoDeUsuario.Professor, "rafael@dce.ufpb.br");
			
			//cadastro de alunos
			
			fachada.cadastrarUsuario("Rafa", TipoDeUsuario.Aluno, "rafa@dce.ufpb.br");
			fachada.cadastrarUsuario("Thami", TipoDeUsuario.Aluno, "thami@dce.ufpb.br");
			
			//pesquisa de professores
			
			assertEquals("Rafael", fachada.pesquisarUsuarioPeloEmail("rafael@dce.ufpb.br", TipoDeUsuario.Professor).getNome());
			assertEquals("Ayla", fachada.pesquisarUsuarioPeloEmail("ayla@dce.ufpb.br", TipoDeUsuario.Professor).getNome());
			
			//pesquisa de alunos
			
			assertEquals("Rafa", fachada.pesquisarUsuarioPeloEmail("rafa@dce.ufpb.br", TipoDeUsuario.Aluno).getNome());
			assertEquals("Thami", fachada.pesquisarUsuarioPeloEmail("thami@dce.ufpb.br", TipoDeUsuario.Aluno).getNome());
			
			// remover usuario
			fachada.removerUsuarioPeloEmail("rafa@dce.ufpb.br", TipoDeUsuario.Aluno);
			//tem que dar Usu�rioInexistenteException
			assertFalse(fachada.pesquisarUsuarioPeloEmail("rafa@dce.ufpb.br", TipoDeUsuario.Aluno).getNome().equals("Rafa"));
			
			//cadastro de exerc�cio
			  
			
			Exercicio e = new Exercicio("Exerc�cio de POO");
			fachada.cadastrarExercicio(e);
			Exercicio e1 = new Exercicio("Exerc�cio de Arquitetura II");
			fachada.cadastrarExercicio(e1);
			
			//pesquisar exerc�cio
			
			fachada.pesquisarExercicio("Exerc�cio de POO");
			fachada.pesquisarExercicio("Exerc�cio de Arquitetura II");
			
			
			
			
			//cadastro de quest�es dissertativas
			QuestaoDissertativa q1 = new QuestaoDissertativa(TipoDeQuestoes.Dissertativa, 1, "Quanto � 1+1?", "2");
			fachada.cadastrarQuestaoDissertativa(e, q1);
			QuestaoDissertativa q2 = new QuestaoDissertativa(TipoDeQuestoes.Dissertativa, 1, "O que � um hardware?", "A parte f�sica de um computador.");
			fachada.cadastrarQuestaoDissertativa(e1, q2);
			
			//pesquisando quest�es dissertativas
			
			 assertEquals( "O que � um hardware?",fachada.pesquisarQuestaoDissertativa(gE, "Exerc�cio de Arquiterura II", 1).getPergunta());
			 assertEquals( "Quanto � 1+1?",fachada.pesquisarQuestaoDissertativa(gE, "Exerc�cio de POO", 1).getPergunta());
				
			 //remover quest�o do exercicio de POO
			 fachada.removerQuestaoDissertativa(gE,"Exerc�cio de POO", 1);
			 assertEquals( "O que � um hardware?",fachada.pesquisarQuestaoDissertativa(gE, "Exerc�cio de Arquiterura II", 1).getPergunta());
			 
			 //tem que dar QuestaoInexistenteException
			 assertFalse(fachada.pesquisarQuestaoDissertativa(gE, "Exerc�cio de POO", 1).getPergunta().equals("Quanto � 1+1"));
			 
			 //cadastrando quest�es objetivas
			 List<String> alternativas = new ArrayList<String>();
			 String a = "1";
			 String b = "2";
			 String c = "3";
			 String d = "5";
			 alternativas.add(a);
			 alternativas.add(b);
			 alternativas.add(c);
			 alternativas.add(d);
			 QuestaoObjetiva q3 = new QuestaoObjetiva(TipoDeQuestoes.Objetiva, 1, "Quanto � 2+3?", "5", alternativas);
			 fachada.cadastrarQuestaoObjetiva(e, q3);
			 QuestaoObjetiva q4 = new QuestaoObjetiva(TipoDeQuestoes.Objetiva, 2, "Quanto � 2+3?", "5", alternativas);
			 fachada.cadastrarQuestaoObjetiva(e1,q4);

			 // pesquisando quest�es objetivas
			 assertEquals( "Quanto � 2+3?",fachada.pesquisarQuestaoObjetiva(gE, "Exerc�cio de POO", 1).getPergunta());
			 assertEquals( "Quanto � 1+1?",fachada.pesquisarQuestaoObjetiva(gE, "Exerc�cio de Arquitetura II", 2 ).getPergunta());
			 
			 // remover quest�o objetiva do exercicio de arquitetura
			 fachada.removerQuestaoObjetiva(gE, "Exerc�cio de Arquitetura II", 2);
			 
			 // cadastrar quest�o vouf
			 QuestaoVouF q5 = new QuestaoVouF(TipoDeQuestoes.VouF, 2, "O teclado � um software!", "F");
			 fachada.cadastrarQuestaoVouF(e,q5);
		 
			 // pesquisar quest�o vouf
			assertEquals("O teclado � um software!",fachada.pesquisarQuestaoVouF(gE, "Exerc�cio de POO", 2 ).getPergunta());

			// remover exercicio
				fachada.removerExercicio("Exerc�cio de Arquitetura II");
				fachada.pesquisarExercicio("Exerc�cio de Arquitetura II");
				
	
		
		}catch(ExercicioJaExisteException e){
			fail("Oops, n�o deveria mostrar esta mensagem" + e.getMessage());

		}catch(UsuarioInexistenteException u){
			assertTrue(true);
		
		}catch(UsuarioJaExisteException u){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + u.getMessage());			
			
		}catch(ExercicioInexistenteException e){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + e.getMessage());
		}
		catch(QuestaoInexistenteException e){
			assertTrue(true);		
		
		}catch(QuestaoJaExisteException e){
			fail("Ooops, n�o deveria mostrar esta mensagem: " + e.getMessage());
		}
		
	}
}
		

		