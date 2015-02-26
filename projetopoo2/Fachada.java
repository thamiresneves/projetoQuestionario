package br.ufpb.projetopoo;

import java.util.List;

public class Fachada {
	
	private GerenteDeExercicios gerenteDeExercicios = new GerenteDeExercicios();
	private GerenteDeUsuario gerenteDeUsuario = new GerenteDeUsuario();
	private GerenteDeQuestoes gerenteDeQuestoes = new GerenteDeQuestoes();
	
	
	public void cadastrarUsuario(String nome, TipoDeUsuario tu, String email) throws UsuarioJaExisteException{
		this.gerenteDeUsuario.cadastrarUsuario(nome, tu, email);
	}
	public void cadastrarUsuarioProfessor(String nome, TipoDeUsuario tu, String email) throws UsuarioJaExisteException{
		this.gerenteDeUsuario.cadastrarUsuarioProfessor(nome, tu, email);
	}
	public void cadastrarUsuarioAluno(String nome, TipoDeUsuario tu, String email) throws UsuarioJaExisteException{
		this.gerenteDeUsuario.cadastrarUsuarioAluno(nome, tu, email);
	}
	public void removerUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
		 this.gerenteDeUsuario.removerUsuarioPeloEmail(email, tu);
	}
	
	public String pesquisarUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
		return this.gerenteDeUsuario.pesquisarUsuarioPeloEmail(email, tu);
	}
	
	public void cadastrarQuestaoDissertativa(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta){
		this.gerenteDeQuestoes.cadastrarQuestaoDissertativa(tq, numDeQuestao, pergunta, resposta);
	}
	
	public void cadastrarQuestaoObjetiva(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta, List<String> alternativas){
		this.gerenteDeQuestoes.cadastrarQuestaoObjetiva(tq, numDeQuestao, pergunta, resposta, alternativas);
	}
	
	public void cadastrarQuestaoVouF(TipoDeQuestoes tq, long numDeQuestao, String pergunta, String resposta){
		this.gerenteDeQuestoes.cadastrarQuestaoVouF(tq, numDeQuestao, pergunta, resposta);
	}
	
	public String pesquisarQuestaoDissertativa(long numDeQuestao)throws QuestaoInexistenteException{
		return this.gerenteDeQuestoes.pesquisarQuestaoDissertativa(numDeQuestao);
	}
	
	public String pesquisarQuestaoObjetiva(long numDeQuestao)throws QuestaoInexistenteException{
		return this.gerenteDeQuestoes.pesquisarQuestaoObjetiva(numDeQuestao);
	}
	
	public String pesquisarQuestaoVouF(long numDeQuestao)throws QuestaoInexistenteException{
		return this.gerenteDeQuestoes.pesquisarQuestaoVouF(numDeQuestao);
	}
	
	public void removerQuestaoDissertativa(long numDeQuestao) throws QuestaoInexistenteException{
		this.gerenteDeQuestoes.removerQuestaoDissertativa(numDeQuestao);
	}
	
	public void removerQuestaoObjetiva(long numDeQuestao) throws QuestaoInexistenteException{
		this.gerenteDeQuestoes.removerQuestaoObjetiva(numDeQuestao);
	}
	
	public void removerQuestaoVouF(long numDeQuestao) throws QuestaoInexistenteException{
		this.gerenteDeQuestoes.removerQuestaoVouF(numDeQuestao);
	}
	
	public void cadastrarExercicio(Exercicio e){
		this.gerenteDeExercicios.cadastrarExercicio(e);
	}
	
	public String pesquisarExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
		return this.gerenteDeExercicios.pesquisarExercicio(nomeDeExercicio);
	}
	
	public void removerExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
		this.gerenteDeExercicios.removerExercicio(nomeDeExercicio);
	}
	
	public String corrigirExercicio(Exercicio e, TipoDeQuestoes tq, List<Resposta> respostaDoAluno) throws ExercicioInexistenteException{
		return this.gerenteDeExercicios.corrigirExercicio(e, tq, respostaDoAluno);
	}
	
	public List <Aluno> getAluno() {
		return this.gerenteDeUsuario.getAluno();
	}
	
	public List <Professor> getProfessor(){
		return this.gerenteDeUsuario.getProfessor();
	}
	
	
}
