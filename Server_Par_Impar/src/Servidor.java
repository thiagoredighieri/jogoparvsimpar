import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;


public class Servidor extends JFrame {

	private JPanel contentPane;
	private JTextField tFEstado;
	private static Vector clientes;
	private Socket conexao;
	private ThreadLigar Tligar ;
	private PrintStream saida;
	private boolean estado;
	private String meuNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Servidor() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tFEstado = new JTextField();
		tFEstado.setBounds(20, 117, 119, 51);
		contentPane.add(tFEstado);
		tFEstado.setColumns(10);
		
		
		JButton btnLiga = new JButton("Liga");
		btnLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFEstado.setText("Ligado");
				estado = true;
				Tligar = new ThreadLigar(conexao);
				Tligar.start();
							
			}
		});
		btnLiga.setBounds(218, 28, 89, 49);
		contentPane.add(btnLiga);
		
		JButton btnDesliga = new JButton("Desliga");
		btnDesliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFEstado.setText("Desligado");
				estado = true;
				
				
				//Tligar.start();
				//System.exit(0);
				
				
			}
		});
		btnDesliga.setBounds(218, 115, 89, 55);
		contentPane.add(btnDesliga);
		
		
		JTextPane txtpnEstadoDoServidor = new JTextPane();
		txtpnEstadoDoServidor.setBackground(SystemColor.control);
		txtpnEstadoDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnEstadoDoServidor.setText("Estado do Servidor");
		txtpnEstadoDoServidor.setBounds(20, 80, 149, 20);
		contentPane.add(txtpnEstadoDoServidor);
		
		
		
	}
}
