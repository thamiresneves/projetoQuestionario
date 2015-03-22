package br.ufpb.projetopoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Persistencia implements Serializable{
	public void salvar(Fachada fachada) throws IOException{
		 
        try {
          FileOutputStream arquivoGravar = new FileOutputStream("Fachada");
          ObjectOutputStream objetoGravar = new ObjectOutputStream(arquivoGravar);

          objetoGravar.writeObject(fachada);
          objetoGravar.flush();
          objetoGravar.close();
          arquivoGravar.flush();
          arquivoGravar.close();
        } catch (Exception e){
          e.printStackTrace();
        }
 }
	
	public Fachada recuperaFachada() throws IOException{
	  	Fachada fachada = null;
         try {
                FileInputStream arquivoLeitura = new FileInputStream("Fachada");
                ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);

                // recupera o objeto
                fachada = (Fachada) objLeitura.readObject();

                objLeitura.close();
                arquivoLeitura.close();
                return fachada;
                
         } catch (Exception e) {
                return fachada = new Fachada();
         }

         
  }
	 

}


      


