package br.ufpb.projetopoo;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FachadaTeste {
	Fachada fachada = new Fachada ();

	@Test
	public void test() throws QuestaoInexistenteException{
		
		try{
			
			fachada.cadastrarUsuario("Ayla", TipoDeUsuario.Professor, "ayla@dce.ufpb.br");
			fachada.cadastrarUsuario("Rafa", TipoDeUsuario.Aluno, "rafa@dce.ufpb.br");
			fachada.cadastrarUsuario("Thami", TipoDeUsuario.Aluno, "thami@dce.ufpb.br");
		
		}catch(UsuarioJaExisteException u){
			fail("Ooops, não deveria mostrar esta mensagem: " + u.getMessage());
			
		}
		
		try{
			assertEquals("Rafa", fachada.pesquisarUsuarioPeloEmail("rafa@dce.ufpb.br", TipoDeUsuario.Aluno));
			
		
		}catch(UsuarioInexistenteException u){
			fail("Ooops, não deveria mostrar esta mensagem: " + u.getMessage());
		
		}
		
		try{
			
			assertEquals("Ayla",fachada.pesquisarUsuarioPeloEmail("ayla@dce.ufpb.br", TipoDeUsuario.Professor));
			fachada.removerUsuarioPeloEmail("rafa@dce.ufpb.br", TipoDeUsuario.Aluno);	
			
			
		}catch(UsuarioInexistenteException u){
			fail("Ooops, não deveria mostrar esta mensagem: " +  u.getMessage());
			
		}
		
		try{
			Exercicio e = new Exercicio("Exercício de POO");
			fachada.cadastrarExercicio(e);
			assertEquals("Exercício de POO",fachada.pesquisarExercicio("Exercício de POO"));
			//fachada.removerExercicio("Exercício de POO");
			QuestaoDissertativa qd = new QuestaoDissertativa (TipoDeQuestoes.Dissertativa, 1, "O que é maçã?", "Uma fruta!");
			e.cadastrarQuestaoDissertativaNoExercicio(qd);
			List <Questao> questoes = new ArrayList <Questao>();
			questoes.add(qd);
			String a = "1";
			String b = "0";
			String c = "5";
			String d = "2";
			List <String> alternativas = new ArrayList <String> ();
			alternativas.add(a);
			alternativas.add(b);
			alternativas.add(c);
			alternativas.add(d);
			QuestaoObjetiva qo = new QuestaoObjetiva (TipoDeQuestoes.Objetiva, 2, "Quanto é 1 + 1?", "d", alternativas);
			e.cadastrarQuestaoObjetivaNoExercicio(qo);
			questoes.add(qo);
			List <Resposta> respostasDoAluno = new ArrayList <Resposta>();
			Resposta r1 =  new Resposta ("Uma flor!", 1, "Exercício de POO");
			respostasDoAluno.add(r1);
			Resposta r2 =  new Resposta ("d", 2, "Exercício de POO");
			respostasDoAluno.add(r2);
			QuestaoVouF qvf = new QuestaoVouF(TipoDeQuestoes.VouF, 3, "A uva é verde.", "V");
			e.cadastrarQuestaoVouFNoExercicio(qvf);
			questoes.add(qvf);
			Resposta r3 =  new Resposta ("F", 2, "Exercício de POO");
			respostasDoAluno.add(r3);
			fachada.corrigirExercicio(e, TipoDeQuestoes.Dissertativa, respostasDoAluno);
			fachada.enviarFeedbackParaAluno(e, TipoDeQuestoes.Dissertativa, respostasDoAluno);
			fachada.corrigirExercicio(e, TipoDeQuestoes.Objetiva, respostasDoAluno);
			fachada.enviarFeedbackParaAluno(e, TipoDeQuestoes.Objetiva, respostasDoAluno);
			fachada.corrigirExercicio(e, TipoDeQuestoes.VouF, respostasDoAluno);
			fachada.enviarFeedbackParaAluno(e, TipoDeQuestoes.VouF, respostasDoAluno);
			fachada.enviarFeedbackParaProfessor(e, questoes, respostasDoAluno);
			
			
			
			
		}catch(ExercicioInexistenteException e){
			fail("Ooops, não deveria mostrar esta mensagem: " + e.getMessage());
		}
		/*try{
			
			Exercicio e = new Exercicio("Exercício de POO");
			fachada.cadastrarExercicio(e);
			String a = "1";
			String b = "0";
			String c = "5";
			String d = "2";
			List <String> alternativas = new ArrayList <String> ();
			alternativas.add(a);
			alternativas.add(b);
			alternativas.add(c);
			alternativas.add(d);
			QuestaoObjetiva qo = new QuestaoObjetiva (TipoDeQuestoes.Objetiva, 2, "Quanto é 1 + 1?", "d", alternativas);
			e.cadastrarQuestaoObjetivaNoExercicio(qo);
			List <Resposta> respostasDoAluno = new ArrayList <Resposta>();
			Resposta r2 =  new Resposta ("d", 2, "Exercício de POO");
			respostasDoAluno.add(r2);
			fachada.corrigirExercicio(e, TipoDeQuestoes.Objetiva, respostasDoAluno);
			fachada.enviarFeedbackParaAluno(e, TipoDeQuestoes.Objetiva, respostasDoAluno);
			//System.out.println(fachada.enviarFeedbackParaProfessor(e, TipoDeQuestoes.Objetiva, respostasDoAluno));
			
		}catch(ExercicioInexistenteException e){
			fail("Ooops, não deveria mostrar esta mensagem: " + e.getMessage());
			
		}try{	
			Exercicio e = new Exercicio("Exercício de POO");
			fachada.cadastrarExercicio(e);
			List <Resposta> respostasDoAluno = new ArrayList <Resposta>();
			Resposta r3 =  new Resposta ("F", 2, "Exercício de POO");
			respostasDoAluno.add(r3);
			QuestaoVouF qvf = new QuestaoVouF(TipoDeQuestoes.VouF, 3, "A uva é verde.", "V");
			e.cadastrarQuestaoVouFNoExercicio(qvf);
			fachada.corrigirExercicio(e, TipoDeQuestoes.VouF, respostasDoAluno);
			fachada.enviarFeedbackParaAluno(e, TipoDeQuestoes.VouF, respostasDoAluno);
			//System.out.println(fachada.enviarFeedbackParaProfessor(e, TipoDeQuestoes.VouF, respostasDoAluno));
				

		}catch(ExercicioInexistenteException e){
			fail("Ooops, não deveria mostrar esta mensagem: " + e.getMessage());
			
		}*/
		List <Exercicio> exercicios = new ArrayList();
		Exercicio e = new Exercicio("Algebra 1");
		fachada.cadastrarExercicio(e);
		
		Exercicio e2 = new Exercicio("Algebra 3");
		fachada.cadastrarExercicio(e2);
		Exercicio e3 = new Exercicio("Algebra 4");
		fachada.cadastrarExercicio(e3);
		Exercicio e4 = new Exercicio("Algebra 5");
		fachada.cadastrarExercicio(e4);
		exercicios.add(e);
		//exercicios.add(e1);
		exercicios.add(e2);
		exercicios.add(e3);
		exercicios.add(e4);
		
		fachada.sortearExercicio(exercicios);// perguntar a Ayla sobre qual foi o exercicio sorteado.
		
	
	try{
		
		fachada.gravarProfessoresEmArquivo("professores.txt");
		fachada.lerProfessoresEmArquivo("professores.txt");
		
		fachada.gravarAlunosEmArquivo("alunos.txt");
		fachada.lerAlunosEmArquivo("alunos.txt");
		
		fachada.gravarQuestoesDissertativasEmArquivo("questoesdissertativas.txt");
		fachada.lerQuestoesDissertativasDoArquivo("questoesdissertativas.txt");
		
		fachada.gravarQuestoesObjetivasEmArquivo("questoesobjetivas.txt");
		fachada.lerQuestoesObjetivasDoArquivo("questoesobjetivas.txt");
		
		fachada.gravarQuestoesVouFDoArquivo("questoesvouf.txt");
		fachada.lerQuestoesVouFDoArquivo("questoesvouf.txt");
		
		fachada.gravarExerciciosEmArquivo("exercicios.txt");
		fachada.lerExerciciosEmArquivo("exercicios.txt");
		
	}catch(IOException i){
		fail("Ops, não deveria lançar esta exceção!" +i.getMessage()); 
	}
	
	try{
		Exercicio e1 = new Exercicio("Algebra 2");
		fachada.cadastrarExercicio(e1);
		assertEquals("Algebra 2",fachada.pesquisarExercicio("Algebra 2"));
	}catch(ExercicioInexistenteException ei){
		fail("Ops, não deveria lançar esta exceção!" +ei.getMessage());
	}
	
	}
}