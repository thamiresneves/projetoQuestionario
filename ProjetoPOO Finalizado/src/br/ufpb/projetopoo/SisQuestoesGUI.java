package br.ufpb.projetopoo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class SisQuestoesGUI extends JFrame{
		
	public static void main(String[] args) {
			
		try{
			SisAuxiliarGUI sis = new SisAuxiliarGUI();
			sis.iniciarGUI();
		}
		catch (IOException e){
			
		}
		
	}

}
