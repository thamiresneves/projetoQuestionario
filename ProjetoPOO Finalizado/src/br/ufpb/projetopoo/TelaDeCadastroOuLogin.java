package br.ufpb.projetopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeCadastroOuLogin extends JFrame {

	private JPanel contentPane;
	private Fachada fachada;

	public TelaDeCadastroOuLogin(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeQuestes = new JLabel("Sistema de Quest\u00F5es");
		lblSistemaDeQuestes.setBounds(165, 11, 172, 25);
		contentPane.add(lblSistemaDeQuestes);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaDeCadastro = new TelaDeCadastro(fachada);
				TelaDeCadastro.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrar.setBounds(54, 110, 102, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnFazerLogin = new JButton("Fazer Login");
		btnFazerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = JOptionPane.showInputDialog("Digite o seu email: ");
				if(fachada.login(email, TipoDeUsuario.Professor)){
					fachada.logar(fachada.pegarNomeDeUsuario(email, TipoDeUsuario.Professor), TipoDeUsuario.Professor, email);
					if(fachada.validarUsuario(email, TipoDeUsuario.Professor)){
						JFrame TelaMenuProfessor1 = new TelaMenuProfessor1(fachada);
						TelaMenuProfessor1.setVisible(true);
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Você digitou um email inválido!");
					}
				}else{
					fachada.login(email, TipoDeUsuario.Aluno);
					fachada.logar(fachada.pegarNomeDeUsuario(email, TipoDeUsuario.Aluno), TipoDeUsuario.Aluno, email);
					if(fachada.validarUsuario(email, TipoDeUsuario.Aluno)){
						JFrame TelaMenuAluno = new TelaMenuAluno(fachada);
						TelaMenuAluno.setVisible(true);
						setVisible(false);
						
					}else{
						JOptionPane.showMessageDialog(null, "Você digitou um email inválido!");
					}
			
				}
			}
		});
		btnFazerLogin.setBounds(279, 110, 102, 23);
		contentPane.add(btnFazerLogin);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame TelaDeApresentacao = new TelaDeApresentacao(fachada);
				TelaDeApresentacao.setVisible(true);
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
