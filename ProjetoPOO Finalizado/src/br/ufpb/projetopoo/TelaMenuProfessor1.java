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

public class TelaMenuProfessor1 extends JFrame {

	private JPanel contentPane;

	public TelaMenuProfessor1(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuProfessor = new JLabel("Menu Professor");
		lblMenuProfessor.setBounds(194, 11, 132, 14);
		contentPane.add(lblMenuProfessor);
		
		JButton btnCadastrarExerccio = new JButton("Cadastrar Exerc\u00EDcio");
		btnCadastrarExerccio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício: ");
				try {
					Exercicio e1 = new Exercicio(nomeExercicio);
					fachada.cadastrarExercicio(e1);
					JOptionPane.showMessageDialog(null, "Exercício " + nomeExercicio+ " cadastrado com sucesso!");
					
					JFrame TelaMenuQuestoes = new TelaMenuQuestoes(fachada);
					TelaMenuQuestoes.setVisible(true);
					fachada.gravarNaPersistencia();
					setVisible(false);
				}catch (ExercicioJaExisteException e1) {
					JOptionPane.showMessageDialog(null, "Este exercício já foi cadastrado!");
					JFrame MenuProfessor1 = new TelaMenuProfessor1(fachada);
					MenuProfessor1.setVisible(true);
				}
				
			}
		});
		btnCadastrarExerccio.setBounds(142, 80, 184, 23);
		contentPane.add(btnCadastrarExerccio);
		
		JButton btnGerenciarExerccio = new JButton("Gerenciar Exerc\u00EDcio");
		btnGerenciarExerccio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaMenuProfessor2 = new TelaMenuProfessor2(fachada);
				TelaMenuProfessor2.setVisible(true);
				setVisible(false);
				
			}
		});
		btnGerenciarExerccio.setBounds(142, 179, 184, 23);
		contentPane.add(btnGerenciarExerccio);
		
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
