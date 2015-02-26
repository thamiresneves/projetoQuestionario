package br.ufpb.projetopoo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame{
	
	    JButton b1, b2;
	    JLabel linha1, linha2;
	    
	    public TelaPrincipal(){
	        setTitle("Cadastrar Questão");
	        setSize(600, 400); //tamanho da janela
	        setLocation(150, 150);  
	        setResizable(false);
	        	        
	        b1 = new JButton("Dissertativa");
	        b2 = new JButton("Objetiva"); 
	        
	        b1.setBackground(Color.WHITE);
	        b2.setBackground(Color.PINK);
	        
	               	        
	        getContentPane().setLayout(new GridLayout(2, 1));         
	        getContentPane().add(b1);
	        getContentPane().add(b2);
	       
	   }


}
