package br.ufpb.projetopoo;

import java.util.ArrayList;
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
		for(Exercicio e: this.exercicios){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				exercicios.remove(e);
				break;
			}
		}throw new ExercicioInexistenteException("Exercicio: "+ nomeDeExercicio+" não foi encontrado.");
	}
	
	public String corrigirExercicio(Exercicio e, TipoDeQuestoes tq, List<Resposta> respostaDoAluno) throws ExercicioInexistenteException{
		for(Questao q: e.getQuestoes()){
			if(q.getTq().equals(TipoDeQuestoes.Dissertativa)){
				for(Resposta r: respostaDoAluno){
					return "Sua resposta para essa pergunta foi: " +r.getRespostaDoAluno()+ "E a resposta que o professor deu para a mesma foi:  "+ q.getResposta();
						
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
	
	
		
		
		
}

	



