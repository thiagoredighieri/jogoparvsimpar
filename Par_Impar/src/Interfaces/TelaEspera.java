package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEspera extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public TelaEspera(final TeladeJogadaRede frame2) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 383, 145);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAguardeAEntrada = new JLabel("Aguarde a entrada de um pr\u00F3ximo jogador");
		lblAguardeAEntrada.setFont(new Font("Arial", Font.BOLD, 16));
		lblAguardeAEntrada.setBounds(10, 27, 347, 19);
		contentPanel.add(lblAguardeAEntrada);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEntrar = new JButton("Entrar");
				btnEntrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame2.setFocusable(true);
						frame2.setEnabled(true);
						dispose();
					}
				});
				btnEntrar.setActionCommand("OK");
				buttonPane.add(btnEntrar);
				getRootPane().setDefaultButton(btnEntrar);
			}
			{
				JButton btnVoltar = new JButton("Voltar");
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame2.dispose();
						try {
							TelaMenu tela = new TelaMenu();
							tela.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
				btnVoltar.setActionCommand("Cancel");
				buttonPane.add(btnVoltar);
			}
		}
	}
}
