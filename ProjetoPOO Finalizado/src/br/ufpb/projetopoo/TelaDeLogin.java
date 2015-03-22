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

public class TelaDeLogin extends JFrame {
	
	private JPanel contentPane;
	
	public TelaDeLogin(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("Escolha uma op\u00E7\u00E3o: ");
		lblEscolhaUmaOpo.setBounds(162, 11, 233, 14);
		getContentPane().add(lblEscolhaUmaOpo);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = JOptionPane.showInputDialog("Digite o seu email: ");
				boolean logou = fachada.login(email, TipoDeUsuario.Aluno);
				if(logou){
					fachada.logar(fachada.pegarNomeDeUsuario(email, TipoDeUsuario.Aluno), TipoDeUsuario.Aluno, email);
					JFrame MenuAluno = new TelaMenuAluno(fachada);
					MenuAluno.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuário não existe!");
					JFrame TelaDeLogin = new TelaDeLogin(fachada);
					TelaDeLogin.setVisible(true);
				}
			}
		});
		btnAluno.setBounds(49, 109, 130, 23);
		getContentPane().add(btnAluno);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = JOptionPane.showInputDialog("Digite o seu email: ");
				boolean logou = fachada.login(email, TipoDeUsuario.Professor);
				if(logou){
					fachada.logar(fachada.pegarNomeDeUsuario(email, TipoDeUsuario.Professor), TipoDeUsuario.Professor, email);
					JFrame MenuAluno = new TelaMenuAluno(fachada);
					MenuAluno.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuário não existe!");
					JFrame TelaDeLogin = new TelaDeLogin(fachada);
					TelaDeLogin.setVisible(true);
				}
			}
		});
		btnProfessor.setBounds(257, 109, 138, 23);
		getContentPane().add(btnProfessor);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBounds(335, 227, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaDeCadastro = new TelaDeCadastro(fachada);
				TelaDeCadastro.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
