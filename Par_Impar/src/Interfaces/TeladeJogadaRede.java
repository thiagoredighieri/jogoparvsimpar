package Interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TeladeJogadaRede extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPanel panel_2;
	private JPanel panel_1;
	private static JTextField textField;
	private static JTextField txtVitPlayer1;
	private static JTextField txtVitPlayer2;
	private JToggleButton  tbtn01_1, tbtn02_1, tbtn03_1, tbtn04_1, tbtn05_1, tbtn00_1;
	private static JToggleButton tbtn01_2,tbtn02_2,tbtn04_2,tbtn03_2,tbtn05_2, tbtn00_2;
	private static JToggleButton rbtnImpar,rbtnPar;
	private static int escolha01=-1;
	private static int escolha02=-1;
	private ThreadConexao thread; 
	private static String nomeP1, nomeP2 = "Player 2";
	private String opcao;
	private PrintStream saidaTeste;
	private  Socket conexao;
	private static JButton btnAction, btnPronto, btnEsperar;
	private JLabel label;
	


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeJogada frame = new TeladeJogada();
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

	public TeladeJogadaRede (String _nome) {
		setResizable(false);
		nomeP1=_nome;
		/*addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				//mudaStatusPanel(false, contentPane);
				mudaStatusPanel(true, panel_1);
				mudaStatusBtn(false, panel_1);
				tbtn00_1.setSelected(true);	
			}
		});*/
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				reinicia();
			}
		});
		setTitle("Rodadas");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 688, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JLabel lblRodada = new JLabel("Rodada");
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada.setBounds(247, 11, 95, 45);
		contentPane.add(lblRodada);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setText("1");
		textField.setEnabled(false);
		textField.setBounds(386, 15, 63, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblVitorias = new JLabel("Vit\u00F3rias");
		lblVitorias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVitorias.setBounds(270, 51, 95, 45);
		contentPane.add(lblVitorias);

		txtVitPlayer1 = new JTextField();
		txtVitPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		txtVitPlayer1.setText("0");
		txtVitPlayer1.setEditable(false);
		txtVitPlayer1.setEnabled(false);
		txtVitPlayer1.setColumns(10);
		txtVitPlayer1.setBounds(194, 67, 53, 29);
		contentPane.add(txtVitPlayer1);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Jogador: "+ nomeP1, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 0, 127, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		tbtn02_1 = new JToggleButton("");
		tbtn02_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/M\u00E3o2.png")));
		tbtn02_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolha(2);
			}
		});
		tbtn02_1.setBounds(10, 131, 96, 51);
		panel_1.add(tbtn02_1);

		tbtn03_1 = new JToggleButton("");
		tbtn03_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao3.png")));
		tbtn03_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolha(3);
			}
		});
		tbtn03_1.setBounds(10, 191, 96, 51);
		panel_1.add(tbtn03_1);

		tbtn04_1 = new JToggleButton("");
		tbtn04_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao4.png")));
		tbtn04_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolha(4);
			}
		});
		tbtn04_1.setBounds(10, 251, 96, 51);
		panel_1.add(tbtn04_1);

		tbtn01_1 = new JToggleButton("");
		tbtn01_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao1.png")));
		tbtn01_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolha(1);
			}
		});
		tbtn01_1.setBounds(10, 71, 96, 51);
		panel_1.add(tbtn01_1);

		tbtn05_1 = new JToggleButton("");
		tbtn05_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao5.png")));
		tbtn05_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolha(5);
			}
		});
		tbtn05_1.setBounds(10, 311, 96, 51);
		panel_1.add(tbtn05_1);
		
		tbtn00_1 = new JToggleButton("");
		tbtn00_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolha(0);
			}
		});
		tbtn00_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao 0.png")));
		tbtn00_1.setBounds(10, 11, 96, 51);
		panel_1.add(tbtn00_1);
		
		btnPronto = new JButton("Pronto!");
		btnPronto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					int op = Integer.parseInt(opcao);
					saidaTeste.println(opcao);
					opcao="";
					if(op<6){
						btnPronto.setSelected(false);
						btnAction.setEnabled(true);
						mudaStatusBtn(false, panel_1);
					}
				}catch(Exception e){
					System.out.print("Erro na alteração de informações");
				}
			}
		});
		btnPronto.setBounds(17, 371, 89, 23);
		panel_1.add(btnPronto);


		txtVitPlayer2 = new JTextField();
		txtVitPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		txtVitPlayer2.setText("0");
		txtVitPlayer2.setEditable(false);
		txtVitPlayer2.setEnabled(false);
		txtVitPlayer2.setColumns(10);
		txtVitPlayer2.setBounds(396, 67, 53, 29);
		contentPane.add(txtVitPlayer2);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Jogador " + nomeP2, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(499, 0, 127, 408);
		contentPane.add(panel_2);



		tbtn01_2 = new JToggleButton("");
		tbtn01_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao1.png")));
		tbtn01_2.setBounds(21, 71, 96, 51);
		panel_2.add(tbtn01_2);


		tbtn02_2 = new JToggleButton("");
		tbtn02_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/M\u00E3o2.png")));
		tbtn02_2.setBounds(21, 131, 96, 51);
		panel_2.add(tbtn02_2);

		tbtn03_2 = new JToggleButton("");
		tbtn03_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao3.png")));
		tbtn03_2.setBounds(21, 191, 96, 51);
		panel_2.add(tbtn03_2);

		tbtn04_2 = new JToggleButton("");
		tbtn04_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao4.png")));
		tbtn04_2.setBounds(21, 251, 96, 51);
		panel_2.add(tbtn04_2);

		tbtn05_2 = new JToggleButton("");
		tbtn05_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao5.png")));
		tbtn05_2.setBounds(21, 311, 96, 51);
		panel_2.add(tbtn05_2);
		
		tbtn00_2 = new JToggleButton("");
		tbtn00_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao 0.png")));
		tbtn00_2.setBounds(21, 11, 96, 51);
		panel_2.add(tbtn00_2);
		
		btnEsperar = new JButton("Esperar!");
		btnEsperar.setBounds(21, 371, 89, 23);
		panel_2.add(btnEsperar);


		rbtnPar = new JToggleButton("\\o PAR!!!");
		rbtnPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnPar.setSelected(true);
				rbtnImpar.setSelected(false);
				opcao="8";
			}
		});
		rbtnPar.setBounds(188, 141, 109, 23);
		contentPane.add(rbtnPar);
		rbtnImpar = new JToggleButton("IMPAR!!! o//");
		rbtnImpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnPar.setSelected(false);
				rbtnImpar.setSelected(true);
				opcao="7";
			}
		});
		rbtnImpar.setBounds(371, 141, 109, 23);
		contentPane.add(rbtnImpar);
		
		
		btnAction = new JButton("");
		btnAction.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgs/Pronto.png")));
		btnAction.setEnabled(false);
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(escolha01!=-1&&escolha02!=-1){
					alteraP2(escolha02);
					comparaEscolha();
					opcao="";
					reinicia();
				}else{
					JOptionPane.showMessageDialog(null,"Aguarde a jogada do Player 2!");
				}
				
				
			}
		});
		btnAction.setBounds(259, 199, 141, 65);
		contentPane.add(btnAction);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgs/tela de jogo.png")));
		label.setBounds(-1, 0, 683, 424);
		contentPane.add(label);
		
		
		
		try{
			conexao = new Socket("127.0.0.1", 2222);
			saidaTeste = new PrintStream(conexao.getOutputStream());
			saidaTeste.println(_nome);
			thread = new ThreadConexao(conexao);
			
			thread.start();

		}catch(Exception e3){
			e3.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro nas THREADS do sistema");
		}
	}


	private void mudaStatusPanel(boolean bool, JPanel pane){
		for (Component comp : pane.getComponents()) {
			comp.setEnabled(bool);
			if ((comp.getClass().getSimpleName().equals("JLabel"))) {
				((JLabel) comp).setEnabled(true);
			}
			btnPronto.setEnabled(true);
		}
	}


	private static void mudaStatusBtn(boolean bool, JPanel pane){

		for (Component comp : pane.getComponents()) {
			if ((comp.getClass().getSimpleName().equals("JToggleButton"))) {
				((JToggleButton) comp).setSelected(bool);
			}
		}

	}

	private void alteraP1(int num){
		mudaStatusBtn(false, panel_1);
		switch (num){
		case 0:				
			tbtn00_1.setSelected(true);
			break;
		case 1:				
			tbtn01_1.setSelected(true);
			break;
		case 2:
			tbtn02_1.setSelected(true);
			break;
		case 3:
			tbtn03_1.setSelected(true);
			break;
		case 4:
			tbtn04_1.setSelected(true);
			break;
		case 5:
			tbtn05_1.setSelected(true);
			break;

		}
		mudaStatusPanel(false, panel_1);
		escolha01 = num;
		btnAction.setEnabled(true);
	

		
	}
	private static void alteraP2(int num){
		mudaStatusBtn(false, panel_2);
		switch (num){
		case 0:				
			tbtn00_2.setSelected(true);
			
			break;
		case 1:				
			tbtn01_2.setSelected(true);
			
			break;
		case 2:
			tbtn02_2.setSelected(true);
			break;
		case 3:
			tbtn03_2.setSelected(true);
			break;
		case 4:
			tbtn04_2.setSelected(true);
			break;
		case 5:
			tbtn05_2.setSelected(true);
			break;

		}
		escolha02 = num;
	}

	public static int getEscolha02() {
		return escolha02;
	}


	public  void setEscolha02(int escolha02) {
		TeladeJogadaRede.escolha02 = escolha02;
	}

	public static void recebeString(String entrada){
		int btn = Integer.parseInt(entrada);
		System.out.print("Entrada:" +entrada+ "Botao"+ btn);
		switch (btn){
		case 0:
			escolha02=0;
			btnEsperar.setSelected(true);
			break;

		case 1:
			escolha02=1;
			btnEsperar.setSelected(true);
			break;
		case 2:
			escolha02=2;
			btnEsperar.setSelected(true);
			break;
		case 3:
			escolha02=3;
			btnEsperar.setSelected(true);
			break;
		case 4: 
			escolha02=4;
			btnEsperar.setSelected(true);
			break;
		case 5:
			escolha02=5;
			btnEsperar.setSelected(true);
			break;
		case 6:
			//saidaTeste.print("6");
			fimDoJogo();
			break;
		case 7:
			rbtnImpar.setSelected(false);
			rbtnPar.setSelected(true);
			break;
		case 8:
			rbtnImpar.setSelected(true);
			rbtnPar.setSelected(false);
			break;
		}
	}
	protected static int getEscolha01() {
		return escolha01;
	}


	protected static void setEscolha01(int escolha01) {
		TeladeJogadaRede.escolha01 = escolha01;
	}


	private static void fimDoJogo(){
		JOptionPane.showMessageDialog(null, "Você venceu "+txtVitPlayer1.getText()+" de "+textField.getText()+" partidas!");
		try { 
			//saidaTeste.print("6");
			TelaMenu tela = new TelaMenu();
			tela.setVisible(true);
			//conexao.close();
		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}
	private static void comparaEscolha(){
		int sum,aux,jogadas=0;
		jogadas = Integer.parseInt(textField.getText());
		sum=escolha01+escolha02;
		if(sum%2==0){
			if(rbtnPar.isSelected()){
				aux=Integer.parseInt(txtVitPlayer1.getText());
				aux++;
				txtVitPlayer1.setText(String.valueOf(aux));
				JOptionPane.showMessageDialog(null, "Par ganhou!!! Você ganhou! ;D!\n" +
						"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
			}else{
				aux=Integer.parseInt(txtVitPlayer2.getText());
				aux++;
				txtVitPlayer2.setText(String.valueOf(aux));
				JOptionPane.showMessageDialog(null, "Par ganhou!!! Você perdeu! --'\n" +
						"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);

			}


		}else{
			if(rbtnImpar.isSelected()){
				aux=Integer.parseInt(txtVitPlayer1.getText());
				aux++;
				txtVitPlayer1.setText(String.valueOf(aux));
				JOptionPane.showMessageDialog(null, "Impar ganhou!!! Você ganhou! ;D\n" +
						"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
			}else{
				aux=Integer.parseInt(txtVitPlayer2.getText());
				aux++;
				txtVitPlayer2.setText(String.valueOf(aux));

				JOptionPane.showMessageDialog(null, "Impar ganhou!!! Você perdeu! --'\n" +
						"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
			}
		}
		if(jogadas==3){
			fimDoJogo();
			//conexao.close();
		}
		aux=Integer.parseInt(textField.getText());
		aux++;
		textField.setText(String.valueOf(aux));
		
	}
	private void escolha(int num){
		if(rbtnPar.isSelected()||rbtnImpar.isSelected()){
			alteraP1(num);
			opcao = String.valueOf(num);
		}else{
			JOptionPane.showMessageDialog(null, "Escolha um operador [ PAR - IMPAR ]");
		}
	}
	
	private void reinicia(){
		mudaStatusPanel(true, contentPane);
		mudaStatusPanel(false,panel_2);
		mudaStatusPanel(true,panel_1);
		btnAction.setEnabled(false);
		btnPronto.setEnabled(true);
		escolha01=-1;
		escolha02=-1;
	}
	
}
