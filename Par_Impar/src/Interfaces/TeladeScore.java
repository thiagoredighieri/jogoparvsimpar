package Interfaces;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class TeladeScore extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeScore frame = new TeladeScore();
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
	public TeladeScore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResultadoFinal = new JLabel("Resultado Final");
		lblResultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblResultadoFinal.setBounds(39, 24, 289, 71);
		contentPane.add(lblResultadoFinal);
		
		JLabel lblFulanoGanhou = new JLabel("Fulano Ganhou");
		lblFulanoGanhou.setForeground(Color.RED);
		lblFulanoGanhou.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFulanoGanhou.setBounds(39, 127, 289, 71);
		contentPane.add(lblFulanoGanhou);
		
		JLabel lblVitorias = new JLabel("X Vitorias");
		lblVitorias.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblVitorias.setBounds(96, 214, 184, 71);
		contentPane.add(lblVitorias);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(222, 305, 106, 55);
		contentPane.add(btnNewButton);
	}

}
