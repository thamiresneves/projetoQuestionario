package br.ufpb.projetopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuAluno extends JFrame {

	private JPanel contentPane;

	public TelaMenuAluno(Fachada fachada) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuAluno = new JLabel("Menu Aluno");
		lblMenuAluno.setBounds(189, 11, 88, 14);
		contentPane.add(lblMenuAluno);
		
		JButton btnResponderExerccio = new JButton("Responder Exerc\u00EDcio");
		btnResponderExerccio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Exercicio e1: fachada.getExercicios()){
					JOptionPane.showMessageDialog(null, fachada.obterNomePeloExercicio(e1));
					String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exerício escolhido: ");
					String nomeAluno = JOptionPane.showInputDialog("Digite seu nome: ");
					if(e1.getNomeDeExercicio().equals(nomeExercicio) && e1 != null){
						Aluno a = fachada.obterAlunoPeloNome(nomeAluno);
						a.cadastrarExerciciosResolvidosDoAluno(e1);
						for(Questao q: e1.getQuestoes()){
							if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
								JOptionPane.showMessageDialog(null, q.getPergunta());
								String resposta = JOptionPane.showInputDialog("Digite a resposta: exemplo: d)resposta");
								a.adicionarResposta(resposta, q.getPergunta(), q.getNumDeQuestao(), nomeExercicio);
								fachada.gravarNaPersistencia();
							}else{
								JOptionPane.showMessageDialog(null, q.getPergunta());
								String resposta = JOptionPane.showInputDialog("Digite a resposta: ");
								a.adicionarResposta(resposta, q.getPergunta(), q.getNumDeQuestao(), nomeExercicio);
								fachada.gravarNaPersistencia();
								
							}
							
						}JOptionPane.showMessageDialog(null, "Pronto! Exercício resolvido com sucesso!");
					}
				}
			}
		});
		btnResponderExerccio.setBounds(145, 71, 159, 23);
		contentPane.add(btnResponderExerccio);
		
		JButton btnSortearExerccio = new JButton("Sortear Exerc\u00EDcio");
		btnSortearExerccio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String nomeExercicio = JOptionPane.showInputDialog(fachada.sortearExercicio(fachada.getExercicios()).getNomeDeExercicio());
				String nomeAluno = JOptionPane.showInputDialog("Digite seu nome: ");
				Aluno a = fachada.obterAlunoPeloNome(nomeAluno);
				Exercicio e1 = fachada.obterExercicioPeloNome(nomeExercicio);
				a.cadastrarExerciciosResolvidosDoAluno(e1);
				for(Questao q: e1.getQuestoes()){
					if(q.getTq().equals(TipoDeQuestoes.Objetiva)){
						JOptionPane.showMessageDialog(null, q.getPergunta());
						String resposta = JOptionPane.showInputDialog("Digite a resposta: exemplo: d)resposta");
						a.adicionarResposta(resposta, q.getPergunta(), q.getNumDeQuestao(), nomeExercicio);
						fachada.gravarNaPersistencia();
					}else{
						JOptionPane.showMessageDialog(null, q.getPergunta());
						String resposta = JOptionPane.showInputDialog("Digite a resposta: ");
						a.adicionarResposta(resposta, q.getPergunta(), q.getNumDeQuestao(), nomeExercicio);
						fachada.gravarNaPersistencia();
						
					}
				}JOptionPane.showMessageDialog(null, "Pronto! Exercício resolvido com sucesso!");
				
											
			}
				
		});
		btnSortearExerccio.setBounds(145, 120, 159, 23);
		contentPane.add(btnSortearExerccio);
		
		JButton btnReceberFeedback = new JButton("Receber Feedback");
		btnReceberFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				String nomeAluno = JOptionPane.showInputDialog("Digite seu nome: ");
				Aluno a = fachada.obterAlunoPeloNome(nomeAluno);
				try{
					JOptionPane.showMessageDialog(null,fachada.enviarFeedbackParaAluno(fachada.obterExercicioPeloNome(nomeExercicio), a, fachada.getGerenteDeQuestoes()));
					
				}catch(ExercicioInexistenteException e2){
					JOptionPane.showMessageDialog(null, "Você digitou um nome de exercício inválido!");
				}catch(QuestaoInexistenteException e3){
					JOptionPane.showMessageDialog(null, "Questão não cadastrada neste exercício");
				}
				
			}
		});
		btnReceberFeedback.setBounds(145, 167, 159, 23);
		contentPane.add(btnReceberFeedback);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaDeCadastro = new TelaDeCadastro(fachada);
				TelaDeCadastro.setVisible(true);
				setVisible(false);
				fachada.gravarNaPersistencia();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				fachada.gravarNaPersistencia();
			}
		});
		btnSair.setBounds(335, 227, 89, 23);
		contentPane.add(btnSair);
	}

	

}
