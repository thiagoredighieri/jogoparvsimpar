package Interfaces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;


public class ThreadConexao extends Thread{
	private Socket conexao;
	

	public ThreadConexao(Socket _socket){
		this.conexao = _socket;
	}

	public void run(){

		
		try{
			
			BufferedReader entrada = new BufferedReader (new InputStreamReader(conexao.getInputStream()));
			String linha;
			
			while(true){
				linha = entrada.readLine();
				System.out.print("Na recepção: "+ linha+ "\n");
							
				
				TeladeJogadaRede.recebeString(linha);
			
				
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problemas na recepção de dados");
			System.exit(0);
		}
		
	}

}
