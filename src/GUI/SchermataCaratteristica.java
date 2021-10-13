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
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataCaratteristica extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldDescrizione;
	private JTextField textFieldNome;

	/**
	 * Create the frame.
	 */
	public SchermataCaratteristica(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[134.00,center][136.00,center][152.00,grow,center]", "[][][][][][][][]"));
		
		JLabel lblCaratteristica = new JLabel("Creazione Caratteristica");
		lblCaratteristica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblCaratteristica, "cell 1 0");
		
		JLabel lblNomeCaratteristica = new JLabel("Nome Caratteristica");
		lblNomeCaratteristica.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNomeCaratteristica, "cell 0 1");
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textFieldNome, "cell 2 1,growx");
		textFieldNome.setColumns(10);
		
		JLabel lblValore = new JLabel("Valore");
		lblValore.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblValore, "cell 0 3");
		
		JFormattedTextField formattedTextFieldValore = new JFormattedTextField();
		formattedTextFieldValore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(formattedTextFieldValore, "cell 2 3,growx");
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblDescrizione, "cell 0 5");
		
		textFieldDescrizione = new JTextField();
		textFieldDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textFieldDescrizione, "cell 2 5,growx");
		textFieldDescrizione.setColumns(10);
		
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
				
				if(textFieldNome.getText().length() > 0 && formattedTextFieldValore.getText().length() > 0) {
					
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Campi in grassetto vuoti!", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		btnProsegui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnProsegui, "cell 2 7");
	}

}
