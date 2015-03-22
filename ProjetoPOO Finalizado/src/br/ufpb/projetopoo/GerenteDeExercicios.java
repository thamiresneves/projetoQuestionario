package br.ufpb.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenteDeExercicios implements Serializable {
	
	private List <Exercicio> exercicios = new ArrayList <Exercicio>();
	

	public List <Exercicio> getExercicios() {
		return exercicios;
	}
	
	public void cadastrarExercicio(Exercicio e) throws ExercicioJaExisteException{
		for(Exercicio e1: this.exercicios){
			if(e1.getNomeDeExercicio().equals(e.getNomeDeExercicio())){
				throw new ExercicioJaExisteException("O exercício: "+e.getNomeDeExercicio()+" já foi cadastrado!");
			}
		}exercicios.add(e);// mudar o método para cadastrar o objeto e
	}
	
	
	
	public Exercicio pesquisarExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
		for(Exercicio e: this.exercicios){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				return e;
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
	
	
	public Exercicio obterExercicioPeloNome(String nomeDeExercicio){
		for(Exercicio e: this.exercicios){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				return e;
			}
		}return null;
	}
	
	public String obterNomePeloExercicio(Exercicio e){
		for(Exercicio e1: this.exercicios){
			if(e1.getNomeDeExercicio().equals(e.getNomeDeExercicio())){
				return e.getNomeDeExercicio();
			}
		}return null;
	}
	
	
	public Exercicio sortearExercicio(List <Exercicio> exercicios){
		Collections.shuffle(exercicios);
		return exercicios.get(0);
	}
	
	public List <String> obterQuestoesDoExercicio(String nomeDeExercicio, GerenteDeQuestoes gQ) throws ExercicioInexistenteException {
		List <String> auxiliar = new ArrayList <String>();
		for(Exercicio e: this.exercicios){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				for(Questao q: e.getQuestoes()){
					if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
						for(QuestaoObjetiva qO: gQ.getQuestoesObjetivas()){
						auxiliar.add("Perguntas do exercício: "+nomeDeExercicio+ "\n" +q.getPergunta() + "\n" +qO.getAlternativas());
						}
					}else{
						auxiliar.add("Perguntas do exercício: "+nomeDeExercicio+ "\n" +q.getPergunta() + "\n");
					}
				}
			}return auxiliar;
		}throw new ExercicioInexistenteException("Exercício Inexistente");
					
		
	}
	
	public String corrigirExercicio(Exercicio e, GerenteDeQuestoes gQuestoes, List<Resposta> respostas) throws ExercicioInexistenteException, QuestaoInexistenteException{
		for(Exercicio e1: this.exercicios){
			if(e1.equals(e)){
				for(Questao q: e1.getQuestoes()){
					for(Resposta r: respostas){
						if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
							return gQuestoes.corrigirQuestaoDissertativa(r);
						}else if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
							return gQuestoes.corrigirQuestaoObjetiva(r);
						}else{
							return gQuestoes.corrigirQuestaoVouF(r);
						}
					}
				}
			}
		}throw new ExercicioInexistenteException("Exercício " +e.getNomeDeExercicio() +" Inexistente!");		
	}
	
	
	
	public List<String> enviarFeedbackParaAluno(Exercicio e, Aluno a, GerenteDeQuestoes gQ)throws ExercicioInexistenteException, QuestaoInexistenteException{
		List<String> aux  = new ArrayList<String>();
		for(Exercicio e1: a.exerciciosResolvidosDoAluno){
			if(e1.equals(e)){
				for(Questao q: e1.getQuestoes()){
					if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
						aux.add("A pergunta era: " + q.getPergunta() + "\n Você respondeu: \n" +a.pesquisaRespostaDoAluno(e1, q.getNumDeQuestao()).getRespostaDoAluno() + "\nA resposta para esta pergunta é: "+ q.getResposta()+ "\n");
							
						}else if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
							for(QuestaoObjetiva qO: gQ.getQuestoesObjetivas()){
								if(q.getResposta().equals(a.pesquisaRespostaDoAluno(e1,q.getNumDeQuestao()))){
									aux.add("A pergunta era: " + q.getPergunta()  + "\n" + qO.getAlternativas() + "\n Você respondeu: \n" +a.pesquisaRespostaDoAluno(e1, q.getNumDeQuestao()).getRespostaDoAluno() +"\n A resposta para esta pergunta é: "+ q.getResposta());
								}else{
									aux.add("A pergunta era: " + q.getPergunta() + "\n" + qO.getAlternativas()  + "\n Você respondeu: \n" +a.pesquisaRespostaDoAluno(e1, q.getNumDeQuestao()).getRespostaDoAluno() +"\n A resposta para esta pergunta é: "+ q.getResposta());
								}
							}
						}else{
							if(q.getResposta().equals(a.pesquisaRespostaDoAluno(e,q.getNumDeQuestao()))){
								aux.add("A pergunta era: " + q.getPergunta() +"\n Você respondeu: \n" +a.pesquisaRespostaDoAluno(e1, q.getNumDeQuestao()).getRespostaDoAluno() +"\n A resposta para esta pergunta é: "+ q.getResposta());		
							}else{
								aux.add("A pergunta era: " + q.getPergunta() + "\n Você respondeu: \n" +a.pesquisaRespostaDoAluno(e1, q.getNumDeQuestao()).getRespostaDoAluno()+"\n A resposta para esta pergunta é: "+ q.getResposta());
								
							}
						}
					}
				}return aux;
			
		}throw new ExercicioInexistenteException("Exercício " +e.getNomeDeExercicio() +" Inexistente!");
		
	}
	
	public int quantidadeDeAlunosQueResponderamOExercicio(Exercicio e, List<Aluno> alunos){
		int quantAlunosRespondeuExercicio = 0;
		for(Exercicio e1: this.exercicios){
			if(e1.equals(e)){
				for(Aluno a: alunos){
					if(a.AlunoRespondeuExercicio(e)){
						quantAlunosRespondeuExercicio ++;
					}
				}
			}
			
		}return quantAlunosRespondeuExercicio;
	}
	
	public int quantidadeDeAcertosDasQuestoesDissertativas(Exercicio e, List<Aluno> alunos){
		int quantAcertosQuestoesDissertativas = 0;
		for(Exercicio e1: this.exercicios){
			if(e1.equals(e)){
				for(Aluno a: alunos){
					if(a.AlunoRespondeuExercicio(e1)){
						for(Questao q: e1.getQuestoes()){
							if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
								for(Resposta r: a.getRespostas()){
									if(q.getResposta().equals(r.getRespostaDoAluno())){
										quantAcertosQuestoesDissertativas ++;
										
									}
								}
							}
						}
					}
				}
			}
		}return quantAcertosQuestoesDissertativas;
		
	}
	public int quantidadeDeAcertosDasQuestoesObjetivas(Exercicio e, List<Aluno> alunos){
		int quantAcertosQuestoesObjetivas = 0;
		for(Exercicio e1: this.exercicios){
			if(e1.equals(e)){
				for(Aluno a: alunos){
					if(a.AlunoRespondeuExercicio(e1)){
						for(Questao q: e1.getQuestoes()){
							if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
								for(Resposta r: a.getRespostas()){
									if(q.getResposta().equals(r.getRespostaDoAluno())){
										quantAcertosQuestoesObjetivas ++;
									}	
								}
							}
						}
					}
				}
			}
		}return quantAcertosQuestoesObjetivas;
	}
	
	public int quantidadeDeAcertosDasQuestoesVouF(Exercicio e, List<Aluno> alunos){
		int quantAcertosQuestoesVouF = 0;
		for(Exercicio e1: this.exercicios){
			if(e1.equals(e)){
				for(Aluno a: alunos){
					if(a.AlunoRespondeuExercicio(e1)){
						for(Questao q: e1.getQuestoes()){
							if(q.getTq().equals(TipoDeQuestoes.VouF)){
								for(Resposta r: a.getRespostas()){
									if(q.getResposta().equals(r.getRespostaDoAluno())){
										quantAcertosQuestoesVouF ++;
									}	
								}
							}
						}
					}
				}
			}
		}return quantAcertosQuestoesVouF;
		

		
	}
	
	public String enviarFeedbackParaProfessor(Exercicio e, List <Aluno> alunos)throws ExercicioInexistenteException{
		return "A quantidade de alunos que responderam este exercício foi: " +quantidadeDeAlunosQueResponderamOExercicio(e, alunos)+"\n A quantidade de acertos das questões dissertativas foi: "+quantidadeDeAcertosDasQuestoesDissertativas(e, alunos)+"\n A quantidade de acertos das questões objetivas foi: "+quantidadeDeAcertosDasQuestoesObjetivas(e, alunos)+"\n A quantidade de acertos das questões VouF foi: "+quantidadeDeAcertosDasQuestoesVouF(e, alunos);
		
	}
	
	

	
	
	
	
		
		
		
}