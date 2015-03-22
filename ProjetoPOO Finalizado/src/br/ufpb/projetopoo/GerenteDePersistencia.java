package br.ufpb.projetopoo;

import java.io.IOException;
import java.io.Serializable;

public class GerenteDePersistencia implements Serializable{
	private Persistencia gravador = new Persistencia();

	public void gravarNaPersistencia(Fachada fachada){
		try{
			this.gravador.salvar(fachada);
		}
		catch(IOException e){
			System.err.println ("Deu erro. Não salvou");
		}
	}
	
	public Fachada recuperaFachada(){
		try{
			return this.gravador.recuperaFachada();
			
		}catch(IOException e){
			return new Fachada();
		}
	}
}
