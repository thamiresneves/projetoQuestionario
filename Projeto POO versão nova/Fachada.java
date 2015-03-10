package br.ufpb.projetopoo;

import java.io.IOException;
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
		
		public Exercicio sortearExercicio(List <Exercicio> exercicios){
			return this.gerenteDeExercicios.sortearExercicio(exercicios);
		}
		
		public String corrigirExercicio(Exercicio e, TipoDeQuestoes tq, List<Resposta> respostaDoAluno) throws ExercicioInexistenteException{
			return this.gerenteDeExercicios.corrigirExercicio(e, tq, respostaDoAluno);
		}
		public String enviarFeedbackParaAluno(Exercicio e, TipoDeQuestoes tq, List<Resposta> respostaDoAluno)throws ExercicioInexistenteException{
			return this.gerenteDeExercicios.enviarFeedbackParaAluno(e, tq, respostaDoAluno);
		}
		
		public List <Aluno> getAluno() {
			return this.gerenteDeUsuario.getAluno();
		}
		
		public List <Professor> getProfessor(){
			return this.gerenteDeUsuario.getProfessor();
		}
		
		public String enviarFeedbackParaProfessor(Exercicio e, List<Questao> questoes, List<Resposta> respostaDoAluno)throws ExercicioInexistenteException{
			return this.gerenteDeExercicios.enviarFeedbackParaProfessor(e, questoes, respostaDoAluno);
		}
		
		public void gravarProfessoresEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeUsuario.gravarProfessoresEmArquivo(nomeArquivo);
		}
		
		public void lerProfessoresEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeUsuario.lerProfessoresEmArquivo(nomeArquivo);
		}
		
		public void gravarAlunosEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeUsuario.gravarAlunosEmArquivo(nomeArquivo);
		}
		
		public void lerAlunosEmArquivo(String nomeArquivo) throws IOException{
			this.gerenteDeUsuario.lerAlunosEmArquivo(nomeArquivo);
		}
		
		public void gravarQuestoesDissertativasEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.gravarQuestoesDissertativasEmArquivo(nomeArquivo);
		}
		
		public void lerQuestoesDissertativasDoArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.lerQuestoesDissertativasDoArquivo(nomeArquivo);
		}
		
		public void gravarQuestoesObjetivasEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.gravarQuestoesObjetivasEmArquivo(nomeArquivo);
		}
		
		public void lerQuestoesObjetivasDoArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.lerQuestoesObjetivasDoArquivo(nomeArquivo);
		}
		
		public void gravarQuestoesVouFEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.gravarQuestoesVouFEmArquivo(nomeArquivo);
		}
		
		public void gravarQuestoesVouFDoArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.gravarQuestoesVouFEmArquivo(nomeArquivo);
		}
		
		public void lerQuestoesVouFDoArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeQuestoes.lerQuestoesVouFDoArquivo(nomeArquivo);
		}
		
		public void gravarExerciciosEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeExercicios.gravarExerciciosEmArquivo(nomeArquivo);
		}
		
		public void lerExerciciosEmArquivo(String nomeArquivo) throws IOException {
			this.gerenteDeExercicios.lerExerciciosEmArquivo(nomeArquivo);
		}
}
