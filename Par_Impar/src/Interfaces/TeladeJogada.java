package Interfaces;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;


public class TeladeJogada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel_2, panel_1;
	private JTextField textField;
	private JTextField txtVitPlayer1;
	private JTextField txtVitPlayer2;
	private JToggleButton tbtn00_1, tbtn01_1, tbtn02_1, tbtn03_1, tbtn04_1, tbtn05_1, tbtn00_2, tbtn01_2, tbtn02_2, tbtn03_2, tbtn04_2, tbtn05_2;
	private JRadioButton rbtnImpar, rbtnPar;
	private JButton btnPlay, btnAction, btnDesistir;
	private int escolha01, escolha02;
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
	
	
	public TeladeJogada(String _nome) {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				mudaStatusPanel(false,panel_2);
				mudaStatusPanel(false,panel_1);
			}
		});
		setTitle("Rodadas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPlay = new JButton("Play");
		btnPlay.setIcon(new ImageIcon(TeladeJogada.class.getResource("/imgs/play.png")));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDesistir.setEnabled(true);
				mudaStatusPanel(true, panel_1);
				mudaStatusBtn(false, panel_1);
				tbtn00_1.setSelected(true);
				btnPlay.setEnabled(false);
				btnAction.setEnabled(true);
			}
		});
		btnPlay.setBounds(327, 305, 148, 55);
		contentPane.add(btnPlay);
		
		JLabel lblRodada = new JLabel("Rodada");
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada.setBounds(243, 11, 95, 45);
		contentPane.add(lblRodada);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setText("1");
		textField.setEnabled(false);
		textField.setBounds(348, 15, 63, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnDesistir = new JButton("Desistir");
		btnDesistir.setIcon(new ImageIcon(TeladeJogada.class.getResource("/imgs/Exit.png")));
		btnDesistir.setEnabled(false);
		btnDesistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Você venceu "+txtVitPlayer1.getText()+" de "+textField.getText()+" partidas!");
				try {
					
					TelaMenu tela = new TelaMenu();
					tela.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnDesistir.setBounds(163, 305, 154, 55);
		contentPane.add(btnDesistir);
		
		JLabel lblVitorias = new JLabel("Vit\u00F3rias");
		lblVitorias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVitorias.setBounds(304, 59, 95, 45);
		contentPane.add(lblVitorias);
		
		txtVitPlayer1 = new JTextField();
		txtVitPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		txtVitPlayer1.setText("0");
		txtVitPlayer1.setEditable(false);
		txtVitPlayer1.setEnabled(false);
		txtVitPlayer1.setColumns(10);
		txtVitPlayer1.setBounds(241, 71, 53, 29);
		contentPane.add(txtVitPlayer1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Jogador: "+_nome, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 128, 361);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tbtn02_1 = new JToggleButton("");
		tbtn02_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/M\u00E3o2.png")));
		tbtn02_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterabtn(2,1);
			}
		});
		tbtn02_1.setBounds(10, 131, 96, 56);
		panel_1.add(tbtn02_1);
		
		tbtn03_1 = new JToggleButton("");
		tbtn03_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao3.png")));
		tbtn03_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterabtn(3,1);
			}
		});
		tbtn03_1.setBounds(10, 188, 96, 52);
		panel_1.add(tbtn03_1);
		
		tbtn04_1 = new JToggleButton("");
		tbtn04_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao4.png")));
		tbtn04_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterabtn(4,1);
			}
		});
		tbtn04_1.setBounds(10, 240, 96, 52);
		panel_1.add(tbtn04_1);
		
		tbtn01_1 = new JToggleButton("");
		tbtn01_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao1.png")));
		tbtn01_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterabtn(1,1);
			}
		});
		tbtn01_1.setBounds(10, 79, 96, 52);
		panel_1.add(tbtn01_1);
		
		tbtn05_1 = new JToggleButton("");
		tbtn05_1.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsEsq/Mao5.png")));
		tbtn05_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterabtn(5,1);
			}
		});
		tbtn05_1.setBounds(10, 292, 96, 52);
		panel_1.add(tbtn05_1);
		
		tbtn00_1 = new JToggleButton("");
		tbtn00_1.setIcon(new ImageIcon(TeladeJogada.class.getResource("/imgsEsq/Mao 0.png")));
		tbtn00_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterabtn(0,1);
