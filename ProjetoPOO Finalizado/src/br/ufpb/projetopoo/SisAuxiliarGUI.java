package br.ufpb.projetopoo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SisAuxiliarGUI implements Serializable{
	
	Fachada fachada = new Fachada();
	
	
	public String iniciarGUI() throws  IOException{
		this.fachada = fachada.recuperaFachada();
		
		JFrame TelaApresentacao1 = new TelaDeApresentacao(fachada);
		TelaApresentacao1.setVisible(true);
		WindowListener fechadorDeJanelaPrincipal = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				
				System.exit(0);
			}
		};
		TelaApresentacao1.addWindowListener(fechadorDeJanelaPrincipal);
		
		return "";
		

	}
}
