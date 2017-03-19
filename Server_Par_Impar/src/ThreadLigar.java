
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class ThreadLigar  extends Thread {

	private static boolean estado;
	//private static Vector clientes;
	private static Socket conexao;
	
	private volatile  boolean fim = false;  
	
	public ThreadLigar(Socket s) {
		super();
	
		conexao = s;
	
		
	}

	public void run(){
		
	
		
			try
			{
				// criando um socket que fica escutando a porta 2222.
				ServerSocket s = new ServerSocket(2000);
				
				
				
				// Loop principal.
				while (!fim){
					// aguarda algum cliente se conectar. A execução do
					// servidor fica bloqueada na chamada do método accept da
					// classe ServerSocket. Quando algum cliente se conectar
					// ao servidor, o método desbloqueia e retorna com um
					// objeto da classe Socket, que é porta da comunicação.
					System.out.print("Esperando alguem se conectar...");
					
					Socket conexao = s.accept();
					System.out.println(" Conectou!");
					
					ThreadServidor.inicio(conexao);
					

					// cria uma nova thread para tratar essa conexão
					

					// voltando ao loop, esperando mais alguém se conectar.
				}
			}
			
			catch (IOException e)
			{
				// caso ocorra alguma excessão de E/S, mostre qual foi.
				System.out.println("IOException: " + e);
			}
			
		
		
	}
		
		

	
	public  void setFim() { 
		
	    fim = true; 
	    System.out.println("Desligou" + fim);
	}  

	
	

}
