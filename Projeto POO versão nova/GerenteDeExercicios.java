package br.ufpb.projetopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenteDeExercicios {
	
	private List <Exercicio> exercicios = new ArrayList <Exercicio>();
	

	public List <Exercicio> getExercicios() {
		return exercicios;
	}
	
	public void cadastrarExercicio(Exercicio e){
		exercicios.add(e);
			
	}
	
	public String pesquisarExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
		for(Exercicio e: this.exercicios){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				return e.getNomeDeExercicio();
			}
		}throw new ExercicioInexistenteException("Exercício: "+ nomeDeExercicio+ " não encontrado.");
		
	}
	
	public void removerExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
		boolean removeu = false;
		for(Exercicio e: this.exercicios){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				exercicios.remove(e);
				removeu = true;
				break;
			}
		}if(!removeu){
			throw new ExercicioInexistenteException("Exercicio: "+ nomeDeExercicio+" não foi encontrado.");
		}
	}
	
	public Exercicio sortearExercicio(List <Exercicio> exercicios){
		Collections.shuffle(exercicios);
		return exercicios.get(0);
	}
	
	public String corrigirExercicio(Exercicio e, TipoDeQuestoes tq, List<Resposta> respostaDoAluno) throws ExercicioInexistenteException{
		for(Questao q: e.getQuestoes()){
			if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
				for(Resposta r: respostaDoAluno){
					return "A pergunta cadastrada foi: "+ q.getPergunta()+ "Sua resposta para essa pergunta foi: " + r.getRespostaDoAluno()+ "E a resposta que o professor deu para a mesma foi:  "+ q.getResposta();
						
				}
					
			}else if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
				for(Resposta r: respostaDoAluno){
					if(r.getRespostaDoAluno().equals(q.getResposta())){
						return "Sua resposta está correta!";
					}else{
						return "Sua resposta está incorreta!";
					}
				}
			}else{
				for(Resposta r: respostaDoAluno){
					if(r.getRespostaDoAluno().equals(q.getResposta())){
						return "Sua resposta está correta!";
					}else{
						return "Sua resposta está incorreta!";
					}
				}
			}
		}throw new ExercicioInexistenteException ("Exercício Inexistente!");
	
			
	}
	
	public String enviarFeedbackParaAluno(Exercicio e, TipoDeQuestoes tq, List<Resposta> respostaDoAluno)throws ExercicioInexistenteException{
		for(Questao q: e.getQuestoes()){
			if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
				for(Resposta r: respostaDoAluno){
					return "A pergunta cadastrada foi: "+ q.getPergunta()+ " Sua resposta para essa pergunta foi: " + r.getRespostaDoAluno()+ " E a resposta que o professor deu para a mesma foi:  "+ q.getResposta();
						
				}
					
			} else if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
				for(Resposta r: respostaDoAluno){
					if(r.getRespostaDoAluno().equals(q.getResposta())){
						return "A pergunta cadastrada foi: " + q.getPergunta() + " Você respondeu: " + r.getRespostaDoAluno() + " Sua resposta está correta!";
					}else{
						return "A pergunta cadastrada foi: " + q.getPergunta() + " Você respondeu: " + r.getRespostaDoAluno() + " A resposta correta é: "+ q.getResposta()+ " Sua resposta está incorreta!";
					}
				}
			}else{
				for(Resposta r: respostaDoAluno){
					if(r.getRespostaDoAluno().equals(q.getResposta())){
						return "A pergunta cadastrada foi: " + q.getPergunta() + " Você respondeu: " + r.getRespostaDoAluno() +" Sua resposta está correta!";
					}else{
						return "A pergunta cadastrada foi: " + q.getPergunta() + " Você respondeu: " + r.getRespostaDoAluno() + " A resposta correta é: "+ q.getResposta()+ " Sua resposta está incorreta!";
					}
				}
			}
		}throw new ExercicioInexistenteException ("Exercício Inexistente!");
		
		
	}
	
	public String enviarFeedbackParaProfessor(Exercicio e, List <Questao> questoes, List<Resposta> respostaDoAluno)throws ExercicioInexistenteException{
		int quantRespostasQDissertativa = 0;
		int quantAcertosQObjetiva = 0;
		int quantAcertosQVouF = 0;
		int quantErrosQObjetiva = 0;
		int quantErrosQVouF = 0;
		// Como saber que aluno acertou que questão!
		for(Questao q: e.getQuestoes()){
			if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
				for(Resposta r: respostaDoAluno){
					quantRespostasQDissertativa ++;
					return "A quantidade de alunos que responderam a pergunta: " + q.getPergunta() +"\n"+ " Foi: " + quantRespostasQDissertativa +"\n"+ " A resposta correta é: " + q.getResposta() + "\n"+" A resposta do aluno foi: " + r.getRespostaDoAluno();
					
				}
			}else if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
				for(Resposta r: respostaDoAluno){
					if(r.getRespostaDoAluno().equals(q.getResposta())){
						quantAcertosQObjetiva ++;
					}else{
						quantErrosQObjetiva ++;
					}
					return "A quantidade de alunos que acertaram a pergunta: " + q.getPergunta() + "\n"+" Foi: " + quantAcertosQObjetiva +"\n"+ "A quantidade de alunos que erraram essa questão foi:  "+ quantErrosQObjetiva + "\n"+ " A resposta correta é: " + q.getResposta() +"\n"+ " A resposta do aluno foi: " + r.getRespostaDoAluno();
						
					
				}
			}else{
				for(Resposta r: respostaDoAluno){
					if(r.getRespostaDoAluno().equals(q.getResposta())){
						quantAcertosQVouF ++;
					}
					else{
						quantErrosQVouF ++;
					}
					return "A quantidade de alunos que acertaram a pergunta: " + q.getPergunta() +"\n"+ " Foi: " + quantAcertosQVouF +"\n"+ "A quantidade de alunos que erraram essa questão foi:  "+ quantErrosQVouF + "\n"+ " A resposta correta é: " + q.getResposta() + "\n"+  " A resposta do aluno foi: " + r.getRespostaDoAluno();
					
					}
				
				}
			
		}throw new ExercicioInexistenteException ("Excercício Inexistente!");
	}
	
	public void gravarExerciciosEmArquivo(String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Exercicio exercicio: this.exercicios){
				gravador.write(exercicio.getNomeDeExercicio()+"\n");
				
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	
	public void lerExerciciosEmArquivo(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			leitor.readLine();
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}		
	}

	
	
	
	
		
		
		
}