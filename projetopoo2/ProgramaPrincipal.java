package br.ufpb.projetopoo;
import javax.swing.JOptionPane;

public class ProgramaPrincipal {

	private static final TipoDeUsuario Aluno = null;

	public static void main(String[] args) {
		
		GerenteDeUsuario gerente = new GerenteDeUsuario();
		String nome = JOptionPane.showInputDialog("Digite o seu nome de usuário: ");
		System.out.println("Digite o tipo de usuário (Professor / Aluno): ");
		String email = JOptionPane.showInputDialog("Digite o seu email: ");
		
		/*
		try{
			//gerente.cadastrarUsuario(nome, tu, email);
			
			
			
		}//catch(UsuarioJaExisteException u){
			//System.out.println("OOps, não deveria exibir esta mensagem");
	//	}finally{
		
		}

	
*/	}

}