//				alterar escolha de botões(Numero do botão escolhido, jogador escolhido)
			}
		});
		tbtn00_1.setBounds(10, 28, 96, 52);
		panel_1.add(tbtn00_1);
		
		txtVitPlayer2 = new JTextField();
		txtVitPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		txtVitPlayer2.setText("0");
		txtVitPlayer2.setEditable(false);
		txtVitPlayer2.setEnabled(false);
		txtVitPlayer2.setColumns(10);
		txtVitPlayer2.setBounds(388, 71, 53, 29);
		contentPane.add(txtVitPlayer2);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "PC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(539, 11, 128, 361);
		contentPane.add(panel_2);
		
		
		
		tbtn00_2 = new JToggleButton("");
		tbtn00_2.setIcon(new ImageIcon(TeladeJogada.class.getResource("/imgsDir/Mao 0.png")));
		tbtn00_2.setBounds(22, 29, 96, 51);
		panel_2.add(tbtn00_2);
		
		tbtn01_2 = new JToggleButton("");
		tbtn01_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao1.png")));
		tbtn01_2.setBounds(22, 80, 96, 57);
		panel_2.add(tbtn01_2);
		
		
		tbtn02_2 = new JToggleButton("");
		tbtn02_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/M\u00E3o2.png")));
		tbtn02_2.setBounds(22, 135, 96, 51);
		panel_2.add(tbtn02_2);
		
		tbtn03_2 = new JToggleButton("");
		tbtn03_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao3.png")));
		tbtn03_2.setBounds(22, 188, 96, 62);
		panel_2.add(tbtn03_2);
		
		tbtn04_2 = new JToggleButton("");
		tbtn04_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao4.png")));
		tbtn04_2.setBounds(22, 249, 96, 51);
		panel_2.add(tbtn04_2);
		
		tbtn05_2 = new JToggleButton("");
		tbtn05_2.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgsDir/Mao5.png")));
		tbtn05_2.setBounds(22, 299, 96, 51);
		panel_2.add(tbtn05_2);
		
		btnAction = new JButton("");
		btnAction.setEnabled(false);
		btnAction.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgs/Pronto.png")));
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jogadas, sum, aux;
				jogadas=Integer.parseInt(textField.getText());
				Random rdm = new Random();
				int num=rdm.nextInt(6);
				alterabtn(num,2);
				sum=escolha01+escolha02;
				if(sum%2==0){
					if(rbtnPar.isSelected()){
						aux=Integer.parseInt(txtVitPlayer1.getText());
						aux++;
						txtVitPlayer1.setText(String.valueOf(aux));
						JOptionPane.showMessageDialog(null, "Par ganhou!!! Aeeeeew muleeeeeke!!!\n" +
								"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
					}else{
						aux=Integer.parseInt(txtVitPlayer2.getText());
						aux++;
						txtVitPlayer2.setText(String.valueOf(aux));
						JOptionPane.showMessageDialog(null, "Par ganhou!!! Aff vey! Ta ganhando nem em par ou impar!!! --'\n" +
								"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
						
					}
					
					
				}else{
					if(rbtnImpar.isSelected()){
						aux=Integer.parseInt(txtVitPlayer1.getText());
						aux++;
						txtVitPlayer1.setText(String.valueOf(aux));
						JOptionPane.showMessageDialog(null, "Impar ganhou!!! Aeeeeew muleeeeeke!!!\n" +
								"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
					}else{
						aux=Integer.parseInt(txtVitPlayer2.getText());
						aux++;
						txtVitPlayer2.setText(String.valueOf(aux));
						
						JOptionPane.showMessageDialog(null, "Impar ganhou!!! Aff vey! Ta ganhando nem em par ou impar!!! --'\n" +
								"Jogador01 = "+escolha01+"   -    Jogador02 = "+escolha02);
					}
				}
				if(jogadas==3){
					JOptionPane.showMessageDialog(null, "Você venceu "+txtVitPlayer1.getText()+" de "+textField.getText()+" pratidas!");
					try {
						
						TelaMenu tela = new TelaMenu();
						tela.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					dispose();
					
				}
				aux=Integer.parseInt(textField.getText());
				aux++;
				textField.setText(String.valueOf(aux));
				
				
			}
		});
		btnAction.setBounds(273, 191, 154, 66);
		contentPane.add(btnAction);
		
		rbtnPar = new JRadioButton("PAR!!! o// ");
		rbtnPar.setSelected(true);
		rbtnPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnPar.setSelected(true);
				rbtnImpar.setSelected(false);
			}
		});
		rbtnPar.setBounds(213, 141, 109, 23);
		contentPane.add(rbtnPar);
		
		rbtnImpar = new JRadioButton("IMPAR!!! o// ");
		rbtnImpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnImpar.setSelected(true);
				rbtnPar.setSelected(false);
			}
		});
		rbtnImpar.setBounds(342, 141, 109, 23);
		contentPane.add(rbtnImpar);
		
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(TeladeJogadaRede.class.getResource("/imgs/tela de jogo.png")));
		label.setBounds(-1, 0, 683, 397);
		contentPane.add(label);
	}
	
	
	private void mudaStatusPanel(boolean bool, JPanel pane){
		for (Component comp : pane.getComponents()) {
			comp.setEnabled(bool);
		}
	}
	
	
	private void mudaStatusBtn(boolean bool, JPanel pane){

		for (Component comp : pane.getComponents()) {
			if ((comp.getClass().getSimpleName().equals("JToggleButton"))) {
				((JToggleButton) comp).setSelected(bool);
			}
		}
	}
	
	private void alterabtn(int num, int jogador){
		if(jogador==1){
			mudaStatusBtn(false, panel_1);
			switch (num){
			case 0:
				tbtn00_1.setSelected(true);
				escolha01 = 0;
//				tbtn00_2
				break;
			case 1:
				tbtn01_1.setSelected(true);
				escolha01 = 1;
//				tbtn01_2
				break;
			case 2:
				tbtn02_1.setSelected(true);
				escolha01 = 2;
//				tbtn02_2
				break;
			case 3:
				tbtn03_1.setSelected(true);
				escolha01 = 3;
//				tbtn03_2
				break;
			case 4:
				tbtn04_1.setSelected(true);
				escolha01 = 4;
//				tbtn04_2
				break;
			case 5:
				tbtn05_1.setSelected(true);
				escolha01 = 5;
//				tbtn05_2
				break;
			}
		}else{
			mudaStatusBtn(false, panel_2);
			switch (num){
			case 0:
				tbtn00_2.setSelected(true);
				escolha02 = 0;
//				tbtn00_2
				break;
			case 1:				
				tbtn01_2.setSelected(true);
				escolha02 = 1;
//				tbtn01_2
				break;
			case 2:
				tbtn02_2.setSelected(true);
				escolha02 = 2;
//				tbtn02_2
				break;
			case 3:
				tbtn03_2.setSelected(true);
				escolha02 = 3;
//				tbtn03_2
				break;
			case 4:
				tbtn04_2.setSelected(true);
				escolha02 = 4;
//				tbtn04_2
				break;
			case 5:
				tbtn05_2.setSelected(true);
				escolha02 = 5;
//				tbtn05_2
				break;
			}
		}
	}
}
