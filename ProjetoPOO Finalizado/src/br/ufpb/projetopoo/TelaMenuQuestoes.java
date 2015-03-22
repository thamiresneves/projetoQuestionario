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
import java.util.ArrayList;
import java.util.List;

public class TelaMenuQuestoes extends JFrame {

	private JPanel contentPane;

	public TelaMenuQuestoes(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuQuestes = new JLabel("Menu Quest\u00F5es");
		lblMenuQuestes.setBounds(192, 11, 153, 14);
		contentPane.add(lblMenuQuestes);
		
		JButton btnCadastrarQuestoDissertativa = new JButton("Cadastrar Quest\u00E3o Dissertativa");
		btnCadastrarQuestoDissertativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				long numDeQuestao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da questão: "));
				String pergunta = JOptionPane.showInputDialog("Digite a pergunta: ");
				String resposta = JOptionPane.showInputDialog("Digite a resposta: ");
				Exercicio e2 = fachada.obterExercicioPeloNome(nomeExercicio);
				try{
					QuestaoDissertativa qd = new QuestaoDissertativa(TipoDeQuestoes.Dissertativa, numDeQuestao, pergunta, resposta);
					fachada.cadastrarQuestaoDissertativa(e2, qd);
					e2.cadastrarQuestaoDissertativaNoExercicio(qd);
					JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!");
					fachada.gravarNaPersistencia();
					
				}catch(QuestaoJaExisteException q){
					JOptionPane.showMessageDialog(null, "Questão já existe para este exercício!");
					
				}
				
			}
		});
		btnCadastrarQuestoDissertativa.setBounds(91, 49, 254, 23);
		contentPane.add(btnCadastrarQuestoDissertativa);
		
		JButton btnCadastrarQuestoObjetiva = new JButton("Cadastrar Quest\u00E3o Objetiva");
		btnCadastrarQuestoObjetiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				long numDeQuestao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da questão: "));
				String pergunta = JOptionPane.showInputDialog("Digite a pergunta: ");
				int quantAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de alternativas a cadastrar: "));
				List<String> alternativas = new ArrayList<String>();
				for(int k = 0; k<quantAlternativas; k++){
					String alternativa = JOptionPane.showInputDialog("Digite a alternativa: exemplo: d)hardware");
					alternativas.add(alternativa);					
				}
				String resposta = JOptionPane.showInputDialog("Digite a resposta: ");
				Exercicio e2 = fachada.obterExercicioPeloNome(nomeExercicio);
				
				try{
					QuestaoObjetiva qO = new QuestaoObjetiva(TipoDeQuestoes.Objetiva, numDeQuestao, pergunta, resposta, alternativas);
					fachada.cadastrarQuestaoObjetiva(e2, qO);
					e2.cadastrarQuestaoObjetivaNoExercicio(qO);
					JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!");
					fachada.gravarNaPersistencia();
					
				}catch(QuestaoJaExisteException q){
					JOptionPane.showMessageDialog(null, "Esta questão já existe para este exercício!");	
				}
			}
		});
		btnCadastrarQuestoObjetiva.setBounds(91, 103, 254, 23);
		contentPane.add(btnCadastrarQuestoObjetiva);
		
		JButton btnCadastrarQuestoV = new JButton("Cadastrar Quest\u00E3o V ou F");
		btnCadastrarQuestoV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				long numDeQuestao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da questão: "));
				String pergunta = JOptionPane.showInputDialog("Digite a pergunta: ");
				String resposta = JOptionPane.showInputDialog("Digite a resposta: ");
				Exercicio e2 = fachada.obterExercicioPeloNome(nomeExercicio);
				try{
					QuestaoVouF qvf = new QuestaoVouF(TipoDeQuestoes.VouF, numDeQuestao, pergunta, resposta);
					fachada.cadastrarQuestaoVouF(e2, qvf);
					e2.cadastrarQuestaoVouFNoExercicio(qvf);
					JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!");
					fachada.gravarNaPersistencia();
					
				}catch(QuestaoJaExisteException q){
					JOptionPane.showMessageDialog(null, "Esta questão já existe!");	
				}
			}
				
		});
		btnCadastrarQuestoV.setBounds(91, 160, 254, 23);
		contentPane.add(btnCadastrarQuestoV);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaMenuProfessor1 = new TelaMenuProfessor1(fachada);
				TelaMenuProfessor1.setVisible(true);
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
