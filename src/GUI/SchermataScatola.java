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
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataScatola extends JFrame {

	private JPanel contentPane;
	Main controller;
	JFrame frameCorrente;
	private JTextField textFieldNomeScatola;
	/**
	 * Create the frame.
	 */
	public SchermataScatola(Main controller) {
		setResizable(false);
		frameCorrente = this;
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[128.00,grow,center][115.00,center][grow,center][]", "[][][][][][][][][]"));
		
		JLabel lblScatola = new JLabel("Creazione Scatola");
		lblScatola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblScatola, "cell 1 0");
		
		JLabel lblNumeroScatola = new JLabel("Numero Scatola");
		lblNumeroScatola.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNumeroScatola, "cell 0 2");
		
		JFormattedTextField formattedTextFieldNumeroScatola = new JFormattedTextField();
		contentPane.add(formattedTextFieldNumeroScatola, "cell 2 2,growx");
		
		JLabel lblDescrizioneScatola = new JLabel("Descrizione Scatola");
		lblDescrizioneScatola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblDescrizioneScatola, "cell 0 5");
		
		textFieldNomeScatola = new JTextField();
		contentPane.add(textFieldNomeScatola, "cell 2 5,growx");
		textFieldNomeScatola.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAnnulla, "cell 0 8");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(formattedTextFieldNumeroScatola.getText().length() > 0) {
					
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci almeno un valore numerico per indicare il numero dello scatolo", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		btnProsegui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnProsegui, "cell 2 8");
	}

}
