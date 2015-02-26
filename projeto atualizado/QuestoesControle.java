package br.ufpb.projetopoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class QuestoesControle implements ActionListener{
	
	Fachada fachada;
	JFrame janelaPrincipal;

	public QuestoesControle (Fachada fachada, JFrame janelaPrincipal){
		this.fachada = fachada;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
