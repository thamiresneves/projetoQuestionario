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

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	
	
	public TelaDeCadastro(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro:  ");
		lblCadastro.setBounds(189, 11, 98, 14);
		contentPane.add(lblCadastro);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite seu nome: ");
				String email = JOptionPane.showInputDialog("Digite seu email: ");
				try {
					fachada.cadastrarUsuario(nome, TipoDeUsuario.Aluno, email);
					JOptionPane.showMessageDialog(null, "O aluno: " +email+ " foi cadastrado com sucesso!");
					fachada.gravarNaPersistencia();
					JFrame TelaMenuAluno = new TelaMenuAluno(fachada);
					TelaMenuAluno.setVisible(true);
					setVisible(false);
				} catch (UsuarioJaExisteException e1) {
					JOptionPane.showMessageDialog(null, "Email ou usuário já existe.");
					JFrame TelaDeCadastro = new TelaDeCadastro(fachada);
					TelaDeCadastro.setVisible(true);
				}
			}
		});
		btnAluno.setBounds(56, 110, 126, 23);
		contentPane.add(btnAluno);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite seu nome: ");
				String email = JOptionPane.showInputDialog("Digite seu email: ");
				try {
					fachada.cadastrarUsuario(nome, TipoDeUsuario.Professor, email);
					JOptionPane.showMessageDialog(null, "O professor: " +email+ " foi cadastrado com sucesso!");
					JFrame MenuProfessor1 = new TelaMenuProfessor1(fachada);
					MenuProfessor1.setVisible(true);
					fachada.gravarNaPersistencia();
					setVisible(false);
					
				} catch (UsuarioJaExisteException e1) {
					JOptionPane.showMessageDialog(null, "Email ou usuário já existe.");
					JFrame TelaDeCadastro = new TelaDeCadastro(fachada);
					TelaDeCadastro.setVisible(true);
				}
				
			}
		});
		btnProfessor.setBounds(239, 110, 126, 23);
		contentPane.add(btnProfessor);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaDeCadastroOuLogin = new TelaDeCadastroOuLogin(fachada);
				TelaDeCadastroOuLogin.setVisible(true);
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
