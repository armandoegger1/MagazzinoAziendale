package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataScheda extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldNomeScheda;
	/**
	 * Create the frame.
	 */
	public SchermataScheda(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[145.00,center][163.00,center][179.00,grow,center][]", "[][][][][][][][]"));
		
		JLabel lblScheda = new JLabel("Creazione Scheda");
		lblScheda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblScheda, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("Nome Scheda");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1, "cell 0 3");
		
		textFieldNomeScheda = new JTextField();
		textFieldNomeScheda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textFieldNomeScheda, "cell 2 3,growx");
		textFieldNomeScheda.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAnnulla, "cell 0 7");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNomeScheda.getText().length() > 0) {
					
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci il nome della scheda", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		btnProsegui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnProsegui, "cell 2 7");
	}

}
