package br.ufpb.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GerenteDeQuestoes implements Serializable {
	private List <QuestaoVouF> questoesVouF = new ArrayList<QuestaoVouF> ();
	private List <QuestaoObjetiva> questoesObjetivas = new ArrayList<QuestaoObjetiva> ();
	private List <QuestaoDissertativa> questoesDissertativas = new ArrayList<QuestaoDissertativa> ();
	
	public List <QuestaoVouF> getQuestoesVouF() {
		return questoesVouF;
	}

	public List <QuestaoObjetiva> getQuestoesObjetivas() {
		return questoesObjetivas;
	}

	public List <QuestaoDissertativa> getQuestoesDissertativas() {
		return questoesDissertativas;
	}
	
	public void cadastrarQuestaoDissertativa(Exercicio e, QuestaoDissertativa qd) throws QuestaoJaExisteException{
		for(Questao q: e.getQuestoes()){
			if(q.getNumDeQuestao() == qd.getNumDeQuestao()){
				throw new QuestaoJaExisteException("Questão já existe!");	
			}
			
		}this.questoesDissertativas.add(qd);
		
		
	}
	
	public void cadastrarQuestaoObjetiva(Exercicio e, QuestaoObjetiva qO) throws QuestaoJaExisteException{
		for(Questao q: e.getQuestoes()){
			if(q.getNumDeQuestao() == qO.getNumDeQuestao()){
				throw new QuestaoJaExisteException("Questão já existe!");	
			}
		}this.questoesObjetivas.add(qO);
		
		
	}
	
	public void cadastrarQuestaoVouF(Exercicio e, QuestaoVouF qvf) throws QuestaoJaExisteException{
		for(Questao q: e.getQuestoes()){
			if(q.getNumDeQuestao() == qvf.getNumDeQuestao()){
				throw new QuestaoJaExisteException("Questão já existe!");	
			}
		}this.questoesVouF.add(qvf);
		
		
	}
	
	public Questao pesquisarQuestaoDissertativa(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao)throws QuestaoInexistenteException{
		for(Exercicio e: gE.getExercicios()){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				System.out.println("Nomes de exercicios iguais");
				for(QuestaoDissertativa q: this.questoesDissertativas){
					if(q.getNumDeQuestao() == numDeQuestao){
						return q;	
					}
				}	
			}	
			
		}throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
			
			
}
	public Questao pesquisarQuestaoObjetiva(GerenteDeExercicios gE,String nomeDeExercicio, long numDeQuestao)throws QuestaoInexistenteException{
		for(Exercicio e: gE.getExercicios()){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				for(QuestaoObjetiva q: this.questoesObjetivas){
					if(q.getNumDeQuestao() == numDeQuestao){
						return q;	
					}
				}	
			}	
			
		}throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
			
		
	}
	
	public Questao pesquisarQuestaoVouF(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao)throws QuestaoInexistenteException{
		for(Exercicio e: gE.getExercicios()){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				for(QuestaoVouF q: this.questoesVouF){
					if(q.getNumDeQuestao() == numDeQuestao){
						return q;	
					}
				}	
			}	
			
		}throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
			
		
	}
	
	public void removerQuestaoDissertativa(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao) throws QuestaoInexistenteException{
		boolean removeu = false;
		for(Exercicio e: gE.getExercicios()){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				for(QuestaoDissertativa q : this.questoesDissertativas){
					if(q.getNumDeQuestao()== numDeQuestao){
						questoesDissertativas.remove(q);
						removeu = true;
						break;
					}
				
		}if(!removeu){
			throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
		}
			}
		}
			
}
	
	public void removerQuestaoObjetiva(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao) throws QuestaoInexistenteException{
		boolean removeu = false;
		for(Exercicio e: gE.getExercicios()){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				for(QuestaoObjetiva q : this.questoesObjetivas){
					if(q.getNumDeQuestao()== numDeQuestao){
						questoesObjetivas.remove(q);
						removeu = true;
						break;
					}
				
		}if(!removeu){
			throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
		}
			}
		}
	}
	
	public void removerQuestaoVouF(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao) throws QuestaoInexistenteException{
		boolean removeu = false;
		for(Exercicio e: gE.getExercicios()){
			if(e.getNomeDeExercicio().equals(nomeDeExercicio)){
				for(QuestaoVouF q : this.questoesVouF){
					if(q.getNumDeQuestao()== numDeQuestao){
						questoesVouF.remove(q);
						removeu = true;
						break;
					}
				
		}if(!removeu){
			throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
		}
			}
		}
	}
	
	public String corrigirQuestaoDissertativa(Resposta respostaDoAluno) throws QuestaoInexistenteException{
		for(QuestaoDissertativa qd: this.questoesDissertativas){
			if(qd.getNumDeQuestao() == respostaDoAluno.getNumDeQuestao()){
				return "A resposta cadastrada foi: " +qd.getResposta() +"\n" +"Sua resposta para esta pergunta foi: " + respostaDoAluno.getRespostaDoAluno();
				
			}
		}throw new QuestaoInexistenteException ("Questão de número: " + respostaDoAluno.getNumDeQuestao() + " não foi encontrada!");
		
		
	}
	
	public String corrigirQuestaoObjetiva(Resposta respostaDoAluno) throws QuestaoInexistenteException{
		String resposta;
		for(QuestaoObjetiva qO: this.questoesObjetivas){
			if(qO.getNumDeQuestao() == respostaDoAluno.getNumDeQuestao()){
				resposta = qO.getResposta();
				if(qO.getResposta().equals(respostaDoAluno.getRespostaDoAluno())){
					return "Sua resposta está correta!";
				}else{
					return "Sua resposta está incorreta! " + " A resposta correta é: " + resposta;
				}
			}
			
		}throw new QuestaoInexistenteException("Questão de número: " + respostaDoAluno.getNumDeQuestao() + " não foi encontrada!");
			
		
		
	}
	
	public String corrigirQuestaoVouF(Resposta respostaDoAluno) throws QuestaoInexistenteException{
		String resposta;
		for(QuestaoVouF qvouf: this.questoesVouF){
			if(qvouf.getNumDeQuestao() == respostaDoAluno.getNumDeQuestao()){
				resposta = qvouf.getResposta();
				if(qvouf.getResposta().equals(respostaDoAluno.getRespostaDoAluno())){
					return "Sua resposta está correta!";
				}else{
					return "Sua resposta está incorreta! " + " A resposta correta é: " + resposta;
				}
			}
		}throw new QuestaoInexistenteException("Questão de número: " + respostaDoAluno.getNumDeQuestao() + " não foi encontrada!");
		
	}


	
}