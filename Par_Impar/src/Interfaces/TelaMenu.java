package Interfaces;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;


public class TelaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	public static TelaMenu FOpcao;
	private JTextField txtNome;
	private JRadioButton rbtnComputador, rbtnPlayers;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TelaMenu frame= new TelaMenu();
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
	public TelaMenu() {
		setTitle("Par ou Impar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtNome.setColumns(10);
		txtNome.setBounds(215, 246, 233, 53);
		contentPane.add(txtNome);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(TelaMenu.class.getResource("/imgs/play.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!txtNome.getText().trim().equals("")){
						if(rbtnComputador.isSelected()){
							TeladeJogada frame = new TeladeJogada(txtNome.getText());
							frame.setVisible(true);
						}else{
							TeladeJogadaRede frame2 = new TeladeJogadaRede(txtNome.getText());
							frame2.setEnabled(false);
							frame2.setFocusable(false);
							frame2.setVisible(true);
							TelaEspera frame1 = new TelaEspera(frame2);
							frame1.setVisible(true);
							
						}
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Digite um nome válido!");
					}
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setBounds(265, 340, 161, 70);
		contentPane.add(button);
		
		rbtnComputador = new JRadioButton("Computador");
		rbtnComputador.setBackground(new Color(255, 250, 250));
		rbtnComputador.setSelected(true);
		rbtnComputador.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnComputador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnComputador.setSelected(true);
				rbtnPlayers.setSelected(false);
			}
		});
		rbtnComputador.setBounds(106, 103, 216, 61);
		contentPane.add(rbtnComputador);
		
		rbtnPlayers = new JRadioButton("Players");
		rbtnPlayers.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnComputador.setSelected(false);
				rbtnPlayers.setSelected(true);
			}
		});
		rbtnPlayers.setBounds(383, 103, 199, 61);
		contentPane.add(rbtnPlayers);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaMenu.class.getResource("/imgs/par ou impar.png")));
		label_1.setBounds(0, 0, 713, 421);
		contentPane.add(label_1);
	}
}
