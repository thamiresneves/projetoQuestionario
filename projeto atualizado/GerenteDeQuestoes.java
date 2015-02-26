package br.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeQuestoes {
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
	
	public void cadastrarQuestaoDissertativa(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta){
		QuestaoDissertativa questao = new QuestaoDissertativa(tq, numDeQuestao,pergunta,resposta);
		this.questoesDissertativas.add(questao);	
	    
	}
	
	public void cadastrarQuestaoObjetiva(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta, List<String> alternativas){
		QuestaoObjetiva questao = new QuestaoObjetiva(tq, numDeQuestao, pergunta, resposta, alternativas);
		this.questoesObjetivas.add(questao);
	    
	}
	
	public void cadastrarQuestaoVouF(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta){
		QuestaoVouF questao = new QuestaoVouF(tq, numDeQuestao,pergunta,resposta);
		this.questoesVouF.add(questao);	
	    
	}
	
	public String pesquisarQuestaoDissertativa(long numDeQuestao)throws QuestaoInexistenteException{
			for(QuestaoDissertativa q: this.questoesDissertativas){
				if(q.getNumDeQuestao() == numDeQuestao){
					return q.getPergunta();	
				}
			
			}throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
			
		}
	public String pesquisarQuestaoObjetiva(long numDeQuestao)throws QuestaoInexistenteException{
		for(QuestaoObjetiva q: this.questoesObjetivas){
			if(q.getNumDeQuestao() == numDeQuestao){
				return q.getPergunta();
			}
		}throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
		
	}
	public String pesquisarQuestaoVouF(long numDeQuestao)throws QuestaoInexistenteException{
		for(QuestaoVouF q: this.questoesVouF){
			if(q.getNumDeQuestao() == numDeQuestao){
				return q.getPergunta();
			}
		}throw new QuestaoInexistenteException ("Questão de número: " + numDeQuestao + " não foi encontrada!");
		
	}
	public void removerQuestaoDissertativa(long numDeQuestao) throws QuestaoInexistenteException{
		boolean removeu = false;
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
	
	public void removerQuestaoObjetiva(long numDeQuestao) throws QuestaoInexistenteException{
		boolean removeu = false;
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
	
	public void removerQuestaoVouF(long numDeQuestao) throws QuestaoInexistenteException{
		boolean removeu = false;
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
