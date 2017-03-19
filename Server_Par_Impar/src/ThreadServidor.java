

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JOptionPane;


public class ThreadServidor extends Thread{
	
	private Socket conexao;
	private static Vector clientes;

	
	private String meuNome;
	
	public ThreadServidor(Socket s) {
		super();
		this.conexao = s;
	}
	
	public static void inicio (Socket s){
		clientes = new Vector();
		Thread t = new ThreadServidor(s);
		t.start();

	}
	
	public void run()	{
		
		try	{
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			
			meuNome = entrada.readLine();
			
			if (meuNome == null) {return;}
			
			clientes.add(saida);
			
			//= String.valueOf(clientes.indexOf(saida));// = entrada.readLine();
			/*meuNome=linha;
			send(saida, linha);
			
			for(PrintStream e : clientes){
				if(!e.equals(saida)){
					e.println(meuNome);
				}
			}*/
//			send(saida, linha);
			
			
			
			
			String linha = entrada.readLine();
			
			while(!(linha.trim().equals("6"))){
				
				sendToall(saida, linha);
				
				linha = entrada.readLine();
				
				System.out.println("Me mandou isso servidor" + linha);
				
				
//				JOptionPane.showMessageDialog(null,linha);
			}
		sendToall(saida, "6");
		
		clientes.remove(saida);
		conexao.close();
		}
		catch (IOException e){
			System.out.print("IOException: " + e);
		}
	}

	public void sendToall(PrintStream saida, String linha) throws IOException{
		Enumeration e = clientes.elements();
		System.out.print("Valor" + linha);
		
		while (e.hasMoreElements())	{
			PrintStream nome = (PrintStream) e.nextElement();
			
			if (nome != saida){
				
				nome.println(meuNome + linha);
			}
		}
	}	
}


