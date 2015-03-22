package br.ufpb.projetopoo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Fachada implements Serializable {
		private GerenteDeExercicios gerenteDeExercicios = new GerenteDeExercicios();
		private GerenteDeUsuario gerenteDeUsuario = new GerenteDeUsuario();
		private GerenteDeQuestoes gerenteDeQuestoes = new GerenteDeQuestoes();
		private GerenteDePersistencia gravador = new GerenteDePersistencia();
		private Usuario usuario;
		private String nomeDoExercicioSendoEditado  = "";
		private Aluno aluno;
		private Resposta resposta;
	
		
		
		public boolean login(String email, TipoDeUsuario tu){
			return this.gerenteDeUsuario.validarUsuario(email, tu);
		}
		
		public void logar(String nome, TipoDeUsuario tu, String email){
			this.usuario = new Usuario (nome, tu, email);
		}
		
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
		
		public Usuario pesquisarUsuarioPeloEmail(String email, TipoDeUsuario tu) throws UsuarioInexistenteException{
			return this.gerenteDeUsuario.pesquisarUsuarioPeloEmail(email, tu);
		}
		
		public void cadastrarQuestaoDissertativa(Exercicio e,QuestaoDissertativa qd)throws QuestaoJaExisteException{
			this.gerenteDeQuestoes.cadastrarQuestaoDissertativa(e, qd);
		}
		
		public void cadastrarQuestaoObjetiva(Exercicio e, QuestaoObjetiva qO)throws QuestaoJaExisteException{
			this.gerenteDeQuestoes.cadastrarQuestaoObjetiva(e,qO);
		}
		
		public void cadastrarQuestaoVouF(Exercicio e, QuestaoVouF qvf)throws QuestaoJaExisteException{
			this.gerenteDeQuestoes.cadastrarQuestaoVouF(e, qvf);
		}
	
		public Questao pesquisarQuestaoDissertativa(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao)throws QuestaoInexistenteException{
			return this.gerenteDeQuestoes.pesquisarQuestaoDissertativa(gE, nomeDeExercicio, numDeQuestao);
		}
		
		public Questao pesquisarQuestaoObjetiva(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao)throws QuestaoInexistenteException{
			return this.gerenteDeQuestoes.pesquisarQuestaoObjetiva(gE, nomeDeExercicio, numDeQuestao);
		}
		
		public Questao pesquisarQuestaoVouF(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao)throws QuestaoInexistenteException{
			return this.gerenteDeQuestoes.pesquisarQuestaoVouF(gE, nomeDeExercicio, numDeQuestao);
		}
		
		public void removerQuestaoDissertativa(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao) throws QuestaoInexistenteException{
			this.gerenteDeQuestoes.removerQuestaoDissertativa(gE, nomeDeExercicio, numDeQuestao);
		}
		
		public void removerQuestaoObjetiva(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao) throws QuestaoInexistenteException{
			this.gerenteDeQuestoes.removerQuestaoObjetiva(gE, nomeDeExercicio, numDeQuestao);
		}
		
		public void removerQuestaoVouF(GerenteDeExercicios gE, String nomeDeExercicio, long numDeQuestao) throws QuestaoInexistenteException{
			this.gerenteDeQuestoes.removerQuestaoVouF(gE, nomeDeExercicio, numDeQuestao);
		}
		
		public void cadastrarExercicio(Exercicio e) throws ExercicioJaExisteException{
			this.gerenteDeExercicios.cadastrarExercicio(e);
		}
		
		public Exercicio pesquisarExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
			return this.gerenteDeExercicios.pesquisarExercicio(nomeDeExercicio);
		}
		
		public void removerExercicio(String nomeDeExercicio) throws ExercicioInexistenteException{
			this.gerenteDeExercicios.removerExercicio(nomeDeExercicio);
		}
		
		public Exercicio obterExercicioPeloNome(String nomeDeExercicio){
			return this.gerenteDeExercicios.obterExercicioPeloNome(nomeDeExercicio);
		}
		public String obterNomePeloExercicio(Exercicio e){
			return this.gerenteDeExercicios.obterNomePeloExercicio(e);
		}
		
		public Exercicio sortearExercicio(List <Exercicio> exercicios){
			return this.gerenteDeExercicios.sortearExercicio(exercicios);
		}
		
		public List <String> obterQuestoesDoExercicio(String nomeDeExercicio, GerenteDeQuestoes gQ) throws ExercicioInexistenteException {
			return this.gerenteDeExercicios.obterQuestoesDoExercicio(nomeDeExercicio, gQ);
		}
		
		public String corrigirExercicio(Exercicio e, GerenteDeQuestoes gQuestoes, List<Resposta> respostas) throws ExercicioInexistenteException, QuestaoInexistenteException{
			return this.gerenteDeExercicios.corrigirExercicio(e, gQuestoes, respostas);
		}
		
		public List<String> enviarFeedbackParaAluno(Exercicio e,Aluno a, GerenteDeQuestoes gQ)throws ExercicioInexistenteException, QuestaoInexistenteException{
			return this.gerenteDeExercicios.enviarFeedbackParaAluno(e,a, gQ);
		}
		
		public List <Aluno> getAluno() {
			return this.gerenteDeUsuario.getAluno();
		}
		
		public void salvarRespostaDoAluno(String pergunta, String respostaDoAluno, long numDeQuestao, String nomeDeExercicio){
			((Aluno) this.usuario).adicionarResposta(respostaDoAluno, pergunta, numDeQuestao, nomeDeExercicio);
		}
		
		public List <Professor> getProfessor(){
			return this.gerenteDeUsuario.getProfessor();
		}
		
		public String enviarFeedbackParaProfessor(Exercicio e, List <Aluno> alunos)throws ExercicioInexistenteException{
			return this.gerenteDeExercicios.enviarFeedbackParaProfessor(e, alunos);
		}
		
		public GerenteDeQuestoes getGerenteDeQuestoes(){
			return this.gerenteDeQuestoes;
			
		}
		
		public GerenteDeExercicios getGerenteDeExercicios(){
			return this.gerenteDeExercicios;
		}
		
		public List <Exercicio> getExercicios() {
			return this.gerenteDeExercicios.getExercicios();
		}
		
		public void gravarNaPersistencia() {
				this.gravador.gravarNaPersistencia(this);
		}
		
		public Fachada recuperaFachada(){
			return this.gravador.recuperaFachada();

		}

		public String pegarNomeDeUsuario(String email, TipoDeUsuario aluno) {
			return this.gerenteDeUsuario.pegarNomeDeUsuario(email, aluno);
		}

		public String getNomeDoExercicioSendoEditado() {
			return nomeDoExercicioSendoEditado;
		}

		public void setNomeDoExercicioSendoEditado(String nomeDoExercicioSendoEditado) {
			this.nomeDoExercicioSendoEditado = nomeDoExercicioSendoEditado;
		}
		
		public void adicionarResposta(String respostaDoAluno,String pergunta, long numDeQuestao, String nomeDeExercicio){
			this.aluno.adicionarResposta(respostaDoAluno, pergunta, numDeQuestao, nomeDeExercicio);
		}
		
		public void cadastrarExerciciosResolvidosDoAluno(Exercicio e){
			this.aluno.cadastrarExerciciosResolvidosDoAluno(e);
		}
		
		public Resposta pesquisaRespostaDoAluno(Exercicio e, long numDeQuestao) throws QuestaoInexistenteException{
			return this.aluno.pesquisaRespostaDoAluno(e, numDeQuestao);
		}
		
		public List <Resposta> getRespostas(){
			return this.aluno.getRespostas();
		}
		
		public Aluno obterAlunoPeloNome(String nome){
			return this.gerenteDeUsuario.obterAlunoPeloNome(nome);
		}
		
		public boolean validarUsuario(String email, TipoDeUsuario tu){
			return this.gerenteDeUsuario.validarUsuario(email, tu);
		}
		public String getRespostaDoAluno() {
			return this.resposta.getRespostaDoAluno();
		}
}
