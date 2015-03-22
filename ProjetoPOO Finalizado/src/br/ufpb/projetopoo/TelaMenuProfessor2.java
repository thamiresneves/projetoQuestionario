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

public class TelaMenuProfessor2 extends JFrame {

	private JPanel contentPane;

	public TelaMenuProfessor2(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuProfessor = new JLabel("Menu Professor");
		lblMenuProfessor.setBounds(186, 11, 174, 14);
		contentPane.add(lblMenuProfessor);
		
		JButton btnRemoverExerccio = new JButton("Remover Exerc\u00EDcio");
		btnRemoverExerccio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o nome do exercicio: ");
				try {
					fachada.removerExercicio(nome);
					JOptionPane.showMessageDialog(null, "O exercício: "+nome+" foi removido com sucesso!" );
				} catch (ExercicioInexistenteException e1) {
					JOptionPane.showMessageDialog(null, "O exercício: "+nome+" não existe!");
				}

			}
		});
		btnRemoverExerccio.setBounds(89, 98, 258, 23);
		contentPane.add(btnRemoverExerccio);
		
		JButton btnObterFeedback = new JButton("Obter Feedback");
		btnObterFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				try{
					JOptionPane.showMessageDialog(null,fachada.enviarFeedbackParaProfessor(fachada.obterExercicioPeloNome(nomeExercicio), fachada.getAluno()));	
				}catch(ExercicioInexistenteException e1){
					JOptionPane.showMessageDialog(null, "O exercício: "+nomeExercicio+" não existe!");
				}
				
				
			}
		});
		btnObterFeedback.setBounds(89, 132, 258, 23);
		contentPane.add(btnObterFeedback);
		
		JButton btnObterQuestesDo = new JButton("Obter quest\u00F5es do exerc\u00EDcio");
		btnObterQuestesDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				try {
					JOptionPane.showMessageDialog(null, fachada.obterQuestoesDoExercicio(nome,fachada.getGerenteDeQuestoes()));
				} catch (ExercicioInexistenteException e1){
					JOptionPane.showMessageDialog(null, "Não foram cadastradas questões para este exercício: "+nome);
				}
			}
		});
		btnObterQuestesDo.setBounds(89, 166, 258, 23);
		contentPane.add(btnObterQuestesDo);
		
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
		
		JButton btnAdicionarQuestes = new JButton("Adicionar Quest\u00F5es");
		btnAdicionarQuestes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaMenuQuestoes = new TelaMenuQuestoes(fachada);
				TelaMenuQuestoes.setVisible(true);
				setVisible(false);
				fachada.gravarNaPersistencia();
			}
		});
		btnAdicionarQuestes.setBounds(89, 64, 258, 23);
		contentPane.add(btnAdicionarQuestes);
		
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
