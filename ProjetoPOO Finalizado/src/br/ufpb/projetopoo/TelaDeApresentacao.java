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
import javax.swing.JTextField;

public class TelaDeApresentacao extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private Fachada fachada;
	private TelaDeCadastroOuLogin tela2;
	
	
	public TelaDeApresentacao(Fachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeQuestes = new JLabel("Sistema de Quest\u00F5es");
		lblSistemaDeQuestes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSistemaDeQuestes.setBounds(119, 11, 214, 21);
		contentPane.add(lblSistemaDeQuestes);
		
		nome = new JTextField();
		nome.setBounds(139, 104, 232, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblDigiteOSeu = new JLabel("Digite o seu nome:");
		lblDigiteOSeu.setBounds(66, 72, 138, 21);
		contentPane.add(lblDigiteOSeu);
		
		JButton btnBoasVindas = new JButton("Boas Vindas!");
		btnBoasVindas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Olá, seja bem vindo ao Sistema de Questões "+nome.getText());
				JFrame TelaDeCadastroOuLogin = new TelaDeCadastroOuLogin(fachada);
				TelaDeCadastroOuLogin.setVisible(true);
				setVisible(false);
			}
		});
		btnBoasVindas.setBounds(162, 165, 110, 23);
		contentPane.add(btnBoasVindas);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBounds(335, 227, 89, 23);
		contentPane.add(btnSair);
	}
}
